package ru.itis.inform.dao.impl;

import ru.itis.inform.dao.interfaces.EmployeeDao;
import ru.itis.inform.models.Employee;
import ru.itis.inform.models.Record;
import ru.itis.inform.models.WorkTime;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private static String SQL_SAVE = "INSERT INTO employee (last_name, first_name, middle_name, specialization_id)" +
            " VALUES (:lastName, :firstName, :middleName, :specializationId); ";
    private static String SQL_DELETE = "DELETE FROM employee WHERE (employee_id = :employeeId);";
    private static String SQL_UPDATE = "UPDATE employee SET (last_name, first_name, middle_name, specialization_id) " +
            "= (:lastName, :firstName, :middleName, :specializationId) WHERE (employee_id = :employeeId);";
    private static String SQL_GET_BY_ID = "SELECT * FROM employee WHERE (employee_id = :employeeId);";
    private static String SQL_GET_ALL = "SELECT * FROM employee;";
    private static String SQL_GET_RECORDS_BY_ID = "SELECT * FROM record WHERE (employee_id = :employeeId);";
    private static String SQL_GET_WORK_TIME = "SELECT * FROM work_time WHERE (employee_id = :employeeId);";
    private static String SQL_UPDATE_WORK_TIME = "UPDATE work_time SET (weekday, start_time, end_time)" +
            " = (:weekday, :startTime, :endTime) WHERE (employee_id = :employeeId);";

    @Override
    public int saveEmployee(Employee employee) {
        return 0;
    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public Employee getEmployee(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public List<Record> getEmployeeRecordsById(int id) {
        return null;
    }

    @Override
    public List<WorkTime> getEmployeeWorkTime(int id) {
        return null;
    }

    @Override
    public void updateWorkTime(int id, WorkTime workTime) {

    }
}
