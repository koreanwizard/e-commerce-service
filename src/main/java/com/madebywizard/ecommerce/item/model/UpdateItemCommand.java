package com.madebywizard.ecommerce.item.model;

public class UpdateItemCommand {

    private Integer id;
    private Item item;

    public UpdateItemCommand(Integer id, Item item) {
        this.id = id;
        this.item = item;
    }

    public Integer getId() {
        return this.id;
    }

    public Item getItem() {
        return this.item;
    }
}
