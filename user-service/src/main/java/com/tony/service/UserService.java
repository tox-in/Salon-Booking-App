package com.tony.service;

import com.tony.dto.UserDTO;
import com.tony.dto.UserUpdateDTO;
import com.tony.model.User;

import java.util.List;

public interface UserService {
    User createUser(UserDTO dto);
    User getUserById(Long id) throws Exception;
    List<User> getAllUsers();
    void deleteUser(Long id) throws Exception;
    User updateUser(Long id, UserUpdateDTO dto) throws Exception;
}
