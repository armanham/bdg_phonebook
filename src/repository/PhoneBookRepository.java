package repository;

import model.EmailType;
import model.PhoneNumberType;
import model.User;

import java.util.List;

public interface PhoneBookRepository {

    User add(String name, List<String> phoneNumbers);

    User updateBy(String name,
                  String newName,
                  List<String> phoneNumbers,
                  List<String> emails,
                  String newCompany,
                  PhoneNumberType numberType,
                  EmailType emailType);

    boolean deleteBy(String name);

    void view();

    User searchBy(String name);

    void sortByName();
}