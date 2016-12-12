package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.RecordDao;
import ru.itis.inform.dao.mappers.RecordMapper;
import ru.itis.inform.models.Record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manymuch on 19.10.2016.
 */
@Repository
public class RecordDaoImpl implements RecordDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String SQL_ADD_RECORD = "INSERT INTO record (customer_id, employee_id, service_id, start_time, end_time) " +
            "VALUES (:customerId, :employeeId, :serviceId, :startTime, :endTime);";

    private static String SQL_DELETE = "DELETE FROM record WHERE (record_id = :recordId);";

    private static String SQL_UPDATE = "UPDATE record SET (customer_id, employee_id, service_id, start_time, end_time) " +
            "= (:customerId, :employeeId, :serviceId, :startTime, :endTime) WHERE (record_id = :recordId);";

    private static String SQL_GET_BY_ID = "SELECT * FROM record WHERE (record_id = :recordId);";

    private static String SQL_GET_ALL = "SELECT * FROM record;";

    private static String SQL_GET_RECORDS_BY_CUSTOMER_ID = "SELECT * FROM record WHERE (customer_id = :customerId);";

    private static String SQL_GET_RECORDS_BY_CUSTOMER_PHONE = "SELECT * FROM record AS r INNER JOIN customer AS c " +
            "ON (r.customer_id = c.customer_id) WHERE (c.phone_number = :phoneNumber);";

    private static String SQL_GET_RECORDS_BY_EMPLOYEE_ID = "SELECT * FROM record WHERE (employee_id = :employeeId);";

    @Override
    public int addNewRecord(Record record) {
        return 0;
    }

    @Override
    public void deleteRecord(int id) {

    }

    @Override
    public Record updateRecord(Record record, int id) {
        return null;
    }

    @Override
    public Record getRecord(int id) {
        return null;
    }

    @Override
    public List<Record> getAllRecords() {
        return null;
    }

    @Override
    public List<Record> getCustomerRecordsById(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", id);
        return namedParameterJdbcTemplate.query(SQL_GET_RECORDS_BY_CUSTOMER_ID, params, new RecordMapper());
    }

    @Override
    public List<Record> getCustomerRecordsByPhone(String phone) {
        Map<String, Object> params = new HashMap<>();
        params.put("phoneNumber", phone);
        return namedParameterJdbcTemplate.query(SQL_GET_RECORDS_BY_CUSTOMER_PHONE, params, new RecordMapper());
    }

    @Override
    public List<Record> getEmployeeRecordsById(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("employeeId", id);
        return namedParameterJdbcTemplate.query(SQL_GET_RECORDS_BY_EMPLOYEE_ID, params, new RecordMapper());
    }
}
