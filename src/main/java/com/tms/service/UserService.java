package com.tms.service;

import com.tms.model.User;

import java.util.List;

public class UserService {

    public void addUser(User user) {
        UserCRUDService.addUser(user);
    }

    public User getUserById(int id) {
        return UserCRUDService.getUserById(id);
    }

    public List<User> getAllUsers() {
        return UserCRUDService.getAllUsers();
    }

    public void updateUser(int id, User updateUser){
        UserCRUDService.updateUser(id, updateUser);
    }

    public void deleteById(int id) {
        UserCRUDService.deleteById(id);
    }

    public void deleteAllUsers() {
        UserCRUDService.deleteAllUsers();
    }

}
