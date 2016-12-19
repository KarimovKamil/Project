package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kamil Karimov on 06.12.2016.
 */
public class RecordMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        DiscountCard discountCard = new DiscountCard.Builder()
                .id(resultSet.getInt(13))
                .discount(resultSet.getInt(29))
                .registrationDate(resultSet.getLong(30))
                .build();
        Customer customer = new Customer.Builder()
                .id(resultSet.getInt(2))
                .gender(resultSet.getString(9))
                .lastName(resultSet.getString(10))
                .firstName(resultSet.getString(11))
                .middleName(resultSet.getString(12))
                .discountCard(discountCard)
                .phone(resultSet.getString(14))
                .birthDate(resultSet.getDate(15))
                .build();
        Specialization specialization = new Specialization.Builder()
                .id(resultSet.getInt(22))
                .type(resultSet.getString(32))
                .build();
        Employee employee = new Employee.Builder()
                .id(resultSet.getInt(3))
                .lastName(resultSet.getString(19))
                .firstName(resultSet.getString(20))
                .middleName(resultSet.getString(21))
				.phone(resultSet.getString(23))
                .specialization(specialization)
                .build();
        Svc svc = new Svc.Builder()
                .id(resultSet.getInt(4))
                .type(resultSet.getString(25))
                .specialization(specialization)
                .price(resultSet.getInt(27))
                .build();
        return new Record.Builder()
                .id(resultSet.getInt(1))
                .startTime(resultSet.getTime(5))
                .endTime(resultSet.getTime(6))
                .weekday(resultSet.getInt(7))
                .customer(customer)
                .svc(svc)
                .employee(employee)
                .build();
    }
}
