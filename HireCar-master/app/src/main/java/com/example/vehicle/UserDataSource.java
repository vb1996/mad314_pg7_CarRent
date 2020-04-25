package com.example.vehicle;

import java.util.ArrayList;
import java.util.List;

public class UserDataSource {

    private static UserDataSource instance = null;
    List<UserData> users;

    private UserDataSource() {
        users = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            UserData user = new UserData();

            // Put random values, but id must be unique
            user.id = i;
            user.firstName = "Customer ";
            user.lastName = "#" + i;
            user.userName = "Customer " + i;
            user.password = "a" + i;
            user.contact = 51460245;

            users.add(user);

        }
    }

    static UserDataSource getInstance() {
        if (instance == null) {
            instance = new UserDataSource();
        }
        return instance;
    }
}
