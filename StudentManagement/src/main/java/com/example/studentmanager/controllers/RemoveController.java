package com.example.studentmanager.controllers;

import com.example.studentmanager.services.RemoveServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoveController {
    @Autowired
    RemoveServices s;
    
    @DeleteMapping("/management/{id}")
    public String removeStudentById(@PathVariable Integer id){
        if(id==null)
            return "Id is null can't remove";
        return s.removeStudentById(id);
    }
}
