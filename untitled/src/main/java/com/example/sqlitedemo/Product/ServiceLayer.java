package com.example.sqlitedemo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class ServiceLayer {
    public ServiceLayer() {
        System.out.println("Service Layer object initialised");
    }

    @Autowired
    private Person p ;
//    = new Person();



    public Person get(){
        return p;
    }


    public void set( int pi){
//        p.name = "Rashif";
//        p.age = pi;
        p.setAge(pi);
        p.setName("Rashif");
    }

    public void setName(String name) {
         p.name = name;
    }
}
