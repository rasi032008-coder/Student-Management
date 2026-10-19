package com.example.studentmanager.Repository.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
    Connection con;

    public DBManager() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }



    }

    public Connection getCon() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:sqlite:C:\\Users\\Smile\\Documents\\Sem2\\Java\\StudentProject.db"
        );
    }
}
