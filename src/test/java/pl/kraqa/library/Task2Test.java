package pl.kraqa.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


/**
 * Task 2:
 * - Take a look at the setup part of a solution for task1. What can be changed here to make it more readable?
 */
class Task2Test {
    Book krzyzacy;
    Library library;

    @BeforeEach
    public void setup() {
        library = new Library();
        krzyzacy = new Book(new Author("Henryk", "Sienkiewicz"), "Krzyżacy", 1897, "978-83-774-0824-7");
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
