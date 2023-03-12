package model;

import java.util.List;

public class User extends Contact implements Comparable {


    private PhoneNumberType numberType;
    private EmailType emailType;

    public User(String name, List<String> phoneNumbers) {
        super(name, phoneNumbers);
    }


    public PhoneNumberType getNumberType() {
        return numberType;
    }

    public void setNumberType(PhoneNumberType numberType) {
        if (numberType == null) {
            System.out.println("Passed null value: ");
            return;
        }
        this.numberType = numberType;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailType emailType) {
        if (emailType == null) {
            System.out.println("Passed null value: ");
            return;
        }
        this.emailType = emailType;
    }

    private boolean isNull(User user) {
        return user == null;
    }

    @Override
    public String toString() {
        return super.toString() + "User{" +
                "numberType=" + numberType +
                ", emailType=" + emailType +
                "}\n";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}