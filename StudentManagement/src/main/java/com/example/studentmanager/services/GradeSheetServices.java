package com.example.studentmanager.services;

import com.example.studentmanager.Model.Student;
import com.example.studentmanager.Repository.datajpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@Service
public class GradeSheetServices {
    @Autowired
    StudentRepo repo;

    public String printGrade(int id){
         Student s = repo.findById(id).orElse(null);
         if(s==null)
             return "Id not found";
         try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Grade.txt",true))){
             oos.writeObject(s);
             return "Grade printed in Grade.txt";
         } catch (IOException e) {
             System.out.println(e);
         }

         return "IO Exception caught";

    }
}
