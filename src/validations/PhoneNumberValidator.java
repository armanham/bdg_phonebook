package validations;

import model.phone.Phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private static final String PHONE_PATTERN = "\\d{10}";
         //   "^\\+(?:[0-9] ?){6,14}[0-9]$";

    private static final Pattern pattern = Pattern.compile(PHONE_PATTERN);

    public static boolean isValid(Phone phone) {
        Matcher matcher = pattern.matcher(phone.getNumber());
        return matcher.matches();
    }
}