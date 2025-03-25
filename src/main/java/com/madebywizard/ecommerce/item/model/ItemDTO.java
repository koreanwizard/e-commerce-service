package com.madebywizard.ecommerce.item.model;

import java.math.BigDecimal;
// import java.util.Objects;


// A DTO (data transfer object) for Item
public class ItemDTO {

    private Integer id;
    private String itemName;
    private ItemType itemType;
    private ItemSize itemSize;
    private BigDecimal itemPrice;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.itemName = item.getItemName();
        this.itemType = item.getItemType();
        this.itemSize = item.getItemSize();
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

    public ItemSize getItemSize() {
        return this.itemSize;
    }

    public void setItemSize(ItemSize itemSize) {
        this.itemSize = itemSize;
    }

    public BigDecimal getItemPrice() {
        return this.itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }


// these can be omitted
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof ItemDTO)) {
//            return false;
//        }
//        ItemDTO itemDTO = (ItemDTO) o;
//        return Objects.equals(this.id, itemDTO.id) &&
//                Objects.equals(this.itemName, itemDTO.itemName) &&
//                Objects.equals(this.itemType, itemDTO.itemType) &&
//                Objects.equals(this.itemSize, itemDTO.itemSize) &&
//                Objects.equals(this.itemPrice, itemDTO.itemPrice);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.id, this.itemName, this.itemType, this.itemSize, this.itemPrice);
//    }


    // can be used for debugging purposes
    @Override
    public String toString() {
        return "ItemDTO{" + "id=" + this.id +
                ", itemName='" + this.itemName + "'" +
                ", itemType='" + this.itemType + "'" +
                ", itemSize='" + this.itemSize + "'" +
                ", itemPrice=" + this.itemPrice + "}";
    }
}
