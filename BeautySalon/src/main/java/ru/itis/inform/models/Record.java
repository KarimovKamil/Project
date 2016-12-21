package ru.itis.inform.models;

import java.sql.Time;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class Record {
    private int id;
    private Customer customer;
    private Employee employee;
    private Svc svc;
    private Time startTime;
    private int weekday;

    public Record() {
    }

    public Record(Builder builder) {
        id = builder.id;
        customer = builder.customer;
        employee = builder.employee;
        svc = builder.svc;
        startTime = builder.startTime;
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

    public int getWeekday() {
        return weekday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSvc(Svc svc) {
        this.svc = svc;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public static class Builder {
        private int id;
        private Customer customer;
        private Employee employee;
        private Svc svc;
        private Time startTime;
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
        
        public Builder weekday(int arg) {
            weekday = arg;
            return this;
        }

        public Record build() {
            return new Record(this);
        }
    }
}
