package com.madebywizard.ecommerce.user.model;

import com.madebywizard.ecommerce.item.model.ItemDTO;

import java.util.List;
import java.util.Objects;

public class UserDTO {

    private Integer id;
    private String lastName;
    private Cart cart;
    private List<Address> addresses;

    public UserDTO(User user) {
        this.id = user.getId();
        this.lastName = user.getLastName();
        this.cart = user.getCart();
        this.addresses = user.getAddresses();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Address> getAddresses() { return this.addresses; }

    public void setAddresses(List<Address> addresses) { this.addresses = addresses; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDTO)) {
            return false;
        }
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(this.id, userDTO.id) &&
                Objects.equals(this.lastName, userDTO.lastName) &&
                Objects.equals(this.cart, userDTO.cart) &&
                Objects.equals(this.addresses, userDTO.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.lastName, this.cart, this.addresses);
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + this.id +
                ", lastName='" + this.lastName + "'" +
                ", cart=" + this.cart +
                ", addresses=" + this.addresses +
                "}";
    }
}
