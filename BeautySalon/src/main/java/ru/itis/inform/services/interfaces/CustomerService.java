package ru.itis.inform.services.interfaces;

import ru.itis.inform.models.Customer;
import ru.itis.inform.models.Employee;
import ru.itis.inform.models.Record;
import ru.itis.inform.models.Svc;

import java.sql.Time;
import java.util.List;

/**
 * Created by Kamil Karimov on 13.11.2016.
 */
public interface CustomerService {

    Customer getPersonalInfo(String token);

    Customer updatePersonalInfo(String token, Customer customer);

    Record getRecordById(String token, int recordId);

    List<Record> getCustomerRecord(String token);

    List<Svc> getAllServices();

    Employee getEmployeeInfo(int employeeId);

    List<Employee> getAllEmployees();

    List<Employee> getEmployessBySpecialization(int specializationId);

    Record recording(String token, int employeeId, int serviceId, Time start, Time end);

    Customer deleteRecording(String token, int recordId);

    Customer login(String identifier, String password);

    Customer registration(String phone, String password);
}
