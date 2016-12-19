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
                .id(resultSet.getInt(12))
                .discount(resultSet.getInt(28))
                .registrationDate(resultSet.getInt(29))
                .build();
        Customer customer = new Customer.Builder()
                .id(resultSet.getInt(2))
                .gender(resultSet.getString(8))
                .lastName(resultSet.getString(9))
                .firstName(resultSet.getString(10))
                .middleName(resultSet.getString(11))
                .discountCard(discountCard)
                .phone(resultSet.getString(13))
                .birthDate(resultSet.getDate(14))
                .build();
        Specialization specialization = new Specialization.Builder()
                .id(resultSet.getInt(21))
                .type(resultSet.getString(31))
                .build();
        Employee employee = new Employee.Builder()
                .id(resultSet.getInt(3))
                .lastName(resultSet.getString(18))
                .firstName(resultSet.getString(19))
                .middleName(resultSet.getString(20))
				.phone(resultSet.getString(22))
                .specialization(specialization)
                .build();
        Svc svc = new Svc.Builder()
                .id(resultSet.getInt(4))
                .type(resultSet.getString(24))
                .specialization(specialization)
                .price(resultSet.getInt(26))
                .build();
        return new Record.Builder()
                .id(resultSet.getInt(1))
                .startTime(resultSet.getLong(5))
                .endTime(resultSet.getLong(6))
                .customer(customer)
                .svc(svc)
                .employee(employee)
                .build();
    }
}
