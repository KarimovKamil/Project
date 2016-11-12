package ru.itis.inform.models;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class Customer {
    private int id;
    private char gender;
    private String lastName;
    private String firstName;
    private String middleName;
    private int cardId;
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
        cardId = builder.cardId;
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

    public int getCardId() {
        return cardId;
    }

    public String getPhone() {
        return phone;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public static class Builder {
        private int id;
        private char gender;
        private String lastName;
        private String firstName;
        private String middleName;
        private int cardId;
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

        public Builder cardId(int arg) {
            cardId = arg;
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
