package ru.itis.inform.models;

import java.sql.Time;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class Record {
    private int id;
    private int customerId;
    private int employeeId;
    private int seviceId;
    private Time startTime;
    private Time endTime;

    public Record() {
    }

    public Record(Builder builder) {
        id = builder.id;
        customerId = builder.customerId;
        employeeId = builder.employeeId;
        seviceId = builder.seviceId;
        startTime = builder.startTime;
        endTime = builder.endTime;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getSeviceId() {
        return seviceId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public static class Builder {
        private int id;
        private int customerId;
        private int employeeId;
        private int seviceId;
        private Time startTime;
        private Time endTime;

        public Builder id(int arg) {
            id = arg;
            return this;
        }

        public Builder customerId(int arg) {
            customerId = arg;
            return this;
        }

        public Builder employeeId(int arg) {
            employeeId = arg;
            return this;
        }

        public Builder serviceId(int arg) {
            seviceId = arg;
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
