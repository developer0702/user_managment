package com.user_management.service.impl;

import com.user_management.dtos.UserDto;
import com.user_management.entity.User;
import com.user_management.exceptions.model.ResourceNotFoundException;
import com.user_management.repository.UserRepository;
import com.user_management.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    // Constructor injection
    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto addUser(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);

        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);

    }

    @Override
    public User getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user Id not found"));
        return user;
    }

    @Override
    public UserDto updateUserById(Long userId, User user) {
        Optional<User> existingUserOptional = userRepository.findById(userId);

        if (!existingUserOptional.isPresent()) {
            throw new ResourceNotFoundException("UserId is ", "for this Id", userId); // You can use custom exceptions too
        }

        User existingUser = existingUserOptional.get();

        // Update fields
        existingUser.setName(user.getName());
        existingUser.setMobile(user.getMobile());
        existingUser.setEmail(user.getEmail());

        // Save updated user
        User savedUser = userRepository.save(existingUser);

        // Return DTO
        return modelMapper.map(savedUser, UserDto.class);
    }


    @Override
    public List<UserDto> getAllUser() {

        List<User> all = userRepository.findAll();
        return all.stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
    }

    @Override
    public void deleetUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User saveOrUpdateUser(User user) {
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            // Updating existing user
            User existingUser = userRepository.findById(user.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("User", "ID", user.getId()));
            existingUser.setName(user.getName());
            existingUser.setMobile(user.getMobile());
            existingUser.setEmail(user.getEmail());

            return userRepository.save(existingUser);
        } else {
            // Creating new user
            return userRepository.save(user);
        }
    }

}
