package com.abhisheksharma.blogapp.blogappbackendapis.controllers;

import com.abhisheksharma.blogapp.blogappbackendapis.payloads.ApiResponse;
import com.abhisheksharma.blogapp.blogappbackendapis.payloads.UserDto;
import com.abhisheksharma.blogapp.blogappbackendapis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto newUser =  this.userService.createUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }

}
