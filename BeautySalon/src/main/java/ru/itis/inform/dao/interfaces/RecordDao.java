package ru.itis.inform.dao.interfaces;

import ru.itis.inform.dto.RecordDto;
import ru.itis.inform.models.Record;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
public interface RecordDao {

    void addNewRecord(RecordDto recordDto);

    void deleteRecord(int id);

    Record updateRecord(RecordDto recordDto, int id);

    Record getRecord(int id);

    List<Record> getAllRecords();

    List<Record> getCustomerRecordsById(int id);

    List<Record> getEmployeeRecordsById(int id);

    List<Record> getCustomerRecordsByPhone(String phone);
}
