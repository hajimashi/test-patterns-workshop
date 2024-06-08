package pl.kraqa.library.user;

public class User {
    private String name;
    private String surname;
    private Address address;

    public User(String name, String surname, Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}
