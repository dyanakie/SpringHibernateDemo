package com.hibernate.demo.service;


import com.hibernate.demo.models.Address;
import com.hibernate.demo.models.Employee;
import com.hibernate.demo.models.Town;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactorySession {

    @Bean
    public SessionFactory createSessionFactory(){
        System.out.println("Session Factory created.");

        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Town.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
    }
}
