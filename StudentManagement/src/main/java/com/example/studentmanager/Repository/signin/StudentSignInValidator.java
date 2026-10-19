package com.example.studentmanager.Repository.signin;

import com.example.studentmanager.Repository.dbmanager.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentSignInValidator {
    static String greet = "Welcome ";
    static DBManager dbManager ;
    static {
        dbManager = new DBManager();

    }

    public static String validate(int id,String password){
        String sql = "SELECT name FROM student " +
                " WHERE id = ? AND password = ?";

        try(Connection con = dbManager.getCon()){
            try(PreparedStatement ps = con.prepareStatement(sql)){
                ps.setInt(1,id);
                ps.setString(2,password);
                try( ResultSet rs = ps.executeQuery()){

                    if(!rs.next()){
                        System.out.println("Invalid entry");
                       EntriesRegister. invalidEntry(id,password);
                        return "Invalid username or password";
                    }else{
                        System.out.println("Valid entry");
                        EntriesRegister.validEntry(id, password);

                        return greet + " " + rs.getString(1);
                    }

                }

            }
        } catch (Exception e) {

            System.out.println(e);
        }

        System.out.println("Unknown error :(");
        return "SQL Error";
    }

}
