package ru.itis.inform.web.conf;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.itis.inform.exceptions.IncorrectDataException;
import ru.itis.inform.web.controllers.CustomerController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kamil Karimov on 18.11.2016.
 */
@ControllerAdvice(assignableTypes = {
        CustomerController.class,
})
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IncorrectDataException.class)
    public ModelAndView incorrectData(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        Map<String, String> params = new HashMap<>();
        params.put("message", e.getMessage());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }
}
