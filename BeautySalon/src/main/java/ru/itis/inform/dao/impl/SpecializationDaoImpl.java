package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.SpecializationDao;
import ru.itis.inform.models.Specialization;

import java.util.List;

/**
 * Created by Kamil Karimov on 29.11.2016.
 */
@Repository
public class SpecializationDaoImpl implements SpecializationDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int saveSpecialization(Specialization specialization) {
        return 0;
    }

    @Override
    public void deleteSpecialization(int id) {

    }

    @Override
    public void updateSpecialization(Specialization specialization) {

    }

    @Override
    public Specialization getSpecializationById(int id) {
        return null;
    }

    @Override
    public List<Specialization> getAll() {
        return null;
    }
}
