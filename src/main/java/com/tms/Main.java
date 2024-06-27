package com.tms;

import com.tms.model.User;
import com.tms.service.UserService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.addUser(new User("alex", "martynow", 32, "aspihgas@gmial.com"));
        userService.addUser(new User("vitia", "armirib", 75));
        userService.addUser(new User("stepa", "flachin", 23, "arbitz@gmial.com"));
        userService.addUser(new User("asul", "jaksrtow", 25, "makskorsz@gmial.com"));
        userService.addUser(new User("felix", 32, "aspihgas@gmial.com"));
        userService.addUser(new User("r2", 203));

//        userService.deleteAllUsers();

//        List<User> users = userService.getAllUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }

//        userService.updateUser(34, new User("askfj", "ads;gh", 255));
//
//        users = userService.getAllUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }

//        User user = userService.getUserById(31);
//        System.out.println(user);

//        userService.addUser(new User("tesT", "TEST", 45));
    }

}
