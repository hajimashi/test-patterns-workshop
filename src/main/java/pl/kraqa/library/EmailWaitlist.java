package pl.kraqa.library;

import pl.kraqa.library.email.Email;
import pl.kraqa.library.email.EmailSender;
import pl.kraqa.library.user.User;

import java.util.ArrayList;
import java.util.List;

public class EmailWaitlist implements Waitlist {
    private final Book book;
    private EmailSender sender;
    private List<User> users = new ArrayList<>();

    public EmailWaitlist(Book book, EmailSender sender) {
        this.book = book;
        this.sender = sender;
    }

    public Book getBook() {
        return book;
    }

    public void onBookReturned() {
        Email.Builder emailDraft = new Email.Builder()
                .setSubject(book.getTitle() + " is now available in the Library")
                .setMessage("Hello, we are contacting you to let you know that copy of a book you are waiting for has been returned to our Library. Best regards.");

        users.forEach(user -> sender.send(emailDraft.setTo(user.getEmail()).createEmail()));
    }

    public void addToWaitlist(User user) {
        this.users.add(user);
    }
}
