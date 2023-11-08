package com.abhisheksharma.blogapp.blogappbackendapis.services;

import com.abhisheksharma.blogapp.blogappbackendapis.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    List<UserDto> getAllUsers();
    UserDto getUserById(UserDto user, Integer userId);
    void deleteUser(Integer userId);
}
