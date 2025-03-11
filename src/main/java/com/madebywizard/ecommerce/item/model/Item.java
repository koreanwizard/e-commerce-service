package com.madebywizard.ecommerce.item.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
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
    @Column(name = "item_price", precision = 10, scale = 2) // precision: max-value that can be stored: 99999999.99, scale: number of digits after the decimal : ex) 12.34
    private BigDecimal itemPrice;

    @Column(name = "remaining_item")
    private int remainingItem;


    public Item() {

    }

    public Item(int remainingItem) {
        this.remainingItem = remainingItem;
    }

    public Item(Integer id, String itemName, ItemType itemType, ItemSize itemSize, String itemColor, BigDecimal itemPrice, int remainingItem) {
        this.id = id;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemSize = itemSize;
        this.itemColor = itemColor;
        this.itemPrice = itemPrice;
        this.remainingItem = remainingItem;
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




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item user = (Item) o;
        return Objects.equals(this.id, user.id) &&
                Objects.equals(this.itemName, user.itemName) &&
                Objects.equals(this.itemType, user.itemType) &&
                Objects.equals(this.itemSize, user.itemSize) &&
                Objects.equals(this.itemColor, user.itemColor) &&
                Objects.equals(this.itemPrice, user.itemPrice) &&
                Objects.equals(this.remainingItem, user.remainingItem);
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
                this.remainingItem
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
                ", remainingItem=" + this.remainingItem + "'" +
                "}";
    }
}
