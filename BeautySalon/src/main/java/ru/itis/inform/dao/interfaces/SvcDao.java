package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Svc;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
public interface SvcDao {

    int addNewService(Svc svc);

    void deleteService(int id);

    void updateService(Svc svc);

    Svc getServiceById(int id);

    Svc getServiceByName(String type);

    List<Svc> getAllServices();

}
