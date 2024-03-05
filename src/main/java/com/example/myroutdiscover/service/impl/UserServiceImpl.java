package com.example.myroutdiscover.service.impl;

import com.example.myroutdiscover.model.entity.User;
import com.example.myroutdiscover.model.entity.enums.LevelEnum;
import com.example.myroutdiscover.model.service.UserServiceModel;
import com.example.myroutdiscover.model.view.UserViewModel;
import com.example.myroutdiscover.repository.UserRepository;
import com.example.myroutdiscover.service.UserService;
import com.example.myroutdiscover.utils.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
User user = modelMapper.map(userServiceModel, User.class);
user.setLevel(LevelEnum.BEGINNER);
userRepository.saveAndFlush(user);

    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUserNameAndPassword(username,password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
currentUser.setId(id);
currentUser.setUsername(username);
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
