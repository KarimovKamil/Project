package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.RecordDao;
import ru.itis.inform.models.Record;

import java.util.List;

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

    @Override
    public int addNewRecord(Record record) {
        return 0;
    }

    @Override
    public void deleteRecord(int id) {

    }

    @Override
    public Record updateRecord(Record record) {
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
}
