package pl.kraqa.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void returnBook() {
        //given
        Book book = new Book(new Author("Henryk", "Sienkiewicz"), "B", 2002, "12346567");

        WaitlistMock waitlist = new WaitlistMock();
        waitlist.setGetBookReturnValue(book);

        Library library = new Library();
        library.createWaitlist(waitlist);

        library.addBook(book);
        library.addCopy(book.getISBN());
        library.borrow(book);

        //when
        library.returnBook(book);

        //then
        assertEquals(waitlist.getOnBookReturnedCallCount(), 1);
        assertTrue(library.isAvailable(book));
    }
}