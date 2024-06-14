package pl.kraqa.library;

import pl.kraqa.library.user.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Order {
    private static final int STANDARD_PRICE = 3;
    Set<Book> books;
    List<BookDiscount> discounts;
    User user;

    public Order(Set<Book> books, User user, List<BookDiscount> discounts) {
        this.books = books;
        this.user = user;
        this.discounts = discounts;
    }

    public int calculatePrice() {
        return (int) Optional.ofNullable(books).orElse(Set.of()).stream().mapToDouble(
                book -> (1 - Optional.ofNullable(discounts).orElse(List.of()).stream()
                        .filter(bookDiscount -> bookDiscount.getBook().equals(book))
                        .mapToDouble(BookDiscount::getPercentage)
                        .reduce(0, Double::sum)) * STANDARD_PRICE
        ).reduce(0, Double::sum);
    }
}