package repository;

import model.email.Email;
import model.phone.Phone;
import model.user.User;

import java.util.List;

public interface PhoneBookRepository {

    User add(String name, List<Phone> phoneNumbers);

    User updateBy(String name,
                  String newName,
                  List<Phone> phoneNumbers,
                  List<Email> emails,
                  String newCompany);

    User updateNameBy(String name, String newName);

    User updatePhonesBy(String name, List<Phone> newPhoneNumbers);

    User updateEmailsBy(String name, List<Email> newEmails);

    User updateCompanyBy(String name, String newCompany);

    boolean deleteBy(String name);

    void view();

    User searchBy(String name);

    void sortByName();
}