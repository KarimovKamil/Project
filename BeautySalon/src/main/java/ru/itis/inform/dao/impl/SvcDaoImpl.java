package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.SvcDao;
import ru.itis.inform.dao.mappers.SvcMapper;
import ru.itis.inform.models.Svc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manymuch on 19.10.2016.
 */
@Repository
public class SvcDaoImpl implements SvcDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String SQL_ADD = 
            "INSERT INTO service " +
                    "(type, specialization_id, price) " +
                    "VALUES " +
                    "(:type, :specializationId, :price) RETURNING service.service_id;";
    
    private static String SQL_DELETE = 
            "DELETE FROM service " +
                    "WHERE (service_id = :serviceId);";
    
    private static String SQL_UPDATE = 
            "UPDATE service " +
                    "SET (type, specialization_id, price) " +
                    "= (:type, :specializationId, :price) WHERE (service_id = :serviceId);";
    
    private static String SQL_GET_BY_ID = 
            "SELECT * FROM service s " +
                    "INNER JOIN specialization sp ON s.specialization_id = sp.specialization_id " +
                    "WHERE (s.service_id = :serviceId);";
    
    private static String SQL_GET_BY_NAME =
            "SELECT * FROM service s " +
                    "INNER JOIN specialization sp ON s.specialization_id = sp.specialization_id " +
                    "WHERE (s.type = :type);";

    private static String SQL_GET_ALL = 
            "SELECT * FROM service s " +
                    "INNER JOIN specialization sp ON s.specialization_id = sp.specialization_id;";

    @Override
    public int addNewService(Svc svc) {
        Map<String, Object> params = new HashMap<>();
        params.put("serviceId", svc.getId());
        params.put("type", svc.getSpecialization().getId());
        params.put("price", svc.getPrice());
        return namedParameterJdbcTemplate.queryForObject(SQL_ADD, params, Integer.class);
    }

    @Override
    public void deleteService(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("serviceId", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }

    @Override
    public void updateService(Svc svc, int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("serviceId", id);
        params.put("type", svc.getSpecialization().getId());
        params.put("price", svc.getPrice());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    @Override
    public Svc getServiceById(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("serviceId", id);
        return (Svc) namedParameterJdbcTemplate.queryForObject(SQL_GET_BY_ID, params, new SvcMapper());
    }

    @Override
    public Svc getServiceByName(String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("type", type);
        return (Svc) namedParameterJdbcTemplate.queryForObject(SQL_GET_BY_NAME, params, new SvcMapper());
    }

    @Override
    public List<Svc> getAllServices() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL, new SvcMapper());
    }
}
