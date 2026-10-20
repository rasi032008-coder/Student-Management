package com.example.studentmanager.services;

import com.example.studentmanager.Model.Student;
import com.example.studentmanager.Repository.signin.FacultySignInValidator;
import com.example.studentmanager.Repository.signin.ManagementSignInValidator;
import com.example.studentmanager.Repository.signin.StudentSignInValidator;
import com.example.studentmanager.Repository.datajpa.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ServiceLayer {
    int code = (int)Math.random()*1000;

    @Autowired
    StudentRepo repo;
    public ServiceLayer() {
        System.out.println("Service Layer object initialised");
    }

    public String signIn(int id,String password){

        return StudentSignInValidator.validate(id,password)
                + "\n" +
                "Your code is " + code;
    }
    //str denotes type of faculty signing in i.e. Java faculty, DS faculty or Software faculty
    public String signIn(String id,String password,String str){
        return FacultySignInValidator.validate(id,password,str)
                + "\n" +
                "Your code is " + code;
    }

    public String signIn(String password){

        return ManagementSignInValidator.validate(password) + "\n" +
                "Your code is " + code;
    }

    public Map<Integer,String> getStudents(int accessCode){
        if(accessCode==code||true) {
            System.out.println("Firs hi");
            if(repo==null) System.out.println("Repo is null");
            List<Student> l =  repo.findAll();
            System.out.println("Hi");
            if(l==null)return null;
            return l.stream().collect(Collectors.toMap(a->a.getId(),a->a.getName()));

        } else {
            HashMap<Integer,String >h = new HashMap<>();
            h.put(403,"Access Denied");
            return h;
        }
    }

}
