package ru.itis.inform.web.utils;

import org.springframework.stereotype.Component;
import ru.itis.inform.dao.impl.RecordDaoImpl;
import ru.itis.inform.dao.interfaces.RecordDao;
import ru.itis.inform.models.Record;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by artur on 19.12.2016.
 */
@Component
public class TimeConverter {

    public Time convert(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long ms = 0;
        try {
            ms = sdf.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Time(ms);
    }

    public static void main(String[] args) {
        RecordDao recordDao = new RecordDaoImpl();
        List<Record> list = recordDao.getEmployeeRecordsByIdAndWeekday(2, 2);
        for (Record record :
                list) {
            System.out.println(record.getWeekday() + " " + record.getEmployee().getId());
        }
    }
}
