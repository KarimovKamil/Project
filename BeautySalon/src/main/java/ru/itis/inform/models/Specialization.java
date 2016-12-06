package ru.itis.inform.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialization that = (Specialization) o;
        return id == that.id &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
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
