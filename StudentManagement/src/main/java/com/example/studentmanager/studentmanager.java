package com.example.studentmanager
;

//import com.example.sqlitedemo.Product.sqlitedemo.Product.ServiceLayer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class studentmanager {
    public static void main(String[] args) {
        ApplicationContext container = SpringApplication.run(studentmanager.class, args);

    }
}
