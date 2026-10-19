package com.example.studentmanager.controllers;

import com.example.studentmanager.Model.Student;
import com.example.studentmanager.services.SetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetController {
    @Autowired
    SetServices setServices;
    @PutMapping("/faculty/{courseName}")
    public String setStudentMarks(@RequestBody Student s,@PathVariable String courseName){
        return setServices.setStudentMarks(s,courseName);
    }
}
