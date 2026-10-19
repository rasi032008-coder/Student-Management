package com.example.studentmanager.controllers;
import com.example.studentmanager.Model.Faculty;
import com.example.studentmanager.Model.Student;
import com.example.studentmanager.services.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HomeController {

    @Autowired
    ServiceLayer serviceLayer ;
    @GetMapping("/student/")
    public String signin(@RequestBody Student s){
        System.out.println("Sign in function called");
        if(s.getPassword()==null)return "Password is null";
        return serviceLayer.signIn(s.getId(),s.getPassword());
    }

    @GetMapping("/faculty/{str}")
    public String signin(@RequestBody Faculty f, @PathVariable String str){
        System.out.println("Sign in function called");

        return serviceLayer.signIn(f.getId(),f.getPassword(),str);
    }

    @GetMapping("/management/")
    public String signin(@RequestBody String password){
        System.out.println("Sign in management called");
        return serviceLayer.signIn(password);
    }

    @GetMapping("/faculty/getstudents/{accessCode}")
    public Map<Integer,String> getStudents(@PathVariable int accessCode){

        return serviceLayer.getStudents(accessCode);
    }


}
