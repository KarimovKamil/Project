package ru.itis.inform.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by The silly end on 12/12/2016.
 */
@Component
public class Validation {

    private static final String CUSTOMER_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT customer_id FROM customer WHERE customer_id = ?) " +
            "THEN TRUE ELSE FALSE END;";

    private static final String CUSTOMER_BY_PHONE =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT customer_id FROM customer WHERE phone_number = ?) " +
            "THEN TRUE ELSE FALSE END;";

    private static final String DISCOUNT_CARD_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT card_id FROM discount_card WHERE card_id = ?) " +
            "THEN TRUE ELSE FALSE END;";

    private static final String EMPLOYEE_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT employee_id FROM employee WHERE employee_id = ?) " +
            "THEN TRUE ELSE FALSE END;";

    private static final String RECORD_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT record_id FROM record WHERE record_id = ?) " +
            "THEN TRUE ELSE FALSE END;";

    private static final String SERVICE_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT service_id FROM service WHERE service_id = ?) " +
            "THEN TRUE ELSE FALSE END;";

    private static final String SERVICE_BY_NAME =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT service_id FROM service WHERE type = ?) " +
            "THEN TRUE ELSE FALSE END;";

    private static final String SPECIALIZATION_BY_ID =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT specialization_id FROM specialization WHERE specialization_id = ?) " +
            "THEN TRUE ELSE FALSE END;";

    private static final String CUSTOMER_BY_TOKEN =
            "SELECT CASE WHEN EXISTS " +
                    "(SELECT customer_id FROM customer WHERE token = ?) " +
            "THEN TRUE ELSE FALSE END;";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean customerExistenceById(int customerId) {
        return jdbcTemplate.queryForObject(CUSTOMER_BY_ID, Boolean.class, customerId);
    }

    public boolean customerExistenceByPhone(String phone) {
        return jdbcTemplate.queryForObject(CUSTOMER_BY_PHONE, Boolean.class, phone);
    }

    public boolean discountCardExistenceById(int cardId) {
        return jdbcTemplate.queryForObject(DISCOUNT_CARD_BY_ID, Boolean.class, cardId);
    }

    public boolean employeeExistenceById(int employeeId) {
        return jdbcTemplate.queryForObject(EMPLOYEE_BY_ID, Boolean.class, employeeId);
    }

    public boolean recordExistenceById(int recordId) {
        return jdbcTemplate.queryForObject(RECORD_BY_ID, Boolean.class, recordId);
    }

    public boolean serviceExistenceById(int serviceId) {
        return jdbcTemplate.queryForObject(SERVICE_BY_ID, Boolean.class, serviceId);
    }

    public boolean serviceExistenceByName(int name) {
        return jdbcTemplate.queryForObject(SERVICE_BY_NAME, Boolean.class, name);
    }

    public boolean specializationExistenceById(int specializationId) {
        return jdbcTemplate.queryForObject(SPECIALIZATION_BY_ID, Boolean.class, specializationId);
    }

    public boolean customerExistenceByToken(String token) {
        return jdbcTemplate.queryForObject(CUSTOMER_BY_TOKEN, Boolean.class, token);
    }
}
