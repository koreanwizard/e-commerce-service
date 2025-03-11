package com.madebywizard.ecommerce;

import com.madebywizard.ecommerce.exceptions.ItemNotValidException;
import com.madebywizard.ecommerce.item.model.Item;
import com.madebywizard.ecommerce.item.validators.ItemValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.madebywizard.ecommerce.item.validators.ItemValidator.execute;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemValidatorTest {

    private Item user;

//    @BeforeEach
//    public void setup() {
//        user = new Item();
//    }
//
//    @Test
//    public void test_valid_first_and_last_name() {
//
//        // test when user did not add his/her first name
//        assertThrows(ItemNotValidException.class, () -> ItemValidator.execute(user));
//
//        //test when user's first name is not alphabetic
//        user.setFirstName("1234");
//        assertThrows(ItemNotValidException.class, () -> execute(user));
//        user.setFirstName("!@#$");
//        assertThrows(ItemNotValidException.class, () -> execute(user));
//        user.setFirstName("hello1234");
//        assertThrows(ItemNotValidException.class, () -> execute(user));
//
//
//        // test when user did not add his/her last name
//        assertThrows(ItemNotValidException.class, () -> ItemValidator.execute(user));
//
//        //test when user's last name is not alphabetic
//        user.setFirstName("5678");
//        assertThrows(ItemNotValidException.class, () -> execute(user));
//        user.setFirstName(")(+_=");
//        assertThrows(ItemNotValidException.class, () -> execute(user));
//        user.setFirstName("include999");
//        assertThrows(ItemNotValidException.class, () -> execute(user));
//
//
//    }
//
//
//    @Test
//    public void test_valid_sex() {
//
//        //test when user did not add his/her sex
//        assertThrows(ItemNotValidException.class, () -> ItemValidator.execute(user));
//
//        // test when user type in a different character except M or F
//        user.setSex('A');
//        assertThrows(ItemNotValidException.class, () -> execute(user));
//        user.setSex('@');
//        assertThrows(ItemNotValidException.class, () -> execute(user));
//        user.setSex('1');
//        assertThrows(ItemNotValidException.class, () -> execute(user));
//
//        // might have to think about the type of the sex attribute
//        // if user type in a string not a char this should also throw an exception
//        // when i input a string that has length greater than 1
//        // it gave me a 404 request (JSON parse error: Cannot deserialize value of type `char` from String \"hello\": Expected either Integer value code or 1-character String)
//        // maybe i can change the type to string and check the length of it
//        // if length is greater not equal to 1 -> throw an exception
//    }
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
