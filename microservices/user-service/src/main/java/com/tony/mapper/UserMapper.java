package com.tony.mapper;

import com.tony.dto.UserDTO;
import com.tony.dto.UserUpdateDTO;
import com.tony.model.User;

public class UserMapper {
    public static User toEntity(UserDTO dto) {
        User user = new User();

        user.setFullName(dto.getFullName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        user.setPassword(dto.getPassword());

        return user;
    }

    public static void updateEntity(User user, UserUpdateDTO dto) {
        user.setFullName(dto.getFullName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setPhone(dto.getPhone());
    }
}
