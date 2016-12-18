package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.Employee;
import ru.itis.inform.models.Specialization;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kamil Karimov on 06.12.2016.
 */
public class EmployeeMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Specialization specialization = new Specialization.Builder()
                .id(resultSet.getInt("specialization_id"))
                .type(resultSet.getString("type"))
                .build();
        return new Employee.Builder()
                .id(resultSet.getInt("employee_id"))
                .lastName(resultSet.getString("last_name"))
                .firstName(resultSet.getString("first_name"))
                .middleName(resultSet.getString("middle_name"))
                .specialization(specialization)
                .phone(resultSet.getString("phone"))
                .build();
    }
}
