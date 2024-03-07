package com.example.myroutdiscover.service;

import com.example.myroutdiscover.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    UserServiceModel findById(Long id);

    boolean isNameExist(String username);
}
