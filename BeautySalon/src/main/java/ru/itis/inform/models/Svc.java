package ru.itis.inform.models;

import java.util.Objects;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class Svc {
    private int id;
    private String type;
    private Specialization specialization;
    private int price;

    public Svc() {
    }

    public Svc(Builder builder) {
        id = builder.id;
        type = builder.type;
        specialization = builder.specialization;
        price = builder.price;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Svc svc = (Svc) o;
        return id == svc.id &&
                price == svc.price &&
                Objects.equals(type, svc.type) &&
                Objects.equals(specialization, svc.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, specialization, price);
    }

    public static class Builder {
        private int id;
        private String type;
        private Specialization specialization;
        private int price;

        public Builder id(int arg) {
            id = arg;
            return this;
        }

        public Builder type(String arg) {
            type = arg;
            return this;
        }

        public Builder specialization(Specialization arg) {
            specialization = arg;
            return this;
        }

        public Builder price(int arg) {
            price = arg;
            return this;
        }

        public Svc build() {
            return new Svc(this);
        }
    }
}
