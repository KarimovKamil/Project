package ru.itis.inform.dao.impl;

import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.models.Customer;
import ru.itis.inform.models.Record;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public int saveCustomer(Customer customer) {
        return 0;
    }

    @Override
    public void deleteCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public Customer getCustomerByPhone(String phoneNumber) {
        return null;
    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }

    @Override
    public List<Record> getCustomerRecordsById(int id) {
        return null;
    }

    @Override
    public List<Record> getCustomerRecordsByPhone(String phone) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }
}
