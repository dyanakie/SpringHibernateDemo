package com.hibernate.demo.web;

import com.hibernate.demo.models.Employee2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class EmployeeTest {

    @GetMapping("/employee")
    public String greetingForm(Model model) {
        Employee2 newEmployee = new Employee2();

        model.addAttribute("employee", newEmployee);
        return "index";
    }

    @PostMapping("/employee")
    public String employeeSubmit(@ModelAttribute Employee2 employee) {
        return "employee";
    }

}
