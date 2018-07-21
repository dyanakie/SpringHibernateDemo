package com.hibernate.demo.data;

import com.hibernate.demo.models.Employee;

import java.util.List;

public interface Repository {

    public Employee getByID(int id);

    public List<Employee> getAll();
}
