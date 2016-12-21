package ru.itis.inform.dto;

import java.sql.Time;
import java.util.Objects;

/**
 * Created by anteg on 18.12.2016.
 */
public class RecordDto {
    private int customerId;
    private int employeeId;
    private int serviceId;
    private int weekday;
    private Time startTime;

    public RecordDto() {
    }

    public RecordDto(Builder builder) {
        this.customerId = builder.customerId;
        this.employeeId = builder.employeeId;
        this.serviceId = builder.serviceId;
        this.weekday = builder.weekday;
        this.startTime = builder.startTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public int getWeekday() {
        return weekday;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public static class Builder {
        private int employeeId;
        private int serviceId;
        private int weekday;
        private Time startTime;
        private int customerId;

        public  Builder customerId(int arg) {
            this.customerId = arg;
            return this;
        }

        public Builder employeeId(int arg) {
            this.employeeId = arg;
            return this;
        }

        public Builder serviceId(int arg) {
            this.serviceId = arg;
            return this;
        }

        public Builder weekday(int arg) {
            this.weekday = arg;
            return this;
        }

        public Builder startTime(Time arg) {
            this.startTime = arg;
            return this;
        }

        public RecordDto build() {
            return new RecordDto(this);
        }
    }
}
