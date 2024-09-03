package com.courier.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DBConnection {
    private static Connection connection = null;

    static {
        InputStream input = null;
        try {
//            input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
//            if (input == null) {
//                throw new RuntimeException("db.properties file not found in the classpath.");
//            }

//            Properties props = new Properties();
//            props.load(input);

//            String url = props.getProperty("jdbc.url");
//            String username = props.getProperty("jdbc.username");
//            String password = props.getProperty("jdbc.password");
            String url = "jdbc:mysql://localhost:3306/courier_management_system";
            String username = "root";
            String password = "RajDEep@2001";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
