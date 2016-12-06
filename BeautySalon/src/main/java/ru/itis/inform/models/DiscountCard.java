package ru.itis.inform.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return id == that.id &&
                discount == that.discount &&
                registrationDate == that.registrationDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discount, registrationDate);
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
