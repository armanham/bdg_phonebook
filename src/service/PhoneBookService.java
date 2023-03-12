package service;

import model.Contact;
import model.EmailType;
import model.PhoneNumberType;
import model.User;
import repository.PhoneBookRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhoneBookService implements PhoneBookRepository {

    private List<User> users = new ArrayList<>();


    @Override
    public User add(String name, List<String> phoneNumbers) {
        if (name == null || name.isEmpty() || phoneNumbers == null || phoneNumbers.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }

        User newUser = new User(name, phoneNumbers);
        if (users.contains(newUser)) {
            System.out.println("User already exists: ");
            return null;
        }

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                System.out.println("Username already exists: ");
                return null;
            }
            for (int j = 0; j < phoneNumbers.size(); j++) {
                if (users.get(i).getPhoneNumbers().get(j).equals(phoneNumbers.get(j))) {
                    System.out.println("Phone number already exists: ");
                    return null;
                }
            }
        }

        users.add(newUser);
        return newUser;
    }


    @Override
    public User updateBy(String name,
                         String newName,
                         List<String> newPhoneNumbers,
                         List<String> newEmails,
                         String newCompany,
                         PhoneNumberType newNumberType,
                         EmailType newEmailType) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }

        User user = searchBy(name);
        if (user == null) {
            System.out.println("User with this name does not exists: ");
            return null;
        }

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                if (newName != null && !newName.isEmpty()) {
                    users.get(i).setName(newName);
                }
                if (newPhoneNumbers != null && !newPhoneNumbers.isEmpty()) {
                    users.get(i).setPhoneNumbers(newPhoneNumbers);
                }
                if (newEmails != null && !newEmails.isEmpty()) {
                    users.get(i).setEmails(newEmails);
                }
                if (newCompany != null && !newCompany.isEmpty()) {
                    users.get(i).setCompany(newCompany);
                }
                if (newNumberType != null) {
                    users.get(i).setNumberType(newNumberType);
                }
                if (newEmailType != null) {
                    users.get(i).setEmailType(newEmailType);
                }
                return users.get(i);
            }
        }
        return null;
    }


    @Override
    public boolean deleteBy(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }

        User user = searchBy(name);
        if (user == null) {
            System.out.println("User with this name does not exists: ");
            return false;
        }

        return users.remove(user);
    }


    @Override
    public void view() {
        System.out.println(users);
    }


    @Override
    public User searchBy(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }

        for (User item : users) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }


    @Override
    public void sortByName() {
        users.sort(Comparator.comparing(Contact::getName));
    }
}