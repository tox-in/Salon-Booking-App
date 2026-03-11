package com.tony.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateDTO {
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
}
