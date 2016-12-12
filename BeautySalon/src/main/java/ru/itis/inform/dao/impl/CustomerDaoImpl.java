package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.dao.mappers.CustomerMapper;
import ru.itis.inform.models.Customer;

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
            " VALUES (:gender, :lastName, :firstName, :middleName, :cardId, :phoneNumber, :birthDate) RETURNING customer.customer_id;";
    private static String SQL_DELETE = "DELETE FROM customer WHERE (customer_id = :customerId);";

    private static String SQL_UPDATE = "UPDATE customer SET (gender, last_name, first_name, middle_name, card_id, phone_number, birth_date) =" +
            "(:gender, :lastName, :firstName, :middleName, :cardId, :phoneNumber, :birthDate) WHERE (customer_id = :customerId);";

    private static String SQL_GET_BY_PHONE = "SELECT c.*, d.* FROM customer c INNER JOIN discount_card d ON c.card_id = d.card_id WHERE (c.phone_number = :phoneNumber);";

    private static String SQL_GET_BY_ID = "SELECT c.*, d.* FROM customer c INNER JOIN discount_card d ON c.card_id = d.card_id WHERE (c.customer_id = :customerId);";

    private static String SQL_GET_ALL = "SELECT c.*, d.* FROM customer c INNER JOIN discount_card d ON c.card_id = d.card_id;";

    private static String SQL_GET_BY_TOKEN = "SELECT c.*, d.* FROM customer c INNER JOIN discount_card d ON c.card_id = d.card_id WHERE (c.token = :token);";

    @Override
    public int saveCustomer(Customer customer) {
        Map<String, Object> params = new HashMap<>();
        params.put("gender", customer.getGender());
        params.put("lastName", customer.getLastName());
        params.put("firstName", customer.getFirstName());
        params.put("middleName", customer.getMiddleName());
        params.put("cardId", customer.getDiscountCard().getId());
        params.put("phoneNumber", customer.getPhone());
        params.put("birthDate", customer.getBirthDate());
        return namedParameterJdbcTemplate.queryForObject(SQL_SAVE, params, int.class);
    }

    @Override
    public void deleteCustomer(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }

    @Override
    public void updateCustomer(Customer customer, int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", id);
        params.put("gender", customer.getGender());
        params.put("lastName", customer.getLastName());
        params.put("firstName", customer.getFirstName());
        params.put("middleName", customer.getMiddleName());
        params.put("cardId", customer.getDiscountCard().getId());
        params.put("phoneNumber", customer.getPhone());
        params.put("birthDate", customer.getBirthDate());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
    }

    @Override
    public Customer getCustomerByPhone(String phoneNumber) {
        Map<String, Object> params = new HashMap<>();
        params.put("phoneNumber", phoneNumber);
        return (Customer) namedParameterJdbcTemplate.queryForObject(SQL_GET_BY_PHONE, params, new CustomerMapper());
    }

    @Override
    public Customer getCustomerById(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", id);
        return (Customer) namedParameterJdbcTemplate.queryForObject(SQL_GET_BY_ID, params, new CustomerMapper());
    }

    @Override
    public List<Customer> getAllCustomers() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL, new CustomerMapper());
    }

    @Override
    public Customer getCustomerByToken(String token) {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        return (Customer) namedParameterJdbcTemplate.queryForObject(SQL_GET_BY_TOKEN, params, new CustomerMapper());
    }
}
