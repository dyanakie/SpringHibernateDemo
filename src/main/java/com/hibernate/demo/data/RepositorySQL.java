package com.hibernate.demo.data;

import com.hibernate.demo.models.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository
public class RepositorySQL implements Repository{

    private SessionFactory factory;

    @Autowired
    public RepositorySQL(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Employee getByID(int id) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }
}
