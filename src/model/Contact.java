package model;

import java.util.List;

public abstract class Contact {

    private String name;
    private List<String> phoneNumbers;
    private List<String> emails;
    private String company;

    public Contact(String name, List<String> phoneNumbers) {
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

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        if (phoneNumbers == null || phoneNumbers.isEmpty()) {
            System.out.println("Passed null or empty value: ");
        }
        this.phoneNumbers = phoneNumbers;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
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
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", emails=" + emails +
                ", company='" + company + '\'' +
                "}\n";
    }

 //   @Override
//    public int compareTo(Contact contact) {
//        return name < contact.getName() ? -1 : name > contact.getName() ? 1 : doSecodaryOrderSort(o);
//    }
}