package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Employee;
import ru.itis.inform.models.Record;
import ru.itis.inform.models.WorkTime;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
public interface EmployeeDao {

    int saveEmployee(Employee employee);

    void deleteEmployee(int id);

    void updateEmployee(Employee employee, int id);

    Employee getEmployee(int id);

    List<Employee> getAllEmployees();

    List<WorkTime> getEmployeeWorkTime(int id);

    void updateWorkTime(int id, WorkTime workTime);

    List<Employee> getEmployeesBySpecialization(int specializationId);

}
