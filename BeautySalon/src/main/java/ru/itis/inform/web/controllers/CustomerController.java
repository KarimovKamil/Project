package ru.itis.inform.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.models.Employee;
import ru.itis.inform.services.interfaces.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil Karimov on 06.12.2016.
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/employee/all", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllEmployees() {
        ModelAndView modelAndView = new ModelAndView("employees");
        Map<String, List<Employee>> params = new HashMap<>();
        params.put("employees", customerService.getAllEmployees());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getEmployee(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("employee");
        Map<String, Employee> params = new HashMap<>();
        params.put("employee", customerService.getEmployeeInfo(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

}
