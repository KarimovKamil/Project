package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.Employee;
import ru.itis.inform.models.Specialization;
import ru.itis.inform.models.WorkTime;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kamil Karimov on 12.12.2016.
 */
public class WorkTimeMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Specialization specialization = new Specialization.Builder()
                .id(resultSet.getInt("specialization_id"))
                .type(resultSet.getString("type"))
                .build();
        Employee employee = new Employee.Builder()
                .id(resultSet.getInt("employee_id"))
                .lastName(resultSet.getString("last_name"))
                .firstName(resultSet.getString("first_name"))
                .middleName(resultSet.getString("middle_name"))
                .specialization(specialization)
                .build();
        return new WorkTime.Builder()
                .id(resultSet.getInt("time_id"))
                .employee(employee)
                .startTime(resultSet.getLong("start_time"))
                .endTime(resultSet.getLong("end_time"))
                .build();
    }
}
