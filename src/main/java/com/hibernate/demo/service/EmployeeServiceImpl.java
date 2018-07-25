package com.hibernate.demo.service;

import com.hibernate.demo.data.Repository;
import com.hibernate.demo.data.RepositorySQL;
import com.hibernate.demo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Repository repository;

    @Autowired
    public EmployeeServiceImpl(Repository repository){
        this.repository = repository;
    }

    @Override
    public Employee getById(int id) {

        return repository.getByID(id);
    }

    @Override
    public void addEmployee(Employee employee) {
         repository.addEmployee(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Employee> getWithSalaryOver(int salary) {
        return null;
    }
}
