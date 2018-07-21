package com.hibernate.demo.service;

import com.hibernate.demo.models.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getById(int id);

    public List<Employee> getAll();
}
