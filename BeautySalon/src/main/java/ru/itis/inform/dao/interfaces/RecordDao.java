package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Record;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
public interface RecordDao {

    int addNewRecord(Record record);

    void deleteRecord(int id);

    Record updateRecord(Record record);

    Record getRecord(int id);

    List<Record> getAllRecords();

}
