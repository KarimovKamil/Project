package ru.itis.inform.models;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class Specialization {
    private int id;
    private String type;

    public Specialization() {
    }

    public Specialization(Builder builder) {
        id = builder.id;
        type = builder.type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public static class Builder {
        private int id;
        private String type;

        public Builder id(int arg) {
            id = arg;
            return this;
        }

        public Builder type(String arg) {
            type = arg;
            return this;
        }

        public Specialization build() {
            return new Specialization(this);
        }
    }
}
