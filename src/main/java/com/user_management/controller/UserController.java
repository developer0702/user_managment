package com.user_management.controller;

import com.user_management.dtos.UserDto;
import com.user_management.entity.User;
import com.user_management.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    // Constructor Injection
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto addUser = userService.addUser(user);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody User user) {
        UserDto updatedUser = userService.updateUserById(userId, user);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        User userById = userService.getUserById(userId);
        return new ResponseEntity<>(userById,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> allUser =
                userService.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId){
        userService.deleetUserById(userId);
        return "user deleted successfully";
    }
}
