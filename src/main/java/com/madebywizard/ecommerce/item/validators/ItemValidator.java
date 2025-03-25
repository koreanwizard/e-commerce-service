package com.madebywizard.ecommerce.item.validators;

import com.madebywizard.ecommerce.exceptions.ErrorMessages;
import com.madebywizard.ecommerce.exceptions.ItemNotValidException;
import com.madebywizard.ecommerce.item.model.Item;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class ItemValidator {

    private ItemValidator() {}

    public static void validate(Item item) {

        // if the item name is not written ex: "", " "
        // if item name is not written (or an empty space) OR not an alphanumeric
        // throw an INVALID_ITEM_NAME exception
        if (!StringUtils.hasText(item.getItemName()) || !item.getItemName().matches("[a-zA-Z0-9 ]+")) {
            throw new ItemNotValidException(ErrorMessages.INVALID_ITEM_NAME.getMessage());
        }


        // if the item color name is not written ex: "", " " OR not alphabetical
        // throws an INVALID_ITEM_COLOR exception
        if (!StringUtils.hasText(item.getItemColor()) || !item.getItemColor().matches("[a-zA-Z ]+")) {
            throw new ItemNotValidException(ErrorMessages.INVALID_ITEM_COLOR.getMessage());
        }


        // if the item price <= 0, throws an INVALID_ITEM_PRICE exception
        // if the price is less than or equal to 0 the 'compareTo(BigDecimal.ZERO)' will return -1 or 0
        if (item.getItemPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ItemNotValidException(ErrorMessages.INVALID_ITEM_PRICE.getMessage());
        }


        // if the quantity is less than 0, throws an INVALID_ITEM_QUANTITY exception
        if (item.getQuantity() < 0) {
            throw new ItemNotValidException(ErrorMessages.INVALID_ITEM_QUANTITY.getMessage());
        }
    }
}
