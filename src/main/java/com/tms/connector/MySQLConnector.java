package com.tms.connector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnector {

    private static final String DATABASE_CONNECTIVITY_PROPERTY_FILE_PATH = "D:\\JavaLearn\\Lessons\\2. Java EE\\21. Работа с интернетом и сетью\\Домашнее задание\\TMSHomeWorkLesson21-CRUDService\\src\\main\\resources\\app.properties";

    private static Connection connection;
    private static Properties properties;

    static {
        loadProperties();
    }

    private MySQLConnector() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }

        try {
            return connection = DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void loadProperties() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get(DATABASE_CONNECTIVITY_PROPERTY_FILE_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
