package pl.kraqa.library.user;

public class Address {
    private String postalCode;
    private String street;
    private String country;
    private String building;
    private String apartment;
    private String city;

    Address(String postalCode, String street, String country, String building, String apartment, String city) {
        this.postalCode = postalCode;
        this.street = street;
        this.country = country;
        this.building = building;
        this.apartment = apartment;
        this.city = city;
    }

    public class Builder {
        private String postalCode;
        private String street;
        private String country;
        private String building;
        private String apartment;
        private String city;

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setBuilding(String building) {
            this.building = building;
            return this;
        }

        public Builder setApartment(String apartment) {
            this.apartment = apartment;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Address createAddress() {
            return new Address(postalCode, street, country, building, apartment, city);
        }
    }
}
