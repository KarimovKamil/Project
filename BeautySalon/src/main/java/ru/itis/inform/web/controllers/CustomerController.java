package ru.itis.inform.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.models.Customer;
import ru.itis.inform.models.Employee;
import ru.itis.inform.models.Svc;
import ru.itis.inform.services.interfaces.CustomerService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/profile/update", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView updateProfileGet(@CookieValue("Auth-Token") String token) {
        ModelAndView modelAndView = new ModelAndView("profile_update");
        Map<String, Object> params = new HashMap<>();
        Customer customer = customerService.getPersonalInfo(token);
        params.put("customer", customer);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/profile/delete", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deleteCustomer(@CookieValue("Auth-Token") String token) {
        customerService.deleteCustomer(token);
        return new ModelAndView("redirect:/register");
    }

    @RequestMapping(value = "/profile/update", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView updateProfilePost(@CookieValue("Auth-Token") String token,
                                          @RequestParam("firstName") String firstName,
                                          @RequestParam("lastName") String lastName,
                                          @RequestParam("middleName") String middleName,
                                          @RequestParam("gender") String gender,
                                          @RequestParam("phone") String phone,
                                          @RequestParam("birthDate") Date birthDate,
                                          @RequestParam("hashPassword") String password) {
        Customer customer = new Customer.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .middleName(middleName)
                .gender(gender)
                .phone(phone)
                .birthDate(birthDate)
                .hashPassword(password)
                .build();
        customerService.updatePersonalInfo(token, customer);
        return new ModelAndView("redirect:/profile");
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

    @RequestMapping(value = "/exit", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView exit(HttpServletRequest req,
                             HttpServletResponse resp,
                             @CookieValue("Auth-Token") String token) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        return new ModelAndView("redirect:/login");
    }

//    @RequestMapping(value = "/employee/}/record/add", method = RequestMethod.POST)
//    @ResponseBody
//    public ModelAndView addRecord(@CookieValue("Auth-Token") String token,
//                                  ) {
//        ModelAndView modelAndView = new ModelAndView("services");
//        Map<String, List<Svc>> params = new HashMap<>();
//        params.put("services", customerService.recording(token, ));
//        modelAndView.addAllObjects(params);
//        return modelAndView;
//    }
}
