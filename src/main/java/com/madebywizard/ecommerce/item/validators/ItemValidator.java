package com.madebywizard.ecommerce.item.validators;

import com.madebywizard.ecommerce.exceptions.ErrorMessages;
import com.madebywizard.ecommerce.exceptions.ItemNotValidException;
import com.madebywizard.ecommerce.item.model.Item;
import com.madebywizard.ecommerce.item.model.ItemSize;
import com.madebywizard.ecommerce.item.model.ItemType;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ItemValidator {

    private ItemValidator() {}

    public static void execute(Item item) {


        // if the item name is not written ex: "", null, " ", "     "
        // throw an INVALID_ITEM_NAME exception
        if (!StringUtils.hasText(item.getItemName()) || !item.getItemName().matches("[a-zA-Z ]+")) {
            throw new ItemNotValidException(ErrorMessages.INVALID_ITEM_NAME.getMessage());
        }

        // if the item color name is not written ex: "", null, " ", "     " OR if it's not alphabetical
        // throws an INVALID_ITEM_COLOR
        if (!StringUtils.hasText(item.getItemColor()) || !item.getItemColor().matches("[a-zA-Z ]+")) {
            throw new ItemNotValidException(ErrorMessages.INVALID_ITEM_COLOR.getMessage());
        }


        // check if user input a wrong type or size of item
        // it seems I should create a custom deserializer to handle exceptions
        // the postman gives deserialize error: Cannot deserialize....
        // so I think these if-statement validators not working well -> this will be updated in the future

        if (!isValidEnum("type", item.getItemType().toString())) {
            throw new ItemNotValidException(ErrorMessages.INVALID_TYPE.getMessage());
        }

        if (!isValidEnum("size", item.getItemSize().toString())) {
            throw new ItemNotValidException(ErrorMessages.INVALID_SIZE.getMessage());
        }

//        if (!isAlphabetic(item.getItemName()) || !isAlphabetic(item.getItemColor())) {
//            throw new ItemNotValidException(ErrorMessages.ALPHABETIC_REQUIRED.getMessage());
//        }

        if (item.getRemainingItem() < 0) {
            throw new ItemNotValidException(ErrorMessages.INVALID_REMAINING_ITEM.getMessage());
        }
    }


    public static boolean isValidEnum(String category, String element) {

        if (category.equals("type")) {
            try {
                ItemType.valueOf(element);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        } else {
            try {
                ItemSize.valueOf(element);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
    }



//    public static boolean isAlphabetic(String word) {
//
//        for (int i = 0; i < word.length(); i++) {
//            if (!Character.isLetter(word.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//    }









//    public static boolean isAlphanumeric(String word) {
//        for (int i = 0; i < word.length(); i++) {
//            if (!Character.isLetterOrDigit(word.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean isValidDate(LocalDate date) { // not sure this method is working will be fixed in the future
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            LocalDate.parse(date.toString(), formatter); // if LocalDate.parse raise an DateTimeParseException
//            return true;
//        } catch (DateTimeParseException exception) { // catch and return false to make sure our input date is invalid.
//            return false;
//        }
//    }
}
