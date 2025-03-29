package com.madebywizard.ecommerce.item.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Objects;


// An Item entity, the table name will be "item"
@Entity
@Table(name = "item")
public class Item {


    /*
    a primary key and it's automatically generated
    DATABASE: INT
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    /*
    name of the item. should be unique (required)
    DATABASE: VARCHAR(255) NOT NULL UNIQUE
     */
    @NotNull(message = "name is required")
    @Column(name = "item_name", nullable = false, unique = true)
    private String itemName;


    /*
    type of the item (enum) (required)
    @Enumerated(EnumType.STRING) will let JPA store the enum object as a string
    DATABASE: VARCHAR(255) NOT NULL
     */
    @NotNull(message = "type is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "item_type", nullable = false)
    private ItemType itemType;


    /*
    size of the item (enum) (required)
    @Enumerated(EnumType.STRING) will let JPA store the enum object as a string
    DATABASE: VARCHAR(255) NOT NULL
     */
    @NotNull(message = "size is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "item_size", nullable = false)
    private ItemSize itemSize;


    /*
    color of the item. should be alphabetical (handled from ItemValidator) (required)
    DATABASE: VARCHAR(255) NOT NULL
     */
    @NotNull(message = "color is required")
    @Column(name = "item_color", nullable = false)
    private String itemColor;


    /*
    price of the item. BigDecimal type (required)
    maximum price will be: 99999999.99, 2 decimals are allowed after the decimal
    price should be greater than 0 (handled from ItemValidator)
    DATABASE: DECIMAL(10, 2) NOT NULL
     */
    @NotNull(message = "price is required")
    @Column(name = "item_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal itemPrice;


    /*
    quantity of item (required)
    quantity cannot be negative (handled from ItemValidator)
    DATABASE: INT NOT NULL
     */
    @NotNull(message = "quantity is required")
    @Column(name = "quantity", nullable = false)
    private int quantity;


    /*
    a list of carts.

    Item and Cart have many-to-many relationship because a single item can be stored in multiple carts
    and a single cart can store multiple items.

    The @JsonIgnore annotation let the program avoid the circular reference
    that can be occurred while creating JSON response.

    WILL ADD THE 'carts' ATTRIBUTE IN THE 'toString()' METHOD IN THE FUTURE TO DEBUG 'Item' OBJECT
     */
//    @ManyToMany(mappedBy="items")
//    @JsonIgnore
//    private List<Cart> carts;


    // A default constructor that is required for using JPA/Hibernates (they use reflection to create instances)
    public Item() {}

    public Item(Integer id,
                String itemName,
                ItemType itemType,
                ItemSize itemSize,
                String itemColor,
                BigDecimal itemPrice,
                int quantity
                //List<Cart> carts
    ) {
        this.id = id;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemSize = itemSize;
        this.itemColor = itemColor;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
//        this.carts = carts;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemType getItemType() {
        return this.itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public ItemSize getItemSize() {
        return this.itemSize;
    }

    public void setItemSize(ItemSize itemSize) {
        this.itemSize = itemSize;
    }

    public String getItemColor() {
        return this.itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public BigDecimal getItemPrice() {
        return this.itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public List<Cart> getCarts() {
//        return this.carts;
//    }
//
//    public void setCarts(List<Cart> carts) {
//        this.carts = carts;
//    }


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
                Objects.equals(this.quantity, item.quantity); //&& Objects.equals(this.carts, item.carts);
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
                this.quantity
                // this.carts
        );
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + this.id +
                ", itemName='" + this.itemName + "'" +
                ", itemType='" + this.itemType + "'" +
                ", itemSize='" + this.itemSize + "'" +
                ", itemColor='" + this.itemColor + "'" +
                ", itemPrice=" + this.itemPrice +
                ", quantity=" + this.quantity + "}";
    }
}