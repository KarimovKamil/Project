package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.DiscountCard;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kamil Karimov on 06.12.2016.
 */
public class DiscountCardMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new DiscountCard.Builder()
                .id(resultSet.getInt("card_id"))
                .discount(resultSet.getInt("discount"))
                .registrationDate(resultSet.getLong("registration_date"))
                .build();
    }
}
