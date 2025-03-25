package com.madebywizard.ecommerce.item.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.madebywizard.ecommerce.user.model.Cart;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // @NotNull(message = "item name is required") ensure that this field cannot be null
    // VARCHAR
    @Column(name = "item_name")
    private String itemName;

    // VARCHAR
    @Enumerated(EnumType.STRING)
    @Column(name = "item_type")
    private ItemType itemType;

    // VARCHAR
    @Enumerated(EnumType.STRING)
    @Column(name = "item_size")
    private ItemSize itemSize;

    // VARCHAR
    @Column(name = "item_color")
    private String itemColor;

    // DECIMAL(10, 2) -> $10.99
    // precision: max-value that can be stored: 99999999.99, scale: number of digits after the decimal : ex-> 12.34
    @Column(name = "item_price", precision = 10, scale = 2)
    private BigDecimal itemPrice;

    @Column(name = "remaining_item")
    private int remainingItem;

    @Column(name="cart_id")
    private Integer cartId;

    // Many-to-many relationship with carts because every item can exist in every cart.
    // While creating a JSON response, circular reference can occur and @JsonIgnore helps to avoid the circular reference.
    @ManyToMany(mappedBy="items")
    @JsonIgnore
    private List<Cart> carts;



    public Item() {

    }

    public Item(Integer id,
                String itemName,
                ItemType itemType,
                ItemSize itemSize,
                String itemColor,
                BigDecimal itemPrice,
                int remainingItem,
                Integer cartId,
                List<Cart> carts) {
        this.id = id;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemSize = itemSize;
        this.itemColor = itemColor;
        this.itemPrice = itemPrice;
        this.remainingItem = remainingItem;
        this.cartId = cartId;
        this.carts = carts;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public ItemSize getItemSize() {
        return itemSize;
    }

    public void setItemSize(ItemSize itemSize) {
        this.itemSize = itemSize;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getRemainingItem() {
        return remainingItem;
    }

    public void setRemainingItem(int remainingItem) {
        this.remainingItem = remainingItem;
    }

    public Integer getCartId() {
        return this.cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public List<Cart> getCarts() {
        return this.carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(this.id, item.id) &&
                Objects.equals(this.itemName, item.itemName) &&
                Objects.equals(this.itemType, item.itemType) &&
                Objects.equals(this.itemSize, item.itemSize) &&
                Objects.equals(this.itemColor, item.itemColor) &&
                Objects.equals(this.itemPrice, item.itemPrice) &&
                Objects.equals(this.remainingItem, item.remainingItem) &&
                Objects.equals(this.cartId, item.cartId) &&
                Objects.equals(this.carts, item.carts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.itemName,
                this.itemType,
                this.itemSize,
                this.itemColor,
                this.itemPrice,
                this.remainingItem,
                this.cartId,
                this.carts
        );
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + this.id +
                ", itemName='" + this.itemName + "'" +
                ", itemType='" + this.itemType + "'" +
                ", itemSize=" + this.itemSize +
                ", itemColor='" + this.itemColor + "'" +
                ", itemPrice='" + this.itemPrice + "'" +
                ", remainingItem='" + this.remainingItem + "'" +
                "}";
    }
}
