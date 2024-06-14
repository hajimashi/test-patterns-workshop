package pl.kraqa.library.user;

public class User {
    private String name;
    private String surname;
    private Address address;
    private String email;

    public User(String name, String surname, Address address, String email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
