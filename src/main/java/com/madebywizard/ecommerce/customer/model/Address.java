package com.madebywizard.ecommerce.customer.model;


// An Address entity, the table name is "address"
//@Entity
//@Table(name = "address")
public class Address {

//
//    /*
//    a primary key and it's automatically generated
//    DATABASE: INT
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private Integer id;
//
//
//    /*
//    a street address. should be alphanumerical (will be handled from AddressValidator) (required)
//    DATABASE: VARCHAR(255) NOT NULL
//     */
//    @NotNull(message = "street address is required")
//    @Column(name="street_address", nullable = false)
//    private String streetAddress;
//
//
//    /*
//    a unit number of house or apartment. should be alphanumerical but allows '#' character (will be handled from AddressValidator) (optional)
//    DATABASE: VARCHAR(255)
//     */
//    @Column(name="unit_number")
//    private String unitNumber;
//
//
//    /*
//    city name. should be alphabetical (will be handled from AddressValidator) (required)
//    DATABASE: VARCHAR(255) NOT NULL
//     */
//    @NotNull(message = "city name is required")
//    @Column(name="city", nullable = false)
//    private String city;
//
//
//    /*
//    state/province name. should be alphabetical (will be handled from AddressValidator) (optional)
//    DATABASE: VARCHAR(255)
//     */
//    @Column(name="state")
//    private String state;
//
//
//    /*
//    postal code. should be alphanumerical (will be handled from AddressValidator) (required)
//    DATABASE: VARCHAR(255) NOT NULL
//     */
//    @NotNull(message = "postal code is required")
//    @Column(name="postal_code")
//    private String postalCode;
//
//
//    /*
//    name of the country. should be alphabetical (will be handled from AddressValidator) (required)
//    DATABASE: VARCHAR(255) NOT NULL
//     */
//    @NotNull(message = "country name is required")
//    @Column(name="country", nullable = false)
//    private String country;
//
//
//    /*
//    a bidirectional mapping with User object (user can have multiple addresses and each of address can be associated with multiple users (ex: family can share address)
//     */
//    @ManyToMany(mappedBy = "addresses") // a bidirectional mapping with User object
//    private List<User> users;
//
//
//    public Address() {}
//
//    public Address(Integer id, String streetAddress, String unitNumber, String city, String state, String postalCode, String country, List<User> users) {
//        this.id = id;
//        this.streetAddress = streetAddress;
//        this.unitNumber = unitNumber;
//        this.city = city;
//        this.state = state;
//        this.postalCode = postalCode;
//        this.country = country;
//        this.users = users;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getStreetAddress() {
//        return this.streetAddress;
//    }
//
//    public void setStreetAddress(String streetAddress) {
//        this.streetAddress = streetAddress;
//    }
//
//    public String getUnitNumber() {
//        return this.unitNumber;
//    }
//
//    public void setUnitNumber(String unitNumber) {
//        this.unitNumber = unitNumber;
//    }
//
//    public String getCity() {
//        return this.city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return this.state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getPostalCode() {
//        return this.postalCode;
//    }
//
//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
//
//    public String getCountry() {
//        return this.country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public List<User> getUsers() {
//        return this.users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Address)) return false;
//        Address address = (Address) o;
//        return Objects.equals(this.id, address.id) &&
//                Objects.equals(this.streetAddress, address.streetAddress)
//                && Objects.equals(this.unitNumber, address.unitNumber)
//                && Objects.equals(this.city, address.city)
//                && Objects.equals(this.state, address.state)
//                && Objects.equals(this.postalCode, address.postalCode)
//                && Objects.equals(this.country, address.country)
//                && Objects.equals(this.users, address.users);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.id, this.streetAddress, this.unitNumber, this.city, this.state, this.postalCode, this.country, this.users);
//    }
//
//    @Override
//    public String toString() {
//        return "Address{" + "id=" + this.id +
//                ", streetAddress='" + this.streetAddress + "'" +
//                ", unitNumber='" + this.unitNumber + "'" +
//                ", city='" + this.city + "'" +
//                ", state='" + this.state + "'" +
//                ", postalCode='" + this.postalCode + "'" +
//                ", country='" + this.country + "'" +
//                ", users=" + this.users +
//                "}";
//    }
}
