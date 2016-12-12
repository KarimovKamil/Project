package ru.itis.inform.dao.impl;

import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.SvcDao;
import ru.itis.inform.models.Svc;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
@Repository
public class SvcDaoImpl implements SvcDao {

    private static String SQL_ADD = "INSERT INTO service (type, specialization_id, price)" +
            " VALUES (:type, :specializationId, :price);";
    private static String SQL_DELETE = "DELETE FROM service WHERE (service_id = :serviceId);";
    private static String SQL_UPDATE = "UPDATE service SET (type, specialization_id, price)" +
            " = (:type, :specializationId, :price) WHERE (service_id = :serviceId);";
    private static String SQL_GET_BY_ID = "SELECT * FROM service WHERE (service_id = :serviceId);";
    private static String SQL_GET_BY_NAME = "SELECT * FROM service WHERE (type = :type);";
    private static String SQL_GET_ALL = "SELECT * FROM service;";

    @Override
    public int addNewService(Svc svc) {
        return 0;
    }

    @Override
    public void deleteService(int id) {

    }

    @Override
    public void updateService(Svc svc) {

    }

    @Override
    public Svc getServiceById(int id) {
        return null;
    }

    @Override
    public Svc getServiceByName(String type) {
        return null;
    }

    @Override
    public List<Svc> getAllServices() {
        return null;
    }
}
