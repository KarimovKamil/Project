package ru.itis.inform.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.dto.RecordDto;
import ru.itis.inform.models.Customer;
import ru.itis.inform.models.Employee;
import ru.itis.inform.models.Record;
import ru.itis.inform.models.Svc;
import ru.itis.inform.services.interfaces.CustomerService;
import ru.itis.inform.web.utils.TimeConverter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Autowired
    TimeConverter timeConverter;

    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public ModelAndView mainRedirect() {
        return new ModelAndView("redirect:/profile");
    }

    @RequestMapping(value = "/employee/all", method = RequestMethod.GET)
    public ModelAndView getAllEmployees() {
        ModelAndView modelAndView = new ModelAndView("employees");
        Map<String, List<Employee>> params = new HashMap<>();
        params.put("employees", customerService.getAllEmployees());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ModelAndView getEmployee(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("employee");
        Map<String, Object> params = new HashMap<>();
        params.put("workTimes", customerService.getEmployeeWortTime(id));
        params.put("employee", customerService.getEmployeeInfo(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/employee/specialization/{id}", method = RequestMethod.GET)
    public ModelAndView getEmployeeBySpecialization(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("specialization");
        Map<String, List<Employee>> params = new HashMap<>();
        params.put("employees", customerService.getEmployeesBySpecialization(id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("registration");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletResponse response,
                                     @RequestParam("phone") String phone,
                                     @RequestParam("password") String password) {
        String token = customerService.registration(phone, password);
        Cookie cookie = new Cookie("Auth-Token", token);
        response.addCookie(cookie);
        return new ModelAndView("redirect:/profile");
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(@CookieValue("Auth-Token") String token) {
        ModelAndView modelAndView = new ModelAndView("profile");
        Map<String, Object> params = new HashMap<>();
        params.put("customer", customerService.getPersonalInfo(token));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/profile/update", method = RequestMethod.GET)
    public ModelAndView updateProfileGet(@CookieValue("Auth-Token") String token) {
        ModelAndView modelAndView = new ModelAndView("profileUpdate");
        Map<String, Object> params = new HashMap<>();
        Customer customer = customerService.getPersonalInfo(token);
        params.put("customer", customer);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/profile/delete", method = RequestMethod.POST)
    public ModelAndView deleteCustomer(@CookieValue("Auth-Token") String token) {
        customerService.deleteCustomer(token);
        return new ModelAndView("redirect:/register");
    }

    @RequestMapping(value = "/profile/update", method = RequestMethod.POST)
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
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletResponse response,
                              @RequestParam("phone") String phone,
                              @RequestParam("password") String password) {
        String token = customerService.login(phone, password);
        Cookie cookie = new Cookie("Auth-Token", token);
        response.addCookie(cookie);
        return new ModelAndView("redirect:/profile");
    }

    @RequestMapping(value = "/service/all", method = RequestMethod.GET)
    public ModelAndView getAllServices() {
        ModelAndView modelAndView = new ModelAndView("services");
        Map<String, List<Svc>> params = new HashMap<>();
        params.put("services", customerService.getAllServices());
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
    public ModelAndView getServiceById(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("service");
        Svc svc = customerService.getSvcById(id);
        Map<String, Object> params = new HashMap<>();
        params.put("service", svc);
        params.put("employees", customerService.getEmployeesBySpecialization(svc.getSpecialization().getId()));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/exit", method = RequestMethod.POST)
    public ModelAndView exit(HttpServletRequest req,
                             HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value = "/service/{service-id}/employee/{employee-id}/record", method = RequestMethod.POST)
    public ModelAndView addRecord(@CookieValue("Auth-Token") String token,
                                  @PathVariable("service-id") int serviceId,
                                  @PathVariable("employee-id") int employeeId,
                                  @RequestParam("startTime") String startTime,
                                  @RequestParam("weekday") int weekday) {
        RecordDto recordDto = new RecordDto.Builder()
                .employeeId(employeeId)
                .serviceId(serviceId)
                .weekday(weekday)
                .startTime(timeConverter.convert(startTime))
                .build();
        customerService.recording(token, recordDto);
        return new ModelAndView("redirect:/profile/records");
    }

    @RequestMapping(value = "/service/{service-id}/employee/{employee-id}/record", method = RequestMethod.GET)
    public ModelAndView addRecord(@PathVariable("employee-id") int employeeId) {
        ModelAndView modelAndView = new ModelAndView("addrecord");
        Map<String, Object> params = new HashMap<>();
        params.put("workTimes", customerService.getEmployeeWortTime(employeeId));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/profile/records", method = RequestMethod.GET)
    public ModelAndView getCustomerRecords(@CookieValue("Auth-Token") String token) {
        ModelAndView modelAndView = new ModelAndView("records");
        Map<String, Object> params = new HashMap<>();
        params.put("records", customerService.getCustomerRecord(token));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/profile/records/{record-id}", method = RequestMethod.GET)
    public ModelAndView getCustomerRecordById(@CookieValue("Auth-Token") String token,
                                              @PathVariable("record-id") int recordId) {
        ModelAndView modelAndView = new ModelAndView("record");
        Map<String, Object> params = new HashMap<>();
        params.put("record", customerService.getRecordById(token, recordId));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/profile/records/{id}/update", method = RequestMethod.POST)
    public ModelAndView updateRecord(@CookieValue("Auth-Token") String token,
                                     @PathVariable("id") int id,
                                     @RequestParam("startTime") String startTime,
                                     @RequestParam("weekday") int weekday) {
        RecordDto recordDto = new RecordDto.Builder()
                .startTime(timeConverter.convert(startTime))
                .weekday(weekday)
                .build();
        customerService.updateRecord(token, recordDto, id);
        return new ModelAndView("redirect:/profile/records");
    }

    @RequestMapping(value = "/profile/records/{id}/update", method = RequestMethod.GET)
    public ModelAndView updateRecord(@CookieValue("Auth-Token") String token,
                                     @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("recordUpdate");
        Map<String, Object> params = new HashMap<>();
        params.put("record", customerService.getRecordById(token, id));
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

    @RequestMapping(value = "/profile/records/{record-id}/delete", method = RequestMethod.POST)
    public ModelAndView deleteCustomerRecordById(@CookieValue("Auth-Token") String token,
                                                 @PathVariable("record-id") int recordId) {
        customerService.deleteRecording(token, recordId);
        return new ModelAndView("redirect:/profile/records");
    }
}
