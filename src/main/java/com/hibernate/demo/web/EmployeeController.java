package com.hibernate.demo.web;

import com.hibernate.demo.models.Employee;
import com.hibernate.demo.models.Employee2;
import com.hibernate.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @GetMapping("/employee")
    public String greetingForm(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee";
    }

    @PostMapping("/employee")
    public String employeeSubmit(@ModelAttribute Employee employee, Model model) {
        employee = service.getById(employee.getId());
        model.addAttribute("employee", employee);
        return "employeeResult";
    }

    @GetMapping("/salary")
    public String salaryForm(Model model){

        Employee employee = new Employee();
        model.addAttribute("salary", employee);

        return "salary";
    }

    @PostMapping("/salarySearch")
    public String salarySubmit(@ModelAttribute Employee employee, Model model) {

        List<Employee> list = service.getWithSalaryOver(employee.getSalary());

        employee = service.getById(employee.getId());
        model.addAttribute("employee", employee);
        return "salaryResult";
    }

}
