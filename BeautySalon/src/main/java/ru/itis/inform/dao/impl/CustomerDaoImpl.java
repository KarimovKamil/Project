package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.dao.mappers.CustomerMapper;
import ru.itis.inform.models.Customer;
import ru.itis.inform.models.Record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manymuch on 19.10.2016.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String SQL_SAVE = "INSERT INTO customer (gender, last_name, first_name, middle_name, card_id, phone_number, birth_date)" +
            " VALUES (:gender, :lastName, :firstName, :middleName, :cardId, :phoneNumber, :birthDate);";

    private static String SQL_DELETE = "DELETE FROM customer WHERE (customer_id = :customerId);";

    private static String SQL_UPDATE = "UPDATE customer SET (gender, last_name, first_name, middle_name, card_id, phone_number, birth_date) =" +
            "(:gender, :lastName, :firstName, :middleName, :cardId, :phoneNumber, :birthDate) WHERE (customer_id = :customerId);";

    private static String SQL_GET_BY_PHONE = "SELECT * FROM customer WHERE (phone_number = :phoneNumber);";

    private static String SQL_GET_BY_ID = "SELECT * FROM customer WHERE (customer_id = :customerId);";

    private static String SQL_GET_RECORDS_BY_ID = "SELECT * FROM record WHERE (customer_id = :customerId);";

    private static String SQL_GET_RECORDS_BY_PHONE = "SELECT * FROM record AS r INNER JOIN customer AS c " +
            "ON (r.customer_id = c.customer_id) WHERE (c.phone_number = :phoneNumber);";

    private static String SQL_GET_ALL = "SELECT * FROM customer";

    private static String SQL_GET_BY_TOKEN = "SELECT * FROM customer WHERE (token = :token)";

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

    @Override
    public Customer getCustomerByToken(String token) {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        return (Customer) namedParameterJdbcTemplate.queryForObject(SQL_GET_BY_TOKEN, params, new CustomerMapper());
    }
}
