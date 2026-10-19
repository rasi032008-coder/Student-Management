package com.example.studentmanager.services;

import com.example.studentmanager.Model.Student;
import com.example.studentmanager.Repository.datajpa.StudentRepo;
import com.example.studentmanager.exceptions.MarkUpdateFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetServices {
    @Autowired
    StudentRepo repo;

    public  String setStudentMarks(Student s,String courseName){
        try {

            if(s==null )
                throw new MarkUpdateFailureException("Failed to update : Name is null");
            if(s.getId()<=0)
                throw new MarkUpdateFailureException("Failed to update : Id is negative or zero");

            Student temp = repo.findById(s.getId()).orElse(null);
            if(temp==null){
                throw new MarkUpdateFailureException("Failed to update : Student not found");
            }
            setDetails(s,temp,courseName);
            repo.save(s);
            return "Successfully saved the marks";
        } catch (Exception e) {
            System.out.println(e);
            return e.getMessage();
        }
    }

    private void setDetails(Student s,Student temp,String courseName)throws MarkUpdateFailureException{
        s.setPassword(temp.getPassword());
        if(courseName.equalsIgnoreCase("java")){
            s.setDs(temp.getDs());
            s.setSoftware(temp.getSoftware());
        }
        else if(courseName.equalsIgnoreCase("ds")){
            s.setSoftware(temp.getSoftware());
            s.setJava(temp.getJava());
        }
        else if(courseName.equalsIgnoreCase("software")){
            s.setJava(temp.getJava());
            s.setDs(temp.getDs());
        }
        else{
            throw new MarkUpdateFailureException("Failed to update : Unknown Course Name");
        }
    }
}
