package com.madebywizard.ecommerce.user.validators;

import com.madebywizard.ecommerce.exceptions.ErrorMessages;
import com.madebywizard.ecommerce.exceptions.UserNotValidException;
import com.madebywizard.ecommerce.user.model.User;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserValidator {

    private UserValidator() {

    }

    public static void execute(User user) {

        if (!StringUtils.hasText(user.getFirstName()) || !StringUtils.hasText(user.getLastName())) {
            throw new UserNotValidException(ErrorMessages.ELEMENT_REQUIRED.getMessage());
        }

        if (!isAlphabetic(user.getFirstName()) || !isAlphabetic(user.getLastName())) {
            throw new UserNotValidException(ErrorMessages.ALPHABETIC_REQUIRED.getMessage());
        }

        if (!(user.getSex() == 'M' || user.getSex() == 'F') || !isAlphabetic(String.valueOf(user.getSex()))) {
            throw new UserNotValidException(ErrorMessages.ONLY_M_OR_F_REQUIRED.getMessage());
        }

        if (!isValidDate(user.getBirthDate())) {
            throw new UserNotValidException(ErrorMessages.BIRTHDATE_FORMAT_REQUIRED.getMessage());
        }


        if (user.getUserId().length() < 4 || user.getUserPassword().length() < 4) {
            throw new UserNotValidException(ErrorMessages.USER_ID_AND_PASSWORD_LENGTH.getMessage());
        }

        if (!isAlphanumeric(user.getUserId())) {
            throw new UserNotValidException(ErrorMessages.ALPHABETIC_REQUIRED.getMessage());
        }

        if (!StringUtils.hasText(user.getUserId())) {
            throw new UserNotValidException(ErrorMessages.ELEMENT_REQUIRED.getMessage());
        }


    }

    public static boolean isAlphabetic(String word) {

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetterOrDigit(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDate(LocalDate date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(date.toString(), formatter); // if LocalDate.parse raise an DateTimeParseException
            return true;
        } catch (DateTimeParseException exception) { // catch and return false to make sure our input date is invalid.
            return false;
        }
    }
}
