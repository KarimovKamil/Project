package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.EmployeeDao;
import ru.itis.inform.dao.mappers.EmployeeMapper;
import ru.itis.inform.models.Employee;
import ru.itis.inform.models.WorkTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manymuch on 19.10.2016.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String SQL_SAVE = "INSERT INTO employee (last_name, first_name, middle_name, specialization_id)" +
            " VALUES (:lastName, :firstName, :middleName, :specializationId) RETURNING employee.employee_id;";

    private static String SQL_DELETE = "DELETE FROM employee WHERE (employee_id = :employeeId);";

    private static String SQL_UPDATE = "UPDATE employee SET (last_name, first_name, middle_name, specialization_id) " +
            "= (:lastName, :firstName, :middleName, :specializationId) WHERE (employee_id = :employeeId);";

    private static String SQL_GET_BY_ID = "SELECT e.*, s.* FROM employee e INNER JOIN specialization s ON e.specialization_id = s.specialization_id " +
            "WHERE (e.employee_id = :employeeId);";

    private static String SQL_GET_ALL = "SELECT e.*, s.* FROM employee e INNER JOIN specialization s ON e.specialization_id = s.specialization_id;";

    private static String SQL_GET_WORK_TIME = "SELECT * FROM work_time WHERE (employee_id = :employeeId);";

    private static String SQL_UPDATE_WORK_TIME = "UPDATE work_time SET (weekday, start_time, end_time)" +
            " = (:weekday, :startTime, :endTime) WHERE (employee_id = :employeeId);";

    @Override
    public int saveEmployee(Employee employee) {
        Map<String, Object> params = new HashMap<>();
        params.put("lastName", employee.getLastName());
        params.put("firstName", employee.getFirstName());
        params.put("middleName", employee.getMiddleName());
        params.put("specializationId", employee.getSpecialization().getId());
        return namedParameterJdbcTemplate.queryForObject(SQL_SAVE, params, int.class);
    }

    @Override
    public void deleteEmployee(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("employeeId", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }

    @Override
    public void updateEmployee(Employee employee, int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("employeeId", id);
        params.put("lastName", employee.getLastName());
        params.put("firstName", employee.getFirstName());
        params.put("middleName", employee.getMiddleName());
        params.put("specializationId", employee.getSpecialization().getId());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);

    }

    @Override
    public Employee getEmployee(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("employeeId", id);
        return (Employee) namedParameterJdbcTemplate.queryForObject(SQL_GET_BY_ID, params, new EmployeeMapper());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
    }

    @Override
    public List<WorkTime> getEmployeeWorkTime(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("employeeId", id);
        return namedParameterJdbcTemplate.query(SQL_GET_WORK_TIME, params, new WorkTimeMapper());
    }

    @Override
    public void updateWorkTime(int id, WorkTime workTime) {
        Map<String, Object> params = new HashMap<>();
        params.put("employeeId", id);
        params.put("weekday", workTime.getWeekday());
        params.put("startTime", workTime.getStartTime());
        params.put("endTime", workTime.getEndTime());
        namedParameterJdbcTemplate.update(SQL_UPDATE_WORK_TIME, params);
    }
}
