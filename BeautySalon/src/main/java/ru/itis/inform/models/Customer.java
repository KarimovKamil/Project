package ru.itis.inform.models;

import java.util.Objects;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class Customer {
    private int id;
    private char gender;
    private String lastName;
    private String firstName;
    private String middleName;
    private DiscountCard discountCard;
    private String phone;
    private long birthDate;

    public Customer() {
    }

    public Customer(Builder builder) {
        id = builder.id;
        gender = builder.gender;
        lastName = builder.lastName;
        firstName = builder.firstName;
        middleName = builder.middleName;
        discountCard = builder.discountCard;
        phone = builder.phone;
        birthDate = builder.birthDate;
    }

    public int getId() {
        return id;
    }

    public char getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public String getPhone() {
        return phone;
    }

    public long getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                gender == customer.gender &&
                birthDate == customer.birthDate &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(middleName, customer.middleName) &&
                Objects.equals(discountCard, customer.discountCard) &&
                Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender, lastName, firstName, middleName, discountCard, phone, birthDate);
    }

    public static class Builder {
        private int id;
        private char gender;
        private String lastName;
        private String firstName;
        private String middleName;
        private DiscountCard discountCard;
        private String phone;
        private long birthDate;

        public Builder id(int arg) {
            id = arg;
            return this;
        }

        public Builder gender(char arg) {
            gender = arg;
            return this;
        }

        public Builder lastName(String arg) {
            lastName = arg;
            return this;
        }

        public Builder firstName(String arg) {
            firstName = arg;
            return this;
        }

        public Builder middleName(String arg) {
            middleName = arg;
            return this;
        }

        public Builder discountCard(DiscountCard arg) {
            discountCard = arg;
            return this;
        }

        public Builder phone(String arg) {
            phone = arg;
            return this;
        }

        public Builder birthDate(long arg) {
            birthDate = arg;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
