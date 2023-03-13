package model.user;

import model.email.Email;
import model.phone.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Contact {

    private String name;
    private List<Phone> phoneNumbers;
    private List<Email> emails = new ArrayList<>();
    private String company;

    public Contact(String name, List<Phone> phoneNumbers) {
        setName(name);
        setPhoneNumbers(phoneNumbers);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Passed null or empty value: ");
            return;
        }
        this.name = name;
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        if (phoneNumbers == null || phoneNumbers.isEmpty()) {
            System.out.println("Passed null or empty value: ");
        }
        this.phoneNumbers = phoneNumbers;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        if (emails == null || emails.isEmpty()) {
            System.out.println("Passed null or empty value: ");
        }
        this.emails = emails;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company == null || company.isEmpty()) {
            System.out.println("Passed null or empty value: ");
            return;
        }
        this.company = company;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(phoneNumbers, contact.phoneNumbers) && Objects.equals(emails, contact.emails) && Objects.equals(company, contact.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumbers, emails, company);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", emails=" + emails +
                ", company='" + company + '\'' +
                "}\n";
    }
}