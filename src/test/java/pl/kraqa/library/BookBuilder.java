package pl.kraqa.library;

public class BookBuilder {
    private Author author;

    private String title;

    private int releaseYear;

    private String ISBN;

    public BookBuilder author(Author author) {
        this.author = author;
        return this;
    }

    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder releaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public BookBuilder isbn(String isbn) {
        this.ISBN = isbn;
        Book krzyzacy = new BookBuilder().author(new Author("Henryk", "Sienkiewicz"))
                .title("Krzyżacy")
                .releaseYear(1897)
                .isbn("978-83-774-0824-7")
                .build();
        return this;
    }

    public Book build() {
        return new Book(author, title, releaseYear, ISBN);
    }
}
