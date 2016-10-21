package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Service;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
public interface ServiceDao {

    int addNewService(Service service);

    void deleteService(int id);

    void updateService(Service service);

    Service getServiceById(int id);

    Service getServiceByName(String type);

    List<Service> getAllServices();

}
