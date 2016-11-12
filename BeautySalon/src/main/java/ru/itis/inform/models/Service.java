package ru.itis.inform.models;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class Service {
    private int id;
    private String type;
    private int specializationId;
    private int price;

    public Service() {
    }

    public Service(Builder builder) {
        id = builder.id;
        type = builder.type;
        specializationId = builder.specializationId;
        price = builder.price;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public int getPrice() {
        return price;
    }

    public static class Builder {
        private int id;
        private String type;
        private int specializationId;
        private int price;

        public Builder id(int arg) {
            id = arg;
            return this;
        }

        public Builder type(String arg) {
            type = arg;
            return this;
        }

        public Builder specializationId(int arg) {
            specializationId = arg;
            return this;
        }

        public Builder price(int arg) {
            price = arg;
            return this;
        }

        public Service build() {
            return new Service(this);
        }
    }
}
