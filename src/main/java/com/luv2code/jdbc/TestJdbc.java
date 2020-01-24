package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hd_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hdstudent";
        String pass = "hdstudent";

        try {
            System.out.println("Connection to database" + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection succesful!!!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
