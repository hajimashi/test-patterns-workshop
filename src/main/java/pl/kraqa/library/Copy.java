package pl.kraqa.library;

public class Copy {
    private Status status;

    private final String ISBN;

    public Copy(String ISBN) {
        this.ISBN = ISBN;
        this.status = Status.AVAILABLE;
    }

    public Status getStatus() {
        return status;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
