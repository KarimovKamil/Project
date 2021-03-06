package ru.itis.inform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.dao.interfaces.EmployeeDao;
import ru.itis.inform.dao.interfaces.RecordDao;
import ru.itis.inform.dao.interfaces.SvcDao;
import ru.itis.inform.dto.RecordDto;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.models.*;
import ru.itis.inform.services.interfaces.CustomerService;
import ru.itis.inform.services.utils.generators.HashGenerator;
import ru.itis.inform.services.utils.generators.TokenGenerator;
import ru.itis.inform.validation.RecordDtoValidation;
import ru.itis.inform.validation.ValidationFactory;

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
    @Autowired
    RecordDtoValidation recordDtoValidation;

    @Override
    public Customer getPersonalInfo(String token) {
        return customerDao.getCustomerByToken(token);
    }

    @Override
    public Customer updatePersonalInfo(String token, Customer customer) {
        validationFactory.customerExistenceByToken(token);
        validationFactory.verifyGender(customer.getGender());

        Customer dbCustomer = customerDao.getCustomerByToken(token);
        customer.setToken(dbCustomer.getToken());
        if (!customer.getPhone().equals(dbCustomer.getPhone())) {
            validationFactory.verifyPhone(customer.getPhone());
            validationFactory.customerPhoneUnique(customer.getPhone());
        }
        if (!hashGenerator.match(customer.getHashPassword(), dbCustomer.getHashPassword()) && !customer.getHashPassword().equals("")) {
            validationFactory.verifyPassword(customer.getHashPassword());
            customer.setHashPassword(hashGenerator.encode(customer.getHashPassword()));
        } else {
            customer.setHashPassword(dbCustomer.getHashPassword());
        }
        customer.setDiscountCard(dbCustomer.getDiscountCard());
        customerDao.updateCustomer(customer, dbCustomer.getId());
        return customer;
    }

    @Override
    public void deleteCustomer(String token) {
        validationFactory.customerExistenceByToken(token);
        Customer customer = customerDao.getCustomerByToken(token);
        customerDao.deleteCustomer(customer.getId());
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
    public List<WorkTime> getEmployeeWortTime(int employeeId) {
        validationFactory.employeeExistenceById(employeeId);
        List<WorkTime> workTimes = employeeDao.getEmployeeWorkTime(employeeId);
        return workTimes;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeDao.getAllEmployees();
        return employees;
    }

    @Override
    public List<Employee> getEmployeesBySpecialization(int specializationId) {
        validationFactory.specializationExistenceById(specializationId);
        List<Employee> employees = employeeDao.getEmployeesBySpecialization(specializationId);
        return employees;
    }

    @Override
    public void recording(String token, RecordDto recordDto) {
        validationFactory.customerExistenceByToken(token);
        validationFactory.employeeExistenceById(recordDto.getEmployeeId());
        validationFactory.serviceExistenceById(recordDto.getServiceId());
        validationFactory.employeeServiceMatch(recordDto.getEmployeeId(), recordDto.getServiceId());
        recordDtoValidation.verifyRecordDto(recordDto, 0);
        Customer customer = customerDao.getCustomerByToken(token);
        recordDto.setCustomerId(customer.getId());
        recordDao.addNewRecord(recordDto);
    }

    @Override
    public Customer deleteRecording(String token, int recordId) {
        Customer customer = customerDao.getCustomerByToken(token);
        validationFactory.customerRecordExistence(customer.getId(), recordId);
        recordDao.deleteRecord(recordId);
        return customer;
    }

    @Override
    public String login(String identifier, String password) {
        validationFactory.verifyPhone(identifier);
        validationFactory.verifyPassword(password);
        validationFactory.customerExistenceByPhone(identifier);

        Customer customer = customerDao.getCustomerByPhone(identifier);
        String token = tokenGenerator.generateToken();
        if (hashGenerator.match(password, customer.getHashPassword())) {
            customer.setToken(token);
            customerDao.updateCustomer(customer, customer.getId());
            return customer.getToken();
        } else {
            throw new IncorrectDataException("Incorrect data");
        }
    }

    @Override
    public String registration(String phone, String password) {
        validationFactory.verifyPhone(phone);
        validationFactory.verifyPassword(password);
        validationFactory.customerPhoneUnique(phone);
        String hash = hashGenerator.encode(password);
        String token = tokenGenerator.generateToken();
        Customer customer = new Customer.Builder()
                .phone(phone)
                .hashPassword(hash)
                .token(token)
                .build();
        customerDao.saveCustomer(customer);
        return token;
    }

    @Override
    public Svc getSvcById(int id) {
        validationFactory.serviceExistenceById(id);
        return svcDao.getServiceById(id);
    }

    @Override
    public Record updateRecord(String token, RecordDto recordDto, int id) {
        Customer customer = customerDao.getCustomerByToken(token);
        validationFactory.customerRecordExistence(customer.getId(), id);
        Record record = recordDao.getRecord(id);
        recordDto.setEmployeeId(record.getEmployee().getId());
        recordDtoValidation.verifyRecordDto(recordDto, id);
        return recordDao.updateRecord(recordDto, id);
    }
}
