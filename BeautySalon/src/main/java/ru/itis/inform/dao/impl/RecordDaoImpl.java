package ru.itis.inform.dao.impl;

import ru.itis.inform.dao.interfaces.RecordDao;
import ru.itis.inform.models.Record;

import java.util.List;

/**
 * Created by Manymuch on 19.10.2016.
 */
public class RecordDaoImpl implements RecordDao {

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
