package com.hibernate.demo.web;

import com.hibernate.demo.models.Employee;
import com.hibernate.demo.service.EmployeeService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeControllerDirectID {

    private EmployeeService service;

    @Autowired
    public EmployeeControllerDirectID(EmployeeService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") String id){
        return service.getById(Integer.parseInt(id));
    }






}
