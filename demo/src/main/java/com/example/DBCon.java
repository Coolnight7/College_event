package com.example;

import java.sql.*;

public class DBCon {
        private static final String URL="jdbc:postgresql://localhost:5432/demo";
        private static final String User="postgres";
        private static final String Pass="park_7jimin";

        public static Connection getConnection() throws SQLException{
            
            return DriverManager.getConnection(URL,User,Pass);
        }
}
