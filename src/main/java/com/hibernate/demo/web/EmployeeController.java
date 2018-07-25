package com.hibernate.demo.web;

import com.hibernate.demo.models.Employee;
import com.hibernate.demo.models.Salary;
import com.hibernate.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @GetMapping("/employeeSearchId")
    public ModelAndView employeeSearchId() {

        ModelAndView modelAndView = new ModelAndView("employeeSearchId");

        Employee employee = new Employee();
        modelAndView.addObject("employee", employee);

        return modelAndView;
    }

    @PostMapping("/employeeSearchId")
    public ModelAndView employeeSubmit(Employee employee) {

        ModelAndView modelAndView = new ModelAndView("employeeSearchIdR");

        employee = service.getById(employee.getId());
        modelAndView.addObject("employee", employee);

        return modelAndView;
    }

    @GetMapping("/salary")
    public String createSalaryView(){

        ModelAndView modelAndView = new ModelAndView("salary");
        modelAndView.addObject("salary", new Salary());

        return "salary";
    }


    @GetMapping("/showAll")
    public ModelAndView showAll(){

        ModelAndView modelAndView = new ModelAndView("showAll");

        modelAndView.addObject("allEmployees", service.getAll());


        return modelAndView;

    }

    @GetMapping("/createEmployee")
    public ModelAndView createEmployeeView(){
         ModelAndView modelAndView = new ModelAndView("createEmployee");
         modelAndView.addObject("employee", new Employee());

         return modelAndView;

    }

    @PostMapping("/createEmployee")
    public ModelAndView createEmployee(Employee employee){

        ModelAndView modelAndView = new ModelAndView("createEmployeeR");

        service.addEmployee(employee);

        return modelAndView;

    }


}
