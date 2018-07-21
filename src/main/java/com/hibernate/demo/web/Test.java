package com.hibernate.demo.web;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
    private SessionFactory factory;

    @Autowired
    public Test(SessionFactory factory){
        this.factory = factory;
    }

    @GetMapping
    public String test(){
        return "Thank you very much!";
    }
}
