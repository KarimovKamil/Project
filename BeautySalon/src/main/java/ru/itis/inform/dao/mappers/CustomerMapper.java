package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.Customer;
import ru.itis.inform.models.DiscountCard;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kamil Karimov on 06.12.2016.
 */
public class CustomerMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        DiscountCard discountCard = new DiscountCard.Builder()
                .id(resultSet.getInt("card_id"))
                .discount(resultSet.getInt("discount"))
                .registrationDate(resultSet.getInt("registration_date"))
                .build();
        return new Customer.Builder()
                .id(resultSet.getInt("customer_id"))
                .gender(resultSet.getString("gender"))
                .lastName(resultSet.getString("last_name"))
                .firstName(resultSet.getString("first_name"))
                .middleName(resultSet.getString("middle_name"))
                .discountCard(discountCard)
                .phone(resultSet.getString("phone_number"))
                .birthDate(resultSet.getLong("birth_date"))
                .build();
    }
}
