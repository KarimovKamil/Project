package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.SpecializationDao;
import ru.itis.inform.dao.mappers.SpecializationMapper;
import ru.itis.inform.models.Specialization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 29.11.2016.
 */
@Repository
public class SpecializationDaoImpl implements SpecializationDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String SQL_SAVE =
            "INSERT INTO specialization (type) VALUES (:type) RETURNING specialization.specialization_id;";

    private static String SQL_DELETE =
            "DELETE FROM specialization WHERE specialization_id = :specializationId;";

    private static String SQL_UPDATE =
            "UPDATE specialization SET (type) = (:type) WHERE specialization_id = :specializationId;";

    private static String SQL_GET_BY_ID =
            "SELECT * FROM specialization WHERE specialization_id = :specializationId;";

    private static String SQL_GET_ALL =
            "SELECT * FROM specialization;";

    @Override
    public int saveSpecialization(Specialization specialization) {
        Map<String, Object> params = new HashMap<>();
        params.put("type", specialization.getType());
        return namedParameterJdbcTemplate.queryForObject(SQL_SAVE, params, int.class);
    }

    @Override
    public void deleteSpecialization(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("specializationId", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }

    @Override
    public void updateSpecialization(Specialization specialization, int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("specializationId", id);
        params.put("type", specialization.getType());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    @Override
    public Specialization getSpecializationById(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("specializationId", id);
        return (Specialization) namedParameterJdbcTemplate.queryForObject(SQL_GET_BY_ID, params, new SpecializationMapper());
    }

    @Override
    public List<Specialization> getAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL, new SpecializationMapper());
    }
}
