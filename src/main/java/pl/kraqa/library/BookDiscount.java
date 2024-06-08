package pl.kraqa.library;

public class BookDiscount {
    Book book;
    float percentage;

    public BookDiscount(Book book, float percentage) {
        this.book = book;
        this.percentage = percentage;
    }

    public Book getBook() {
        return book;
    }

    public float getPercentage() {
        return percentage;
    }
}
