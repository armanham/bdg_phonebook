package model.email;

import java.util.Objects;

public class Email {

    private String username;
    private EmailType type;

    public Email(String username, EmailType type) {
        setUsername(username);
        setType(type);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            System.out.println("Passed null or empty value: ");
            return;
        }
        this.username = username;
    }

    public EmailType getType() {
        return type;
    }

    public void setType(EmailType type) {
        if (type == null) {
            System.out.println("Passed null value: ");
            return;
        }
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(username, email.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "Email{" +
                "username='" + username + '\'' +
                ", type=" + type +
                '}';
    }
}