package ru.itis.inform.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.inform.models.Specialization;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kamil Karimov on 06.12.2016.
 */
public class SpecializationMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Specialization.Builder()
                .id(resultSet.getInt("specialization_id"))
                .type(resultSet.getString("type"))
                .build();
    }
}
