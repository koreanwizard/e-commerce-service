package com.madebywizard.ecommerce.user.model;

import com.madebywizard.ecommerce.item.model.Item;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


// A Cart entity, the table name is cart
//@Entity
//@Table(name = "cart")
public class Cart {

//
//    /*
//    a primary key and it's automatically generated
//    DATABASE: INT
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//
//    /*
//    a quantity of items (the length of the items list)
//    DATABASE: INT NOT NULL
//     */
//    @Column(name = "item_count")
//    private int itemCount;
//
//
//    /*
//    cart's items. should be many-to-many relationship with item because cart can store
//    multiple items and each item can be stored in multiple carts.
//    create a junction table with cart_id (Foreign Key for Cart) and item_id (Foreign Key for Item)
//     */
//    @ManyToMany
//    @JoinTable(
//            name = "cart_item",
//            joinColumns = @JoinColumn(name = "cart_id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id")
//    )
//    private List<Item> items;
//
//    public Cart() {}
//
//    public Cart(Integer id, int itemCount, List<Item> items) {
//        this.id = id;
//        this.itemCount = itemCount;
//        this.items = items;
//    }
//
//    public Integer getId() {
//        return this.id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public int getItemCount() {
//        return this.itemCount;
//    }
//
//    public void setItemCount(int itemCount) {
//        this.itemCount = itemCount;
//    }
//
//    public List<Item> getItems() {
//        return this.items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof Cart)) {
//            return false;
//        }
//        Cart cart = (Cart) o;
//        return Objects.equals(this.id, cart.id) &&
//                Objects.equals(this.itemCount, cart.itemCount) &&
//                Objects.equals(this.items, cart.items);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.id, this.itemCount, this.items);
//    }
//
//    @Override
//    public String toString() {
//        return "Cart{" +
//                "id=" + this.id +
//                ", itemCount=" + this.itemCount +
//                ", items=" + this.items +
//                "}";
//    }
}
