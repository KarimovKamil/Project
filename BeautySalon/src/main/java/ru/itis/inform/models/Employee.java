package ru.itis.inform.models;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private int specializationId;
    private int salary;

    public Employee() {
    }

    public Employee(Builder builder) {
        id = builder.id;
        lastName = builder.lastName;
        firstName = builder.firstName;
        middleName = builder.middleName;
        specializationId = builder.specializationId;
        salary = builder.salary;
    }

    public int getId() {
        return id;
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

    public int getSpecializationId() {
        return specializationId;
    }

    public int getSalary() {
        return salary;
    }

    public static class Builder {
        private int id;
        private String lastName;
        private String firstName;
        private String middleName;
        private int specializationId;
        private int salary;

        public Builder id(int arg) {
            id = arg;
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

        public Builder specializationId(int arg) {
            specializationId = arg;
            return this;
        }

        public Builder salary(int arg) {
            salary = arg;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
