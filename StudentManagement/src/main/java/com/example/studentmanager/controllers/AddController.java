package com.example.studentmanager.controllers;

import com.example.studentmanager.Model.Faculty;
import com.example.studentmanager.Model.Student;
import com.example.studentmanager.services.AddServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {
    @Autowired
    AddServices addServices;

    @PostMapping("/management/addstudent")
    public String add(@RequestBody Student s){
        return addServices.addStudent(s);
    }


}
