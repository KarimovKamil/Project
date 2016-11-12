package ru.itis.inform.models;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class DiscountCard {
    private int id;
    private int discount;
    private long registrationDate;

    public DiscountCard() {
    }

    public DiscountCard(Builder builder) {
        id = builder.id;
        discount = builder.discount;
        registrationDate = builder.registrationDate;
    }

    public int getId() {
        return id;
    }

    public int getDiscount() {
        return discount;
    }

    public long getRegistrationDate() {
        return registrationDate;
    }

    public static class Builder {
        private int id;
        private int discount;
        private long registrationDate;

        public Builder id(int arg) {
            id = arg;
            return this;
        }

        public Builder discount(int arg) {
            discount = arg;
            return this;
        }

        public Builder registrationDate(int arg) {
            registrationDate = arg;
            return this;
        }

        public DiscountCard build() {
            return new DiscountCard(this);
        }
    }
}
