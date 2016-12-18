package ru.itis.inform.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.models.Employee;
import ru.itis.inform.models.Svc;
import ru.itis.inform.services.interfaces.CustomerService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
        Map<String, Object> params = new HashMap<>();
        params.put("workTimes", customerService.getEmployeeWortTime(id));
        params.put("employee", customerService.getEmployeeInfo(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/employee/specialization/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getEmployeeBySpecialization(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("specialization");
        Map<String, List<Employee>> params = new HashMap<>();
        params.put("employees", customerService.getEmployeesBySpecialization(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView registration() {
        return new ModelAndView("registration");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView registration(HttpServletResponse response,
                                     @RequestParam("phone") String phone,
                                     @RequestParam("password") String password) {
        String token = customerService.registration(phone, password);
        Cookie cookie = new Cookie("Auth-Token", token);
        response.addCookie(cookie);
        return new ModelAndView("redirect:/profile");
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView profile(@CookieValue("Auth-Token") String token) {
        ModelAndView modelAndView = new ModelAndView("profile");
        Map<String, Object> params = new HashMap<>();
        params.put("customer", customerService.getPersonalInfo(token));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(HttpServletResponse response,
                              @RequestParam("phone") String phone,
                              @RequestParam("password") String password) {
        String token = customerService.login(phone, password);
        Cookie cookie = new Cookie("Auth-Token", token);
        response.addCookie(cookie);
        return new ModelAndView("redirect:/profile");
    }

    @RequestMapping(value = "/service/all", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllServices() {
        ModelAndView modelAndView = new ModelAndView("services");
        Map<String, List<Svc>> params = new HashMap<>();
        params.put("services", customerService.getAllServices());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }
}
