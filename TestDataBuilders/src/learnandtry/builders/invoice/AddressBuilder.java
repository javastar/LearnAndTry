package learnandtry.builders.invoice;


public class AddressBuilder {

    private String city = "Daugavpils";
    private String street = "Rigas";
    private String postCode = "LV5400";


    public AddressBuilder withCity(String  city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder withPostcode(String postcode) {
        this.postCode = postcode;
        return this;
    }

    public Address build() {
        Address address = new Address();
        address.setCity(city);
        address.setPostCode(postCode);
        address.setStreet(street);
        return address;
    }

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }
}
