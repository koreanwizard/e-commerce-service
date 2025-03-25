package com.madebywizard.ecommerce.user.model;


import com.madebywizard.ecommerce.item.model.Item;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;


// A User entity, the table name is "user"
@Entity
@Table(name = "user")
public class User {


    /*
    a primary key and it's automatically generated
    DATABASE: INT
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    /*
    a user's id. should be alphanumerical (will be handled form UserValidator) (required)
    DATABASE: VARCHAR(255) NOT NULL
     */
    @NotNull(message = "user id is required")
    @Column(name = "user_Id", nullable = false)
    private String userId;


//     user password will be added here in the future (will be encrypted)
//     DATABASE: VARCHAR(255)
//     @NotNull(message = "user password is required")
//     @Column(name = "user_password", nullable = false)
//     private String userPassword;


    /*
    a first name of the user. should be alphabetical (will be handled from UserValidator) (required)
    DATABASE: VARCHAR(255) NOT NULL
     */
    @NotNull(message = "first name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;


    /*
    a last name of the user. should be alphabetical (will be handled from UserValidator) (required)
    DATABASE: VARCHAR(255) NOT NULL
     */
    @NotNull(message = "last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;



    /*
    user's gender. should be alphabetical (will be handled from UserValidator) (required)
    DATABASE: VARCHAR(255) NOT NULL
     */
    @NotNull(message = "gender is required")
    @Column(name = "gender", nullable = false)
    private String gender;



    /*
    user's email. should be an email format: example@example.com (will be handled from UserValidator) (required)
    DATABASE: VARCHAR(255) NOT NULL UNIQUE
     */
    @NotNull(message = "email is required")
    @Email(message = "invalid email format")
    @Column(name = "email", nullable = false)
    private String email;


    /*
    user's cart. should be one-to-one relationship with user because user can only have one cart
    and each cart can be associated with one user.
    cascade: CascadeType.ALL -> if user entity makes an operation the related entity (cart) also do the same operation.
             ex: if user's deleted, the cart will also be deleted
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;


    /*
    user's addresses (delivery locations). should be many-to-many relationship with user because user can have multiple
    addresses and each address can be associated with multiple user (address can be shared if user1 and user2 are related)
    create a junction table with user_id (Foreign Key for User) and address_id (Foreign Key for Address)
     */
    @ManyToMany
    @JoinTable(
            name="user_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addresses;


    public User() {}

    public User(Integer id, String userId, String firstName, String lastName, String gender, String email, Cart cart, List<Address> addresses) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.cart = cart;
        this.addresses = addresses;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.id, user.id) &&
                Objects.equals(this.userId, user.userId) &&
                Objects.equals(this.firstName, user.firstName) &&
                Objects.equals(this.lastName, user.lastName) &&
                Objects.equals(this.gender, user.gender) &&
                Objects.equals(this.email, user.email) &&
                Objects.equals(this.cart, user.cart) &&
                Objects.equals(this.addresses, user.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.userId,
                this.firstName,
                this.lastName,
                this.gender,
                this.email,
                this.cart,
                this.addresses
        );
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id +
                ", userId='" + this.userId + "'" +
                ", firstName='" + this.firstName + "'" +
                ", lastName='" + this.lastName + "'" +
                ", gender='" + this.gender + "'" +
                ", email='" + this.email + "'" +
                ", cart=" + this.cart +
                ", addresses=" + this.addresses +
                "}";
    }
}
