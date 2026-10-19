package com.example.studentmanager.Repository.signin;

import com.example.studentmanager.Repository.dbmanager.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FacultySignInValidator {
    static DBManager dbManager ;
    static final String INVALID_ENTRY = "Invalid username or password";
    static {
        dbManager = new DBManager();
    }

    public static String fType;
    public static String fPassword;

    public static String validate(String id, String password,String type){
        if(type.equalsIgnoreCase("java")){
            fType = "jfaculty";
            fPassword = "jpassword";
        }
        else if(type.equalsIgnoreCase("DS")){
            fType = "dfaculty";
            fPassword = "dpassword";
        }
        else if(type.equalsIgnoreCase("Software")){
            fType = "sfaculty";
            fPassword = "spassword";
        }
        else{
            throw new RuntimeException("Invalid Faculty Type");
        }
        return validate(id,password);
    }


    public static String validate(String id,String password){
        String sql = "SELECT " + fType + " FROM management " +
                " WHERE " + fType +" = ? AND " + fPassword + " = ?";

        try(Connection con = dbManager.getCon()){
            try(PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1,id);
                ps.setString(2,password);
                try( ResultSet rs = ps.executeQuery()){

                    if(!rs.next()){
                        System.out.println(rs.getInt(1));
                        System.out.println("Invalid entry");
                        EntriesRegister.invalidEntry(id,password);
                        return INVALID_ENTRY;
                    }else{
                        System.out.println(rs.getInt(1));
                        System.out.println("Valid entry");
                        EntriesRegister.validEntry(id, password);

                        return "Welcome " + rs.getString(1);
                    }

                }

            }
        } catch (Exception e) {

            System.out.println(e);
        }

        System.out.println("Unknown error :(");
        return "SQL ERROR";
    }

}
