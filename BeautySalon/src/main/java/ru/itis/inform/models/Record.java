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
    private Svc svc;
    private Time startTime;
    private Time endTime;
    private int weekday;

    public Record() {
    }

    public Record(Builder builder) {
        id = builder.id;
        customer = builder.customer;
        employee = builder.employee;
        svc = builder.svc;
        startTime = builder.startTime;
        endTime = builder.endTime;
        weekday = builder.weekday;
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

    public Svc getSvc() {
        return svc;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public int getWeekday() {
        return weekday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return id == record.id &&
                startTime == record.startTime &&
                endTime == record.endTime &&
                weekday == record.weekday &&
                Objects.equals(customer, record.customer) &&
                Objects.equals(employee, record.employee) &&
                Objects.equals(svc, record.svc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, employee, svc, startTime, endTime, weekday);
    }

    public static class Builder {
        private int id;
        private Customer customer;
        private Employee employee;
        private Svc svc;
        private Time startTime;
        private Time endTime;
        private int weekday;

        public Builder id(int arg) {
            id = arg;
            return this;
        }

        public Builder customer(Customer arg) {
            customer = arg;
            return this;
        }

        public Builder employee(Employee arg) {
            employee = arg;
            return this;
        }

        public Builder svc(Svc arg) {
            svc = arg;
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
        
        public Builder weekday(int arg) {
            weekday = arg;
            return this;
        }

        public Record build() {
            return new Record(this);
        }
    }
}
