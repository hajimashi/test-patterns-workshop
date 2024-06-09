package pl.kraqa.library

import pl.kraqa.library.user.Address
import pl.kraqa.library.user.User
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class OrderTestSpock extends Specification {
    @Shared
    Book a = new Book(new Author("Justin", "Bieber"), "A", 1900, "1234567");
    @Shared
    Book b = new Book(new Author("Henryk", "Sienkiewicz"), "B", 2002, "12346567");
    @Shared
    Book c = new Book(new Author("Miley", "Cyrus"), "C", 1901, "1134567");
    @Shared
    Book d = new Book(new Author("Olga", "Tokarczuk"), "D", 1999, "1234555");

    @Unroll
    def "CalculatePrice"() {
        given:
        Address address = new Address.Builder().createAddress()
        User user = new User("Jan", "Kowalski", address)
        Order order = new Order(books as Set<Book>, user, discountList)

        when:
        int price = order.calculatePrice()

        then:
        price == expected

        where:
        books        | discountList                                                                      | expected
        [a, b, c]    | []                                                                                | 9
        []           | [new BookDiscount(a, 0.5F)]                                                       | 0
        [b, c]       | [new BookDiscount(a, 0.5F)]                                                       | 6
        [a]          | [new BookDiscount(a, 0.5F)]                                                       | 1
        null         | null                                                                              | 0
        [a]          | [new BookDiscount(a, 0.5F), new BookDiscount(a, 0.5F), new BookDiscount(a, 0.5F)] | 0
        [a, b, c, d] | [new BookDiscount(a, 0.5F), new BookDiscount(b, 0.1F), new BookDiscount(c, 0.2F)] | 9
    }
}
