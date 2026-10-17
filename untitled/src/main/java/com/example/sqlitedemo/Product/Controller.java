package com.example.sqlitedemo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    ServiceLayer s;
    @PutMapping("/product/{i}")
    public void set( @PathVariable int i){
        s.set(i);
    }

    @PostMapping("/product")
    public boolean setPerson(@RequestBody Person p){
        s.set(p.age);
        s.setName(p.name);
        return true;
    }

    @DeleteMapping("/product")
    public boolean del(){
        s.set(-1);
        s.setName(null);
        return true;
    }
    @GetMapping("/product/get")
    public Person get(){
        return s.get();
    }

    @GetMapping("/product/uwais")
    public String name(){
        return "Uwais";
    }

}
