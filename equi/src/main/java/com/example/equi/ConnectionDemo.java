package com.example.equi;

import lombok.var;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    public static void main(String[] args) {
        // create three connections to three different databases on localhost
        Connection conn1 = null;
        Connection conn2 = null;
        Connection conn3 = null;

        try {
            // Connect method #1
            String dbURL1 = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=password";
            conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                System.out.println("Connected to database #1");
                System.out.println(conn1.getSchema( ));
            }

            // METHOD #2
            String dbURL2 = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "password";
            conn2 = DriverManager.getConnection(dbURL2, username, password);
            if (conn2 != null) {
                System.out.println("Connected with connection #2");
            }

            // METHOD #3
            String dbURL3 = "jdbc:postgresql://localhost:5432/postgres";
            Properties properties = new Properties();
            properties.put("user", "postgres");
            properties.put("password", "password");
            properties.put("defaultRowPrefetch", "20");
            conn3 = DriverManager.getConnection(dbURL3, properties);
            
            if (conn3 != null) {
                System.out.println("Connected with connection #3");
            }
            try (var statement = conn3 .createStatement()) {
                System.out.println( conn3 .getSchema());
//                System.out.println( conn3 .get);
//                var selection = statement.executeQuery(String.format(
//                        "select * from %s role 1"
//                )
//                );
            } catch (SQLException ex) {
                ex.printStackTrace();}
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
                if (conn2 != null && !conn2.isClosed()) {
                    conn2.close();
                }
                if (conn3 != null && !conn3.isClosed()) {
                    conn3.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}