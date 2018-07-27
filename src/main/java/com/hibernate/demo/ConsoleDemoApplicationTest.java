package com.hibernate.demo;

import com.hibernate.demo.models.Employee;
import com.hibernate.demo.models.Town;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class ConsoleDemoApplicationTest {

    private Thread t;

    public static void main(String[] args){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Town.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        Town newTown = new Town("Targovishte");

        session.beginTransaction();

        List<Employee> all = session.createQuery("from Employee").list();

        session.getTransaction().commit();

        session.close();
        System.out.println(all);
    }
}
