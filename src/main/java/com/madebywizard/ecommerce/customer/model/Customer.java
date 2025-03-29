package com.madebywizard.ecommerce.customer.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;


// A Customer entity, the table name is "customer"
@Entity
@Table(name = "customer")
public class Customer {


    /*
    a primary key and it's automatically generated
    DATABASE: INT
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    /*
    a customer's id. should be alphanumerical (will be handled form CustomerValidator) (required)
    DATABASE: VARCHAR(255) NOT NULL UNIQUE
     */
    @NotNull(message = "customer id is required")
    @Column(name = "customer_Id", nullable = false, unique = true)
    private String customerId;



    /*
    customer's password will be added here in the future (will be encrypted)
    DATABASE: VARCHAR(255)
     */
    @NotNull(message = "customer password is required")
    @Column(name = "customer_password", nullable = false)
    private String customerPassword;



    /*
    a first name of the customer. should be alphabetical (will be handled from CustomerValidator) (required)
    DATABASE: VARCHAR(255) NOT NULL
     */
    @NotNull(message = "first name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;


    /*
    a last name of the customer. should be alphabetical (will be handled from CustomerValidator) (required)
    DATABASE: VARCHAR(255) NOT NULL
     */
    @NotNull(message = "last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;



    /*
    customer's gender. should be alphabetical (will be handled from CustomerValidator) (required)
    DATABASE: VARCHAR(255) NOT NULL
     */
    @NotNull(message = "gender is required")
    @Column(name = "gender", nullable = false)
    private String gender;



    /*
    customer's email. should be an email format: example@example.com (will be handled from CustomerValidator) (required)
    DATABASE: VARCHAR(255) NOT NULL UNIQUE
     */
    @NotNull(message = "email is required")
    @Email(message = "invalid email format")
    @Column(name = "email", nullable = false, unique = true)
    private String email;


    /*
    customer's cart. should be one-to-one relationship with user because user can only have one cart
    and each cart can be associated with one customer.
    cascade: CascadeType.ALL -> if user entity makes an operation the related entity (cart) also do the same operation.
             ex: if customer's deleted, the cart will also be deleted
     */
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cart_id")
//    private Cart cart;


    /*
    customer orders will be added here in the future
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Order> orders;
     */



    /*
    customer's addresses (delivery locations). should be many-to-many relationship with user
    because a customer can have multiple addresses and each address can be associated with multiple customers
    (address can be shared if customer1 and customer2 are related)
    create a junction table with customer_id (Foreign Key for Customer) and address_id (Foreign Key for Address)
     */
//    @ManyToMany
//    @JoinTable(
//            name="customer_addresses",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "address_id")
//    )
//    private List<Address> addresses;


    public Customer() {}

    public Customer(Integer id,
                    String customerId,
                    String customerPassword,
                    String firstName,
                    String lastName,
                    String gender,
                    String email) {
        this.id = id;
        this.customerId = customerId;
        this.customerPassword = customerPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPassword() {
        return this.customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Cart getCart() {
//        return this.cart;
//    }
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }
//
//    public List<Address> getAddresses() {
//        return this.addresses;
//    }
//
//    public void setAddresses(List<Address> addresses) {
//        this.addresses = addresses;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(this.id, customer.id) &&
                Objects.equals(this.customerId, customer.customerId) &&
                Objects.equals(this.customerPassword, customer.customerPassword) &&
                Objects.equals(this.firstName, customer.firstName) &&
                Objects.equals(this.lastName, customer.lastName) &&
                Objects.equals(this.gender, customer.gender) &&
                Objects.equals(this.email, customer.email);
        // && Objects.equals(this.cart, user.cart); // && Objects.equals(this.addresses, user.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.customerId,
                this.customerPassword,
                this.firstName,
                this.lastName,
                this.gender,
                this.email
//                this.cart,
//                this.addresses
        );
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + this.id +
                ", customerId='" + this.customerId + "'" +
                ", customerPassword'" + this.customerPassword + "'" +
                ", firstName='" + this.firstName + "'" +
                ", lastName='" + this.lastName + "'" +
                ", gender='" + this.gender + "'" +
                ", email='" + this.email + "'" +
//                ", cart=" + this.cart +
//                ", addresses=" + this.addresses +
                "}";
    }
}
