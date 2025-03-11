package com.madebywizard.ecommerce.item.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemDTO {

    private Integer id;
    private String itemName;
    private ItemType itemType;
    private BigDecimal itemPrice;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.itemName = item.getItemName();
        this.itemType = item.getItemType();
        this.itemPrice = item.getItemPrice();
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

    public BigDecimal getItemPrice() {
        return this.itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ItemDTO)) {
            return false;
        }
        ItemDTO userDTO = (ItemDTO) o;
        return Objects.equals(this.id, userDTO.id) &&
                Objects.equals(this.itemName, userDTO.itemName) &&
                Objects.equals(this.itemType, userDTO.itemType) &&
                Objects.equals(this.itemPrice, userDTO.itemPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.itemName, this.itemType, this.itemPrice);
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + this.id +
                ", itemName='" + this.itemName + "'" +
                ", itemType='" + this.itemType + "'" +
                ", itemPrice='" + this.itemPrice + "'" + "}";
    }
}
