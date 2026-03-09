package com.tony.controller;

import com.tony.model.User;
import com.tony.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public User createUser (@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List<User> getUsers () {
        return userRepository.findAll();
    }

    @GetMapping("/api/users/{userId}")
    public User findUserById(@PathVariable("userId") Long id) throws Exception {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isPresent()){
            return otp.get();
        }
        throw new Exception("User not found");
    }

    @PutMapping("/api/users/{userId}")
    public User updateUser (@RequestBody User user, @PathVariable Long userId) throws Exception {
        Optional<User> otp = userRepository.findById(userId);
        if(otp.isEmpty()){
            throw new Exception("User not found with id:"+ userId);
        }

        User existingUser = otp.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        existingUser.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(existingUser);
    }

    @DeleteMapping("/api/users/{userId}")
    public String deleteUser(@PathVariable("userId") Long id) throws Exception {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new Exception("User not found");
        }

        userRepository.deleteById(otp.get().getId());
        return "User deleted successfully";
    }
}
