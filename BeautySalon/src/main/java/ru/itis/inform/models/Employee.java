package ru.itis.inform.models;

import java.util.List;
import java.util.Objects;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private Specialization specialization;
    private int salary;
    private String phone;

    public Employee() {
    }

    public Employee(Builder builder) {
        id = builder.id;
        lastName = builder.lastName;
        firstName = builder.firstName;
        middleName = builder.middleName;
        specialization = builder.specialization;
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

    public Specialization getSpecialization() {
        return specialization;
    }

    public int getSalary() {
        return salary;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                salary == employee.salary &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(middleName, employee.middleName) &&
                Objects.equals(specialization, employee.specialization) &&
                Objects.equals(phone, employee.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middleName, specialization, salary, phone);
    }

    public static class Builder {
        private int id;
        private String lastName;
        private String firstName;
        private String middleName;
        private Specialization specialization;
        private int salary;
        private String phone;
        private List<WorkTime> workTimeList;

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

        public Builder specialization(Specialization arg) {
            specialization = arg;
            return this;
        }

        public Builder salary(int arg) {
            salary = arg;
            return this;
        }

        public Builder phone(String arg) {
            phone = arg;
            return this;
        }

        public Builder workTimeList(List<WorkTime> arg) {
            workTimeList = arg;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
