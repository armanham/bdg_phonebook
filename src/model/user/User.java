package model.user;

import model.phone.Phone;

import java.util.List;

public class User extends Contact {

    public User(String name, List<Phone> phoneNumbers) {
        super(name, phoneNumbers);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}