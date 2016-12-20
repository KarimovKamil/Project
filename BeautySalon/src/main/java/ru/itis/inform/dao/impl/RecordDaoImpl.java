package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.RecordDao;
import ru.itis.inform.dao.mappers.RecordMapper;
import ru.itis.inform.dto.RecordDto;
import ru.itis.inform.models.Record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manymuch on 19.10.2016.
 */
@Repository
public class RecordDaoImpl implements RecordDao {

    private static String SQL_INNER_JOIN =
            "SELECT * FROM record r " +
                    "INNER JOIN customer c ON r.customer_id = c.customer_id " +
                    "INNER JOIN employee e ON r.employee_id = e.employee_id " +
                    "INNER JOIN service se ON se.service_id = r.service_id " +
                    "INNER JOIN discount_card d ON d.card_id = c.card_id " +
                    "INNER JOIN specialization sp ON sp.specialization_id = e.specialization_id";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String SQL_ADD_RECORD = "INSERT INTO record (customer_id, employee_id, service_id, start_time, end_time, weekday) " +
            "VALUES (:customerId, :employeeId, :serviceId, :startTime, :endTime, :weekday);";

    private static String SQL_DELETE = "DELETE FROM record WHERE (record_id = :recordId);";

    private static String SQL_UPDATE = "UPDATE record SET (start_time, end_time, weekday) " +
            "= (:startTime, :endTime, :weekday) WHERE (record_id = :recordId);";

    private static String SQL_GET_BY_ID = SQL_INNER_JOIN + " WHERE (r.record_id = :recordId);";

    private static String SQL_GET_ALL = SQL_INNER_JOIN + ";";

    private static String SQL_GET_RECORDS_BY_CUSTOMER_ID = SQL_INNER_JOIN + " WHERE (c.customer_id = :customerId);";

    private static String SQL_GET_RECORDS_BY_CUSTOMER_PHONE = SQL_INNER_JOIN + " WHERE (c.phone_number = :phoneNumber);";

    private static String SQL_GET_RECORDS_BY_EMPLOYEE_AND_WEEKDAY = SQL_INNER_JOIN + " WHERE (e.employee_id = :employeeId)" +
            " AND (r.weekday = :weekday) AND (r.record_id <> :recordId);";

    @Override
    public void addNewRecord(RecordDto recordDto) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", recordDto.getCustomerId());
        params.put("employeeId", recordDto.getEmployeeId());
        params.put("serviceId", recordDto.getServiceId());
        params.put("startTime", recordDto.getStartTime());
        params.put("endTime", recordDto.getEndTime());
        params.put("weekday", recordDto.getWeekday());
        namedParameterJdbcTemplate.update(SQL_ADD_RECORD, params);
    }

    @Override
    public void deleteRecord(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("recordId", id);
        namedParameterJdbcTemplate.update(SQL_DELETE, params);
    }

    @Override
    public Record updateRecord(RecordDto recordDto, int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("recordId", id);
        params.put("startTime", recordDto.getStartTime());
        params.put("endTime", recordDto.getEndTime());
        params.put("weekday", recordDto.getWeekday());
        namedParameterJdbcTemplate.update(SQL_UPDATE, params);
        return (Record) namedParameterJdbcTemplate.queryForObject(SQL_GET_BY_ID, params, new RecordMapper());
    }

    @Override
    public Record getRecord(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("recordId", id);
        return (Record) namedParameterJdbcTemplate.queryForObject(SQL_GET_BY_ID, params, new RecordMapper());
    }

    @Override
    public List<Record> getAllRecords() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL, new RecordMapper());
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
    public List<Record> getEmployeeRecordsByIdAndWeekday(int employeeId, int weekday, int recordId) {
        Map<String, Object> params = new HashMap<>();
        params.put("employeeId", employeeId);
        params.put("weekday", weekday);
        params.put("recordId", recordId);
        return namedParameterJdbcTemplate.query(SQL_GET_RECORDS_BY_EMPLOYEE_AND_WEEKDAY, params, new RecordMapper());
    }
}
