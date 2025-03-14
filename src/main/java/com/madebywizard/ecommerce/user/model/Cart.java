package com.madebywizard.ecommerce.user.model;

import com.madebywizard.ecommerce.item.model.Item;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "item_count")
    private int itemCount;

    public Cart() {}

    public Cart(Integer id, int itemCount) {
        this.id = id;
        this.itemCount = itemCount;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cart)) {
            return false;
        }
        Cart cart = (Cart) o;
        return Objects.equals(this.id, cart.id) && Objects.equals(this.itemCount, cart.itemCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.itemCount);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + this.id +
                ", itemCount=" + this.itemCount +
                "}";
    }

}
