package pl.kraqa.library;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private HashMap<String, Book> books = new HashMap<>();

    private HashMap<String, List<String>> titleIndex = new HashMap<>();

    private HashMap<Author, List<String>> authorIndex = new HashMap<>();

    private HashMap<String, List<Copy>> copies = new HashMap<>();

    private List<Waitlist> waitlists = new ArrayList<>();

    public void addBook(Book book) {
        books.put(book.getISBN(), book);

        titleIndex.putIfAbsent(book.getTitle(), new ArrayList<>());
        titleIndex.get(book.getTitle()).add(book.getISBN());

        authorIndex.putIfAbsent(book.getAuthor(), new ArrayList<>());
        authorIndex.get(book.getAuthor()).add(book.getISBN());
    }

    public void addCopy(String isbn) {
        if (!books.containsKey(isbn)) {
            throw new RuntimeException("There is no book with provided ISBN in the Library");
        }

        copies.putIfAbsent(isbn, new ArrayList<>());
        copies.get(isbn).add(new Copy(isbn));
    }

    public List<Book> findByTitle(String title) {
        if (!titleIndex.containsKey(title)) {
            return new ArrayList<>();
        }

        return titleIndex.get(title).stream()
                .map(isbn -> books.getOrDefault(isbn, null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<Book> findByAuthor(Author author) {
        if (!authorIndex.containsKey(author)) {
            return new ArrayList<>();
        }

        return authorIndex.get(author).stream()
                .map(isbn -> books.getOrDefault(isbn, null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public Map<Author, List<Book>> getAllBooksByAuthors() {
        return authorIndex.keySet().stream().collect(Collectors.toMap(
                author -> author,
                author -> authorIndex.get(author).stream().map(isbn -> books.get(isbn)).collect(Collectors.toList())
        ));
    }

    public boolean isAvailable(Book book) {
        if (!copies.containsKey(book.getISBN())) {
            return false;
        }

        return copies.get(book.getISBN()).stream()
                .anyMatch(copy -> copy.getStatus() == Status.AVAILABLE);
    }

    public void borrow(Book book) {
        if (isAvailable(book)) {
            copies.get(book.getISBN()).stream()
                    .filter(copy -> copy.getStatus().equals(Status.AVAILABLE))
                    .findFirst()
                    .orElseThrow()
                    .setStatus(Status.BORROWED);
        }
    }

    public void createWaitlist(Waitlist waitlist) {
        this.waitlists.add(waitlist);
    }

    public void returnBook(Book book) {
        this.copies.get(book.getISBN()).stream()
                .filter(copy -> copy.getStatus().equals(Status.BORROWED))
                .findFirst().get()
                .setStatus(Status.AVAILABLE);

        waitlists.stream()
                .filter(waitlist -> waitlist.getBook().getISBN().equals(book.getISBN()))
                .forEach(Waitlist::onBookReturned);
    }
}
