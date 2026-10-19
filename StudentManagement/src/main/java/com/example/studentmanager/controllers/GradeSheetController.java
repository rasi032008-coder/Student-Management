package com.example.studentmanager.controllers;

import com.example.studentmanager.services.GradeSheetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeSheetController {
    @Autowired
    GradeSheetServices s;
    @GetMapping("/management/grade/{id}")
    public String printGrade(@PathVariable Integer id){
        if(id==null)
            return "Null Id Caught";
        return s.printGrade(id);
    }
}
