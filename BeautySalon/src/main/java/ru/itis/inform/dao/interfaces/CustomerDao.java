package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Customer;
import ru.itis.inform.models.Record;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
public interface CustomerDao {

    int saveCustomer(Customer customer);

    void deleteCustomer(int id);

    void updateCustomer(Customer customer, int id);

    Customer getCustomerByPhone(String phoneNumber);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomers();

    Customer getCustomerByToken(String token);

}
