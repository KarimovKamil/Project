package ru.itis.inform.models;

import java.sql.Time;
import java.util.Objects;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class Record {
    private int id;
    private Customer customer;
    private Employee employee;
    private Service service;
    private Time startTime;
    private Time endTime;

    public Record() {
    }

    public Record(Builder builder) {
        id = builder.id;
        customer = builder.customer;
        employee = builder.employee;
        service = builder.service;
        startTime = builder.startTime;
        endTime = builder.endTime;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Service getService() {
        return service;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return id == record.id &&
                Objects.equals(customer, record.customer) &&
                Objects.equals(employee, record.employee) &&
                Objects.equals(service, record.service) &&
                Objects.equals(startTime, record.startTime) &&
                Objects.equals(endTime, record.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, employee, service, startTime, endTime);
    }

    public static class Builder {
        private int id;
        private Customer customer;
        private Employee employee;
        private Service service;
        private Time startTime;
        private Time endTime;

        public Builder id(int arg) {
            id = arg;
            return this;
        }

        public Builder customer(Customer arg) {
            customer = arg;
            return this;
        }

        public Builder employeeId(Employee arg) {
            employee = arg;
            return this;
        }

        public Builder serviceId(Service arg) {
            service = arg;
            return this;
        }

        public Builder startTime(Time arg) {
            startTime = arg;
            return this;
        }

        public Builder endTime(Time arg) {
            endTime = arg;
            return this;
        }

        public Record build() {
            return new Record(this);
        }
    }
}
