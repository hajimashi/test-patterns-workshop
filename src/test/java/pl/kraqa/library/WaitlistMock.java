package pl.kraqa.library;

import pl.kraqa.library.email.EmailSender;

public class WaitlistMock extends EmailWaitlist {
    private int onBookReturnedCallCount = 0;
    private Book book;

    public WaitlistMock() {
        super(null, null);
    }

    @Override
    public void onBookReturned() {
        onBookReturnedCallCount++;
    }

    @Override
    public Book getBook() {
        return book;
    }

    public void setGetBookReturnValue(Book book) {
        this.book = book;
    }

    public int getOnBookReturnedCallCount() {
        return onBookReturnedCallCount;
    }
}
