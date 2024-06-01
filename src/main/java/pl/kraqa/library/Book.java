package pl.kraqa.library;

public class Book {
    private final Author author;

    private final String title;

    private final int releaseYear;

    private final String ISBN;

    private String subtitle;

    private int tome;

    private String publishingHouse;


    public Book(Author author, String title, int releaseYear, String ISBN) {
        this.author = author;
        this.title = title;
        this.releaseYear = releaseYear;
        this.ISBN = ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getISBN() {
        return ISBN;
    }
}
