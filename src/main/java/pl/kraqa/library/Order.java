package pl.kraqa.library;

public class Order {
    Book book;
    int amount;
    int costOfOneItem;
    int totalCost;
    String nameOfClient;
    String surnameOfClient;
    String clientEmail;
    String deliveryStreet;
    String deliveryHomeNumber;
    String deliveryPostalCode;
    String deliveryCity;
    boolean hasPayed;

    public Order(Book book, int amount, int costOfOneItem, int totalCost, String nameOfClient, String surnameOfClient, String clientEmail, String deliveryStreet, String deliveryHomeNumber, String deliveryPostalCode, String deliveryCity, boolean hasPayed) {
        this.book = book;
        this.amount = amount;
        this.costOfOneItem = costOfOneItem;
        this.totalCost = totalCost;
        this.nameOfClient = nameOfClient;
        this.surnameOfClient = surnameOfClient;
        this.clientEmail = clientEmail;
        this.deliveryStreet = deliveryStreet;
        this.deliveryHomeNumber = deliveryHomeNumber;
        this.deliveryPostalCode = deliveryPostalCode;
        this.deliveryCity = deliveryCity;
        this.hasPayed = hasPayed;
    }
}
