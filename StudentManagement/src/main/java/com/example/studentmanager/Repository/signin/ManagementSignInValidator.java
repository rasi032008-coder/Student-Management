package com.example.studentmanager.Repository.signin;

import com.example.studentmanager.Repository.dbmanager.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagementSignInValidator {
    private static DBManager dbManager= new DBManager();


    public static String validate(String password){
        try(Connection con = dbManager.getCon()){
            String sql = "SELECT * FROM passwords WHERE mpassword = ?";
            try(PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1,password);
                try(ResultSet rs = ps.executeQuery()){
                    if(!rs.next()){
                        System.out.println("Invalid entry");
                        EntriesRegister.invalidEntry(password);
                        return "Invalid username or password";
                    }
                    else{
                        System.out.println("Valid entry");
                        EntriesRegister.validEntry(password);
                        return "Welcome !!";
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return "SQL Error";
    }
}
