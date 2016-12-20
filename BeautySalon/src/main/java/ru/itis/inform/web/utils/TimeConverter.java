package ru.itis.inform.web.utils;

import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
}
