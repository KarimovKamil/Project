package ru.itis.inform.dao.impl;

import ru.itis.inform.dao.interfaces.ServiceDao;
import ru.itis.inform.models.Service;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class ServiceDaoImpl implements ServiceDao {

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
