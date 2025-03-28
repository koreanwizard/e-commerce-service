package com.madebywizard.ecommerce;

import com.madebywizard.ecommerce.exceptions.ItemNotValidException;
import com.madebywizard.ecommerce.item.model.Item;
import com.madebywizard.ecommerce.item.model.ItemSize;
import com.madebywizard.ecommerce.item.model.ItemType;
import com.madebywizard.ecommerce.item.validators.ItemValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static com.madebywizard.ecommerce.item.validators.ItemValidator.validate;
import static org.junit.jupiter.api.Assertions.*;

public class ItemValidatorTest {

    private Item item;

    @BeforeEach
    public void setup() {
        item = new Item();
        item.setId(1);
        item.setItemName("valid item name 1");
        item.setItemType(ItemType.HOODIE);
        item.setItemSize(ItemSize.L);
        item.setItemColor("valid item color");
        item.setItemPrice(BigDecimal.valueOf(12.99));
        item.setQuantity(10);
    }

    @Test
    public void test_method() {


//        String invalid1 = "";
//        String invalid2 = " ";
//        String invalid3 = "                         ";
//        String invalid4 = "              ?              ";
//        String invalid5 = "1234";
//        String invalid6 = " name ";
//        String invalid7 = "name ";
//        String invalid8 = " name";
//        String invalid9 = "name 123";
//        String invalid10 = "!@#$%^&*()-_=+[]{}|\\/?<>,.\"'`~;:";
//        String valid = "sky blue";
//
//
//        assertTrue(ItemValidator.invalidItemColor(null));
//        assertTrue(ItemValidator.invalidItemColor(invalid1));
//        assertTrue(ItemValidator.invalidItemColor(invalid2));
//        assertTrue(ItemValidator.invalidItemColor(invalid3));
//        assertTrue(ItemValidator.invalidItemColor(invalid4));
//        assertTrue(ItemValidator.invalidItemColor(invalid5));
//        assertTrue(ItemValidator.invalidItemColor(invalid6));
//        assertTrue(ItemValidator.invalidItemColor(invalid7));
//        assertTrue(ItemValidator.invalidItemColor(invalid8));
//        assertTrue(ItemValidator.invalidItemColor(invalid9));
//        assertTrue(ItemValidator.invalidItemColor(invalid10));
//        assertFalse(ItemValidator.invalidItemColor(valid));


//        BigDecimal test = BigDecimal.valueOf(0);
//
//
//        assertTrue(ItemValidator.invalidItemPrice(BigDecimal.valueOf(0.0)));
//        assertTrue(ItemValidator.invalidItemPrice(BigDecimal.valueOf(-0.1)));
//        assertFalse(ItemValidator.invalidItemPrice(BigDecimal.valueOf(0.000000000000000000000001)));


    }

    @Test
    public void test_valid_item_name() {
        // invalid item names
        String invalid1 = "1234";
        String invalid2 = "!@#$%^&";
        String invalid3 = "It@m 1";
        String invalid4 = " Item 1";
        String invalid5 = "Item 1 ";
        String invalid6 = " Item 1 ";
        String valid = "Item 1";

        // tests for isStrictAlphaNumeric method
        assertFalse(ItemValidator.invalidItemName(invalid1));
        assertFalse(ItemValidator.invalidItemName(invalid2));
        assertFalse(ItemValidator.invalidItemName(invalid3));
        assertFalse(ItemValidator.invalidItemName(invalid4));
        assertFalse(ItemValidator.invalidItemName(invalid5));
        assertFalse(ItemValidator.invalidItemName(invalid6));
        assertTrue(ItemValidator.invalidItemName(valid));


        // tests for validate method
        // test when item name is null
        item.setItemName(null);
        assertThrows(ItemNotValidException.class, () -> validate(item));

        // itemName cannot be numeric
        item.setItemName(invalid1);
        assertThrows(ItemNotValidException.class, () -> validate(item));


        // itemName cannot contain special characters
        item.setItemName(invalid2);
        assertThrows(ItemNotValidException.class, () -> validate(item));

        item.setItemName(invalid3);
        assertThrows(ItemNotValidException.class, () -> validate(item));


        // itemName cannot contain space on first or (and) last index
        item.setItemName(invalid4);
        assertThrows(ItemNotValidException.class, () -> validate(item));

        item.setItemName(invalid5);
        assertThrows(ItemNotValidException.class, () -> validate(item));

        item.setItemName(invalid6);
        assertThrows(ItemNotValidException.class, () -> validate(item));

        // valid itemName does not throw any exception
        item.setItemName(valid);
        assertDoesNotThrow(() -> validate(item));
    }


    @Test
    public void test_valid_item_color() {

        String invalid1 = "1234";
        String invalid2 = "!@#$%^&";
        String invalid3 = "light blue 1";
        String invalid4 = " lightblue";
        String invalid5 = "lightblue ";
        String invalid6 = " light blue ";
        String valid = "light blue";

        // tests for isStrictAlphabetic method
        assertFalse(ItemValidator.invalidItemColor(invalid1));
        assertFalse(ItemValidator.invalidItemColor(invalid2));
        assertFalse(ItemValidator.invalidItemColor(invalid3));
        assertFalse(ItemValidator.invalidItemColor(invalid4));
        assertFalse(ItemValidator.invalidItemColor(invalid5));
        assertFalse(ItemValidator.invalidItemColor(invalid6));

        assertTrue(ItemValidator.invalidItemColor(valid));

        // tests for validate method
        // test when itemColor is null
        item.setItemColor(null);
        assertThrows(ItemNotValidException.class, () -> validate(item));

        // itemColor cannot be numeric
        item.setItemColor(invalid1);
        assertThrows(ItemNotValidException.class, () -> validate(item));


        // itemColor cannot contain special characters
        item.setItemColor(invalid2);
        assertThrows(ItemNotValidException.class, () -> validate(item));

        // itemColor cannot be alphanumerical
        item.setItemColor(invalid3);
        assertThrows(ItemNotValidException.class, () -> validate(item));

        // itemColor cannot contain space on first or (and) last index
        item.setItemColor(invalid4);
        assertThrows(ItemNotValidException.class, () -> validate(item));

        item.setItemColor(invalid5);
        assertThrows(ItemNotValidException.class, () -> validate(item));

        item.setItemColor(invalid6);
        assertThrows(ItemNotValidException.class, () -> validate(item));

        item.setItemColor(valid);
        assertDoesNotThrow(() -> validate(item));
    }
//
//
//    // testing valid birthdate will be updated in the future
//
//
//    @Test
//    public void test_valid_user_id_and_password() {
//
//        // test when user did not add his/her user id
//        assertThrows(ItemNotValidException.class, () -> ItemValidator.execute(user));
//
//        // test when user's id length is less than 4
//        user.setUserId("a12");
//        assertThrows(ItemNotValidException.class, () -> ItemValidator.execute(user));
//
//        // test when user's id alphanumeric
//        user.setUserId("abc");
//        assertThrows(ItemNotValidException.class, () -> ItemValidator.execute(user));
//        user.setUserId("123");
//        assertThrows(ItemNotValidException.class, () -> ItemValidator.execute(user));
//
//        // test when user did not add his/her user password
//        assertThrows(ItemNotValidException.class, () -> ItemValidator.execute(user));
//
//        // test when user's password length is less than 4
//        user.setUserPassword("123");
//        assertThrows(ItemNotValidException.class, () -> ItemValidator.execute(user));
//
//        user.setUserPassword(" ");
//        assertThrows(ItemNotValidException.class, () -> ItemValidator.execute(user));
//    }
}
