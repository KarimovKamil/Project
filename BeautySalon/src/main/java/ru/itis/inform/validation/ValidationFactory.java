package ru.itis.inform.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.exceptions.IncorrectDataException;

/**
 * Created by Kamil Karimov on 12.12.2016.
 */
@Component
public class ValidationFactory {

    @Autowired
    Validation validation;
    @Autowired
    DataValidation dataValidation;

    public void customerExistenceById(int customerId) {
        if (!validation.customerExistenceById(customerId)) {
            throw new IncorrectDataException("Incorrect customer");
        }
    }

    public void customerExistenceByPhone(String phone) {
        if (!validation.customerExistenceByPhone(phone)) {
            throw new IncorrectDataException("Incorrect phone");
        }
    }

    public void discountCardExistenceById(int cardId) {
        if (!validation.discountCardExistenceById(cardId)) {
            throw new IncorrectDataException("Incorrect card");
        }
    }

    public void employeeExistenceById(int employeeId) {
        if (!validation.employeeExistenceById(employeeId)) {
            throw new IncorrectDataException("Incorrect employee");
        }
    }

    public void recordExistenceById(int recordId) {
        if (!validation.recordExistenceById(recordId)) {
            throw new IncorrectDataException("Incorrect record");
        }
    }

    public void serviceExistenceById(int serviceId) {
        if (!validation.serviceExistenceById(serviceId)) {
            throw new IncorrectDataException("Incorrect service");
        }
    }

    public void serviceExistenceByName(int name) {
        if (!validation.serviceExistenceByName(name)) {
            throw new IncorrectDataException("Incorrect service type");
        }
    }

    public void specializationExistenceById(int specializationId) {
        if (!validation.specializationExistenceById(specializationId)) {
            throw new IncorrectDataException("Incorrect specialization");
        }
    }

    public void customerExistenceByToken(String token) {
        if (!validation.customerExistenceByToken(token)) {
            throw new IncorrectDataException("Incorrect token");
        }
    }

    public void customerRecordExistence(int customerId, int recordId) {
        if (!validation.customerRecordExistence(customerId, recordId)) {
            throw new IncorrectDataException("Incorrect record");
        }
    }

    public void employeeServiceMatch(int employeeId, int serviceId) {
        if (!validation.employeeServiceMatch(employeeId, serviceId)) {
            throw new IncorrectDataException("Incorrect employee or service");
        }
    }

    public void customerPhoneUnique(String phone) {
        if (validation.customerExistenceByPhone(phone)) {
            throw new IncorrectDataException("Phone number is exists");
        }
    }

    public void verifyPhone(String phone) {
        if (!dataValidation.verifyPhone(phone)) {
            throw new IncorrectDataException("Incorrect phone");
        }
    }

    public void verifyPassword(String password) {
        if (!dataValidation.verifyPassword(password)) {
            throw new IncorrectDataException("Incorrect password");
        }
    }
}
