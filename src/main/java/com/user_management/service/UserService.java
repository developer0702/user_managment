package com.user_management.service;

import com.user_management.dtos.UserDto;
import com.user_management.entity.User;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto userDto);
    User getUserById(Long userId);
    UserDto updateUserById(Long userId, User user);
    List<UserDto> getAllUser();
    void deleetUserById(Long UserId);
    User saveOrUpdateUser(User userDto);
}
