package com.madebywizard.ecommerce.item.model;

// a record class for updating item (UpdateItemCommand is immutable and only requires a getter method to get message)
public record UpdateItemCommand(Integer id, Item item) {
}