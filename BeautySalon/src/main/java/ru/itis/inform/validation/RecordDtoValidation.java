package ru.itis.inform.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.interfaces.EmployeeDao;
import ru.itis.inform.dao.interfaces.RecordDao;
import ru.itis.inform.dto.RecordDto;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.models.Record;
import ru.itis.inform.models.WorkTime;

import java.util.List;

/**
 * Created by artur on 19.12.2016.
 */
@Component
public class RecordDtoValidation {

    //TODO v verification factory

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    RecordDao recordDao;

    public void verifyRecordDto(RecordDto recordDto, int id) {
        List<WorkTime> workTimeList = employeeDao.getEmployeeWorkTime(recordDto.getEmployeeId());
        boolean flag = false;
        WorkTime empWorkTime = null;
        for (WorkTime workTime : workTimeList) {
            if (workTime.getWeekday() == recordDto.getWeekday()) {
                flag = true;
                empWorkTime = workTime;
            }
        }
        if (!flag) {
            throw new IncorrectDataException("Incorrect weekday");
        }

        if (empWorkTime.getStartTime().getTime() > recordDto.getStartTime().getTime() ||
                empWorkTime.getEndTime().getTime() < recordDto.getEndTime().getTime() ||
                recordDto.getStartTime().getTime() > recordDto.getEndTime().getTime()) {
            throw new IncorrectDataException("Incorrect time");
        }

        List<Record> recordList = recordDao.getEmployeeRecordsByIdAndWeekday(recordDto.getEmployeeId(),
                recordDto.getWeekday(), id);
        for (Record record : recordList) {
            if (!((record.getStartTime().getTime() > recordDto.getStartTime().getTime() &&
                    record.getStartTime().getTime() > recordDto.getEndTime().getTime()) ||
                    (record.getEndTime().getTime() < recordDto.getStartTime().getTime() &&
                    record.getEndTime().getTime() < recordDto.getEndTime().getTime()))) {
                //TODO zanyato
                throw new IncorrectDataException("zanyato");
            }
        }

    }
}
