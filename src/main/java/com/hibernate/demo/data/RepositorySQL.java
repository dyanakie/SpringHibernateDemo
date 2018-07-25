package com.hibernate.demo.data;

import com.hibernate.demo.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class RepositorySQL implements Repository{

    private SessionFactory factory;

    @Autowired
    public RepositorySQL(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Employee getByID(int id) {

        Employee employee = null;

        try(Session session = factory.openSession()){
            session.beginTransaction();

            employee = session.get(Employee.class, id);
            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return employee;
    }


    @Override
    public List<Employee> getAll() {
        List<Employee> theList = new ArrayList<>();

        try(Session session = factory.openSession()){
            session.beginTransaction();

            theList = session.createQuery("from Employee order by firstName").list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return theList;
    }

    @Override
    public List<Employee> getWithSalaryOver(int salary) {
        List<Employee> theList = new ArrayList<>();

        try(Session session = factory.openSession()){
            session.beginTransaction();

            theList = session.createQuery("from Employee as e where e.salary >= :salary order by salary").setParameter("salary", salary).list();

            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return theList;
    }

    @Override
    public void addEmployee(Employee employee) {


        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            System.out.println(employee.getFirstName() + employee.getLastName() + " created Successfully");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
