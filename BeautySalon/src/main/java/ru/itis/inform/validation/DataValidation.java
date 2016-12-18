package ru.itis.inform.validation;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kamil Karimov on 13.12.2016.
 */
@Component
public class DataValidation {

    public boolean verifyPassword(String password) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9]*");
        Matcher matcher = pattern.matcher(password);
        return password != null && password.length() >= 8 && password.length() <= 40 && matcher.matches();
    }

    public boolean verifyPhone(String phone) {
        Pattern pattern = Pattern.compile("[0-9]{11}");
        Matcher matcher = pattern.matcher(phone);
        return phone != null && matcher.matches();
    }

    public boolean verifyGender(String gender) {
        return gender != null && gender.length() == 1 && (gender.equals("M") || gender.equals("F") ||
        gender.equals("f") || gender.equals("m"));
    }
}
