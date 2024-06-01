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
    Book krzyzacy;
    Library library;

    @BeforeEach
    public void setup() {
        library = new Library();
        krzyzacy = new BookBuilder().author(new Author("Henryk", "Sienkiewicz"))
                .title("Krzyżacy")
                .releaseYear(1897)
                .isbn("978-83-774-0824-7")
                .build();
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
