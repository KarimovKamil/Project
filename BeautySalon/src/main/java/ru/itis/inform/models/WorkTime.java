package ru.itis.inform.models;

import java.sql.Time;
import java.util.Objects;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class WorkTime {
    private int id;
    private Employee employee;
    private int weekday;
    private Time startTime;
    private Time endTime;

    public WorkTime() {
    }

    public WorkTime(Builder builder) {
        id = builder.id;
        employee = builder.employee;
        weekday = builder.weekday;
        startTime = builder.startTime;
        endTime = builder.endTime;
    }

    public int getId() {
        return id;
    }

    public int getWeekday() {
        return weekday;
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
        WorkTime workTime = (WorkTime) o;
        return id == workTime.id &&
                weekday == workTime.weekday &&
                Objects.equals(employee, workTime.employee) &&
                Objects.equals(startTime, workTime.startTime) &&
                Objects.equals(endTime, workTime.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, weekday, startTime, endTime);
    }

    public static class Builder {
        private int id;
        private Employee employee;
        private int weekday;
        private Time startTime;
        private Time endTime;

        public Builder id(int arg) {
            id = arg;
            return this;
        }

        public Builder employee(Employee arg) {
            employee = arg;
            return this;
        }

        public Builder weekday(int arg) {
            weekday = arg;
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

        public WorkTime build() {
            return new WorkTime(this);
        }
    }
}
