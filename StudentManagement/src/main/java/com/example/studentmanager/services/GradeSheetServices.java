package com.example.studentmanager.services;

import com.example.studentmanager.Model.Student;
import com.example.studentmanager.Repository.datajpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class GradeSheetServices {
    @Autowired
    StudentRepo repo;

    public String printGrade(int id){
         Student s = repo.findById(id).orElse(null);
         if(s==null)
             return "Id not found";
//         try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Grade.txt",true))){
//             oos.writeObject(s);
//             return "Grade printed in Grade.txt";
//         } catch (IOException e) {
//             System.out.println(e);
//         }

        try(PrintWriter pw = new PrintWriter(new FileWriter("Grade.txt"))){
            pw.print(s.getId() + ",");
            pw.print(s.getJava() + ",");
            pw.print(s.getSoftware() );
            pw.print(s.getDs() + "\n");
        } catch (IOException e) {
            System.out.println(e);
            return "File IO Exception Caught : Cannot write in file";
        }

         return "IO Exception caught";

    }
}
