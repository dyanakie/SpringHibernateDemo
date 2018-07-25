package com.hibernate.demo.service;

import com.hibernate.demo.models.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getById(int id);

    public Employee getByName(String name);

    public void addEmployee(Employee employee);

    public List<Employee> getAll();

    public List<Employee> getWithSalaryOver(int salary);
}
