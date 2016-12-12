package ru.itis.inform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.models.*;
import ru.itis.inform.services.interfaces.CustomerService;
import ru.itis.inform.validation.ValidationFactory;

import java.sql.Time;
import java.util.List;

/**
 * Created by Kamil Karimov on 13.11.2016.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    ValidationFactory validationFactory;
    @Autowired
    CustomerDao customerDao;

    @Override
    public Customer getPersonalInfo(String token) {
        return customerDao.getCustomerByToken(token);
    }

    @Override
    public Customer updatePersonalInfo(String token, Customer customer) {
        return null;
    }

    @Override
    public Record getRecordById(String token, int recordId) {
        return null;
    }

    @Override
    public List<Record> getCustomerRecord(String token) {
        return null;
    }

    @Override
    public List<Svc> getAllServices() {
        return null;
    }

    @Override
    public Employee getEmployeeInfo(int employeeId) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public List<Employee> getEmployessBySpecialization(int specializationId) {
        return null;
    }

    @Override
    public Record recording(String token, int employeeId, int serviceId, Time start, Time end) {
        return null;
    }

    @Override
    public Customer deleteRecording(String token, int recordId) {
        return null;
    }

    @Override
    public Customer login(String identifier) {
        return null;
    }

    @Override
    public Customer registration(String phone, String password) {
        return null;
    }
}
