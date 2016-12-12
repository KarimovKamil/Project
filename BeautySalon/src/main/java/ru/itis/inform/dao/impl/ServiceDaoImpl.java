package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.ServiceDao;
import ru.itis.inform.models.Service;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
@Repository
public class ServiceDaoImpl implements ServiceDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int addNewService(Service service) {
        return 0;
    }

    @Override
    public void deleteService(int id) {

    }

    @Override
    public void updateService(Service service) {

    }

    @Override
    public Service getServiceById(int id) {
        return null;
    }

    @Override
    public Service getServiceByName(String type) {
        return null;
    }

    @Override
    public List<Service> getAllServices() {
        return null;
    }
}
