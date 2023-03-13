package service;

import model.email.Email;
import model.phone.Phone;
import model.user.Contact;
import model.user.User;
import repository.PhoneBookRepository;
import validations.EmailUsernameValidator;
import validations.PhoneNumberValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhoneBookService implements PhoneBookRepository {

    private List<User> users = new ArrayList<>();
    private List<Phone> phones = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();


    @Override
    public User add(String name, List<Phone> phoneNumbers) {
        if (name == null || name.isEmpty() || phoneNumbers == null || phoneNumbers.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }
        for (Phone item : phoneNumbers) {
            if (!PhoneNumberValidator.isValid(item)) {
                throw new IllegalArgumentException("Invalid phone number: ");
            }
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
                if (users.get(i).getPhoneNumbers().get(i).equals(phoneNumbers.get(j))) {
                    System.out.println("Phone number already exists: ");
                    return null;
                }
            }
        }

        phones.addAll(newUser.getPhoneNumbers());
        users.add(newUser);
        return newUser;
    }


    @Override
    public User updateBy(String name,
                         String newName,
                         List<Phone> newPhoneNumbers,
                         List<Email> newEmails,
                         String newCompany) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }

        User user = searchBy(name);
        if (user == null) {
            System.out.println("User with this name does not exists: ");
            return null;
        }

        user = updateNameBy(name, newName);
        user = updatePhonesBy(newName, newPhoneNumbers);
        user = updateEmailsBy(newName, newEmails);
        user = updateCompanyBy(newName, newCompany);
        return user;
    }


    @Override
    public User updateNameBy(String name, String newName) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }
        if (newName == null || newName.isEmpty()) {
            System.out.println("There is no name changes: ");
            return null;
        }
        if (searchBy(newName) != null) {
            System.out.println("Username already exists: ");
            return null;
        }

        User user = searchBy(name);
        if (user == null) {
            System.out.println("User with passed name do not exists: ");
            return null;
        }

        user.setName(newName);
        return user;
    }

    @Override
    public User updatePhonesBy(String name, List<Phone> newPhoneNumbers) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }
        if (newPhoneNumbers == null || newPhoneNumbers.isEmpty()) {
            System.out.println("There is no phone number changes: ");
            return null;
        }
        for (Phone item : newPhoneNumbers) {
            if (!PhoneNumberValidator.isValid(item)) {
                throw new IllegalArgumentException("Invalid phone number: ");
            }
        }

        User user = searchBy(name);
        if (user == null) {
            System.out.println("User with passed name do not exists: ");
            return null;
        }

        for (Phone newPhoneNumber : newPhoneNumbers) {
            if (phones.contains(newPhoneNumber) && !user.getPhoneNumbers().contains(newPhoneNumber)) {
                System.out.println("This phone number belongs to other user: ");
                return null;
            }
        }

        phones.removeAll(user.getPhoneNumbers());
        phones.addAll(newPhoneNumbers);
        user.setPhoneNumbers(newPhoneNumbers);
        return user;
    }


    @Override
    public User updateEmailsBy(String name, List<Email> newEmails) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }
        if (newEmails == null || newEmails.isEmpty()) {
            System.out.println("There is no email changes: ");
            return null;
        }
        for (Email item : newEmails) {
            if (!EmailUsernameValidator.isValid(item.getUsername())) {
                throw new IllegalArgumentException("Invalid email username: ");
            }
        }

        User user = searchBy(name);
        if (user == null) {
            System.out.println("User with passed name do not exists: ");
            return null;
        }

        for (Email newEmail : newEmails) {
            if (emails.contains(newEmail) && !user.getEmails().contains(newEmail)) {
                System.out.println("This email username belongs to other user: ");
                return null;
            }
        }

        emails.removeAll(user.getEmails());
        emails.addAll(newEmails);
        user.setEmails(newEmails);
        return user;
    }

    @Override
    public User updateCompanyBy(String name, String newCompany) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value: ");
        }
        if (newCompany == null || newCompany.isEmpty()) {
            System.out.println("There is no company changes: ");
            return null;
        }

        User user = searchBy(name);
        if (user == null) {
            System.out.println("User with passed name do not exists: ");
            return null;
        }

        user.setCompany(newCompany);
        return user;
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