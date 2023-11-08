package com.abhisheksharma.blogapp.blogappbackendapis.services.impl;

import com.abhisheksharma.blogapp.blogappbackendapis.entities.User;
import com.abhisheksharma.blogapp.blogappbackendapis.payloads.UserDto;
import com.abhisheksharma.blogapp.blogappbackendapis.repositories.UserRepo;
import com.abhisheksharma.blogapp.blogappbackendapis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User newUser = this.userRepo.save(user);
        return this.userToDto(newUser);
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {

        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public UserDto getUserById(UserDto user, Integer userId) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    public User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
}
