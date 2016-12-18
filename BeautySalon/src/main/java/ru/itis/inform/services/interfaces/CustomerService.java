package ru.itis.inform.services.interfaces;

import ru.itis.inform.models.*;

import java.sql.Time;
import java.util.List;

/**
 * Created by Kamil Karimov on 13.11.2016.
 */
public interface CustomerService {

    Customer getPersonalInfo(String token);

    Customer updatePersonalInfo(String token, Customer customer);

    void deleteCustomer(String token);

    Record getRecordById(String token, int recordId);

    List<Record> getCustomerRecord(String token);

    List<Svc> getAllServices();

    Employee getEmployeeInfo(int employeeId);

    List<WorkTime> getEmployeeWortTime(int employeeId);

    List<Employee> getAllEmployees();

    List<Employee> getEmployeesBySpecialization(int specializationId);

    Record recording(String token, int employeeId, int serviceId, int weekday, Time start, Time end);

    Customer deleteRecording(String token, int recordId);

    String login(String identifier, String password);

    String registration(String phone, String password);
}
