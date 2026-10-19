package com.example.studentmanager.services;

import com.example.studentmanager.Model.Faculty;
import com.example.studentmanager.Model.Student;
import com.example.studentmanager.Repository.datajpa.FacultyRepo;
import com.example.studentmanager.Repository.datajpa.StudentRepo;
import com.example.studentmanager.exceptions.UpdateFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddServices {
    @Autowired
    StudentRepo repo;
    @Autowired
    FacultyRepo repo2;

    public String addStudent(Student s){
        try {
            if(s==null)
                throw new UpdateFailedException("Update failed : student is null");
            if(s.getId()<0 || s.getName()==null){
                throw new UpdateFailedException("Update failed : student name or id is null");
            }
            setPassword(s);
            repo.save(s);
            return "Student added successfully";
        } catch (UpdateFailedException e) {
            System.out.println(e);
            return "Update failed Exception";
        }
    }


    private void setPassword(Student s){
        String p = s.getName() + "@au123";
        s.setPassword(p);
    }
}
