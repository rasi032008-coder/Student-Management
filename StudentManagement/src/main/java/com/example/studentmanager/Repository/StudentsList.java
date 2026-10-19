package com.example.studentmanager.Repository;

import com.example.studentmanager.Repository.dbmanager.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class StudentsList {
    private static DBManager dbManager = new DBManager();
    public static Map<Integer,String>getStudents(){
        Map<Integer,String> students =new HashMap<>();
        String sql = "SELECT id,name FROM student  ";
        try(Connection con = dbManager.getCon()){
            try(PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
            ){
                while(rs.next()){
                    students.put(
                            rs.getInt(1),rs.getString(2)
                    );
                }
                return students;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
}
