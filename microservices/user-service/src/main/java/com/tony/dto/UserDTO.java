package com.tony.dto;

import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "Full name required")
    private String fullName;

    @NotBlank(message = "Username required")
    private String username;

    @Email
    @NotBlank
    private String email;

    private String phone;

    @NotBlank
    private String role;

    @NotBlank
    @Size(min = 6)
    private String password;
}