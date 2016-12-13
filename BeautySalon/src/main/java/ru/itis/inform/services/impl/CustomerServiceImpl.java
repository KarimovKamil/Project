package ru.itis.inform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.dao.interfaces.EmployeeDao;
import ru.itis.inform.dao.interfaces.RecordDao;
import ru.itis.inform.dao.interfaces.SvcDao;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.models.*;
import ru.itis.inform.services.interfaces.CustomerService;
import ru.itis.inform.services.utils.generators.HashGenerator;
import ru.itis.inform.services.utils.generators.TokenGenerator;
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
    HashGenerator hashGenerator;
    @Autowired
    TokenGenerator tokenGenerator;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    RecordDao recordDao;
    @Autowired
    SvcDao svcDao;
    @Autowired
    EmployeeDao employeeDao;

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
        Customer customer = customerDao.getCustomerByToken(token);
        validationFactory.customerRecordExistence(customer.getId(), recordId);
        Record record = recordDao.getRecord(recordId);
        return record;
    }

    @Override
    public List<Record> getCustomerRecord(String token) {
        Customer customer = customerDao.getCustomerByToken(token);
        List<Record> records = recordDao.getCustomerRecordsById(customer.getId());
        return records;
    }

    @Override
    public List<Svc> getAllServices() {
        List<Svc> svcs = svcDao.getAllServices();
        return svcs;
    }

    @Override
    public Employee getEmployeeInfo(int employeeId) {
        validationFactory.employeeExistenceById(employeeId);
        Employee employee = employeeDao.getEmployee(employeeId);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeDao.getAllEmployees();
        return employees;
    }

    @Override
    public List<Employee> getEmployessBySpecialization(int specializationId) {
        validationFactory.specializationExistenceById(specializationId);
        List<Employee> employees = employeeDao.getEmployeesBySpecialization(specializationId);
        return employees;
    }

    @Override
    public Record recording(String token, int employeeId, int serviceId, Time start, Time end) {
        validationFactory.employeeExistenceById(employeeId);
        validationFactory.serviceExistenceById(serviceId);
        //TODO: Проверять на соответствие работника услуге(специальности)

        if (start.getTime() > end.getTime()) {
            throw new IncorrectDataException("Incorrect time");
        }

        return null;
    }

    @Override
    public Customer deleteRecording(String token, int recordId) {
        Customer customer = customerDao.getCustomerByToken(token);
        validationFactory.customerRecordExistence(customer.getId(), recordId);
        recordDao.deleteRecord(recordId);
        return customer;
    }

    @Override
    public Customer login(String identifier, String password) {
        validationFactory.verifyPhone(identifier);
        validationFactory.verifyPassword(password);
        validationFactory.customerExistenceByPhone(identifier);

        Customer customer = customerDao.getCustomerByPhone(identifier);
        String token = tokenGenerator.generateToken();
        if (hashGenerator.match(password, customer.getHashPassword())) {
            customer.setToken(token);
            customerDao.updateCustomer(customer, customer.getId());
            return customer;
        } else {
            throw new IncorrectDataException("Incorrect data");
        }
    }

    @Override
    public Customer registration(String phone, String password) {
        validationFactory.verifyPhone(phone);
        validationFactory.verifyPassword(password);
        validationFactory.customerPhoneUnique(phone);
        String hash = hashGenerator.encode(password);
        Customer customer = new Customer.Builder()
                .phone(phone)
                .hashPassword(hash)
                .build();
        customerDao.saveCustomer(customer);
        return customer;
    }
}
