package com.tony.service.impl;

import com.tony.dto.UserDTO;
import com.tony.dto.UserUpdateDTO;
import com.tony.mapper.UserMapper;
import com.tony.model.User;
import com.tony.repository.UserRepository;
import com.tony.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(UserDTO dto) {
        User user = UserMapper.toEntity(dto);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("User not found with id: "+id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found:" +id));

        userRepository.delete(user);
    }

    @Override
    @Transactional
    public User updateUser(Long id, UserUpdateDTO dto) throws Exception {

        User existingUser = userRepository.findById(id).orElseThrow(() -> new Exception("User not registered with id:"+ id));

        if (!existingUser.getEmail().equals(dto.getEmail()) &&
                userRepository.existsByEmail(dto.getEmail())) {
            throw new Exception("Email already in use");
        }

        UserMapper.updateEntity(existingUser, dto);

        return userRepository.save(existingUser);
    }
}
