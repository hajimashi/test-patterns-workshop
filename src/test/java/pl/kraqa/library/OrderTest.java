package pl.kraqa.library;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.kraqa.library.user.Address;
import pl.kraqa.library.user.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Task 4:
 * - Provide all of test cases that makes sense for the class Order
 */
class OrderTest {

    private static Stream<Arguments> dataProvider() {
        Book a = new Book(new Author("Justin", "Bieber"), "A", 1900, "1234567");
        Book b = new Book(new Author("Henryk", "Sienkiewicz"), "B", 2002, "12346567");
        Book c = new Book(new Author("Miley", "Cyrus"), "C", 1901, "1134567");
        Book d = new Book(new Author("Olga", "Tokarczuk"), "D", 1999, "1234555");

        return Stream.of(
                Arguments.of(Set.of(a, b, c), List.of(), 9),
                Arguments.of(Set.of(), List.of(), 0),
                Arguments.of(Set.of(), List.of(new BookDiscount(a, 0.5F)), 0),
                Arguments.of(Set.of(b, c), List.of(new BookDiscount(a, 0.5F)), 6),
                Arguments.of(Set.of(a), List.of(new BookDiscount(a, 0.5F)), 1),
                Arguments.of(null, null, 0),
                Arguments.of(Set.of(), List.of(new BookDiscount(a, 0.5F)), 0),
                Arguments.of(Set.of(a), List.of(new BookDiscount(a, 0.5F), new BookDiscount(a, 0.5F), new BookDiscount(a, 0.5F)), 0),
                Arguments.of(Set.of(a, b, c, d), List.of(new BookDiscount(a, 0.5F), new BookDiscount(b, 0.1F), new BookDiscount(c, 0.2F)), 9)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testOrder(Set<Book> books, List<BookDiscount> discountList, int expected) {
        //given
        Address address = new Address.Builder().createAddress();
        User user = new User("Jan", "Kowalski", address);
        Order order = new Order(books, user, discountList);

        //when
        int price = order.calculatePrice();

        //then
        assertEquals(price, expected);
    }

}
