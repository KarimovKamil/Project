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
