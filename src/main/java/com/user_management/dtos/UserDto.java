package com.user_management.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;

    private String username;

    private String email;

    private String password;

    private String role;

    private boolean active;

    private String mobile;

}
