package com.madebywizard.ecommerce.user.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="street_address")
    private String streetAddress;

    @Column(name="unit_number") // this is optional so it can be a null
    private String unitNumber;

    @Column(name="city")
    private String city;

    @Column(name="state") // this is optional so it can be a null
    private String state;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="country")
    private String country;

    @Column(name="user_id") // this is for OneToMany
    private Integer userId;


    public Address() {}

    public Address(Integer id, String streetAddress, String unitNumber, String city, String state, String postalCode, String country, Integer userId) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.unitNumber = unitNumber;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getUnitNumber() {
        return this.unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(this.id, address.id) &&
                Objects.equals(this.streetAddress, address.streetAddress)
                && Objects.equals(this.unitNumber, address.unitNumber)
                && Objects.equals(this.city, address.city)
                && Objects.equals(this.state, address.state)
                && Objects.equals(this.postalCode, address.postalCode)
                && Objects.equals(this.country, address.country)
                && Objects.equals(this.userId, address.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.streetAddress, this.unitNumber, this.city, this.state, this.postalCode, this.country, this.userId);
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + this.id +
                ", streetAddress='" + this.streetAddress + "'" +
                ", unitNumber='" + this.unitNumber + "'" +
                ", city=" + this.city +
                ", state='" + this.state + "'" +
                ", postalCode='" + this.postalCode + "'" +
                ", country='" + this.country + "'" +
                ", userId=" + this.userId +
                "}";
    }
}
