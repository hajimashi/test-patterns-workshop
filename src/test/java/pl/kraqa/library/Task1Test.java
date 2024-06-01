package pl.kraqa.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


/**
 * Task 1:
 * - Create test checking that added book may be found in the library
 * - Create test checking that book is not available until a copy of a book is added
 */
class Task1Test {
    Author heniek;
    Book krzyzacy;
    Library library;

    @BeforeEach
    public void setup() {
        heniek = new Author("Henryk", "Sienkiewicz");
        krzyzacy = new Book(heniek, "Krzyżacy", 1897, "978-83-774-0824-7");
        library = new Library();
    }

    @Test
    public void addedBookMayBeFoundInTheLibrary() {
        //when
        library.addBook(krzyzacy);

        //then
        assertTrue(!library.findByTitle("Krzyżacy").isEmpty());
    }

    @Test
    public void bookIsAvailableWhenCopyAdded() {
        //given
        library.addBook(krzyzacy);

        //expect
        assertFalse(library.isAvailable(krzyzacy));

        //when
        library.addCopy(krzyzacy.getISBN());

        //then
        assertTrue(library.isAvailable(krzyzacy));
    }
}
