package pl.kraqa.library;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Task 1:
 * - Create test checking that added book may be found in the library
 * - Create test checking that book is not available until a copy of a book is added
 */
class Task2Test {

    @Test
    public void addedBookMayBeFoundInTheLibrary() {
        //given
        Author unknown = new UnknownAuthor();
        Book krzyzacy = new Book(new UnknownAuthor(), "Krzyżacy", 1897, "978-83-774-0824-7");
        Book lalka = new Book(new UnknownAuthor(), "Lalka", 1800, "978-83-774-0824-2");
        Library library = new Library();
        library.addBook(krzyzacy);
        library.addBook(lalka);

        //expect
        System.out.println(library.findByAuthor(new UnknownAuthor()).stream().map(Book::getISBN).collect(Collectors.toList()));
    }

    class UnknownAuthor extends Author {

        public UnknownAuthor() {
            super("unknown", "unknown");
        }
    }
}
