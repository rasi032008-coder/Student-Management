package com.example.studentmanager.services;

import com.example.studentmanager.Model.Student;
import com.example.studentmanager.Repository.datajpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveServices {
    @Autowired
    StudentRepo repo;

    public String removeStudentById(int id){
        Student s = repo.findById(id).orElse(null);
        if(s==null)
            return "Student not found";
        repo.deleteById(id);
        return "Student removed successfully";
    }
}
