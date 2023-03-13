package model.phone;

import java.util.Objects;

public class Phone {

    private String number;
    private PhoneType type;

    public Phone(String number, PhoneType type) {
        setNumber(number);
        setType(type);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number == null || number.isEmpty()) {
            System.out.println("Passed null or empty value: ");
            return;
        }
        this.number = number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
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
        Phone phone = (Phone) o;
        return Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }


    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", type=" + type +
                "}";
    }
}