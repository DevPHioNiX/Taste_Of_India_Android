/**
 * Created by %USERNAME% on 20,July,2021 Your company Your email
 **/

package com.example.testofindia.utils;

import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Urmil on 7/20/21 - 20,July,2021
 */
public class FieldValidators {

    public static boolean isValidEmail(String emailAddress) {
        return Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Patterns.PHONE.matcher(phoneNumber).matches();
    }

    public static boolean isStringContainNumber(String password) {
        Pattern pattern
                = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isStringContainSpecialCharacter(String password) {
        Pattern specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9 ]");
        Matcher specialCharacterMatcher = specialCharacterPattern.matcher(password);
        return specialCharacterMatcher.find();
    }

    public static boolean isStringLowerAndUpperCase(String password) {

        Pattern lowerCasePattern = Pattern.compile(".*[a-z].*");
        Pattern upperCasePattern = Pattern.compile(".*[A-Z].*");
        Matcher lowerCasePatterMatcher = lowerCasePattern.matcher(password);
        Matcher upperCasePatterMatcher = upperCasePattern.matcher(password);
        if (!lowerCasePatterMatcher.matches()) {
            return false;
        } else return upperCasePatterMatcher.matches();
    }

    /**
     * 1) field must not be empty
     * 2) password length must not be less than 7
     * 3) password must contain at least one digit
     * 4) password must contain atleast one upper and one lower case letter
     * 5) password must contain atleast one special character
     */
    public static boolean validatePassword(String password) {
        if (password.toString().trim().isEmpty()) {
            return false;
        } else if (password.toString().length() < CustomeConstants.PASSWORD_MIN_LENGTH ||
                password.toString().length() > CustomeConstants.PASSWORD_MAX_LENGTH) {
            return false;
        } else if (!FieldValidators.isStringContainNumber(password.toString())) {
            return false;
        } else if (!FieldValidators.isStringContainSpecialCharacter(password.toString())) {
            return false;
        } else if (!FieldValidators.isStringLowerAndUpperCase(password.toString())) {
            return false;
        }
        return true;
    }

    /**
     * @param string * @return true if string is Null Or Blank or Contains Only Space </BR> else false
     */
    public static boolean isEmptyString(String string) {
        if (string == null) {
            return true;
        } else if (string.length() == 0) {
            return true;
        } else if (string.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
