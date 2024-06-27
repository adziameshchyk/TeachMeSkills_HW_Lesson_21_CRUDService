package com.tms.service;

import com.tms.connector.MySQLConnector;
import com.tms.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserCRUDService {

    private static final String SQL_QUERY_ADD_USER = "INSERT INTO user (name, surname, age, email) VALUES (?, ?, ?, ?)";
    private static final String SQL_QUERY_GET_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static final String SQL_QUERY_GET_ALL_USERS = "SELECT * FROM user";
    private static final String SQL_QUERY_UPDATE_USER = "UPDATE user SET name = ?, surname = ?, age = ?, email = ? WHERE id = ?";
    private static final String SQL_QUERY_DELETE_USER_BY_ID = "DELETE FROM user WHERE id = ?";
    private static final String SQL_QUERY_DELETE_ALL_USERS = "DELETE FROM user";

    public static void addUser(User user) {
        try (PreparedStatement preparedStatement = MySQLConnector.getConnection().prepareStatement(SQL_QUERY_ADD_USER)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User getUserById(int id) {
        try (PreparedStatement preparedStatement = MySQLConnector.getConnection().prepareStatement(SQL_QUERY_GET_USER_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = null;
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");

                user = new User(id, name, surname, age, email);
            }

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<User> getAllUsers() {
        try (Statement statement = MySQLConnector.getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(SQL_QUERY_GET_ALL_USERS);

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("email")
                ));
            }

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void updateUser(int id, User updateUser) {
        try (PreparedStatement preparedStatement = MySQLConnector.getConnection().prepareStatement(SQL_QUERY_UPDATE_USER)) {

            preparedStatement.setString(1, updateUser.getName());
            preparedStatement.setString(2, updateUser.getSurname());
            preparedStatement.setInt(3, updateUser.getAge());
            preparedStatement.setString(4, updateUser.getEmail());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(int id) {
        try (PreparedStatement preparedStatement = MySQLConnector.getConnection().prepareStatement(SQL_QUERY_DELETE_USER_BY_ID)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllUsers() {
        try (Statement statement = MySQLConnector.getConnection().createStatement()) {

            statement.executeUpdate(SQL_QUERY_DELETE_ALL_USERS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
