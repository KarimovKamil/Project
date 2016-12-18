package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.Specialization;
import ru.itis.inform.models.Svc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kamil Karimov on 06.12.2016.
 */
public class SvcMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Specialization specialization = new Specialization.Builder()
                .id(resultSet.getInt("specialization_id"))
                .type(resultSet.getString("type"))
                .build();
        return new Svc.Builder()
                .id(resultSet.getInt("service_id"))
                .type(resultSet.getString("stype"))
                .specialization(specialization)
                .price(resultSet.getInt("price"))
                .build();
    }
}
