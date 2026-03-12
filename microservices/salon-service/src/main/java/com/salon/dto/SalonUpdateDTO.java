package com.salon.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SalonUpdateDTO {
    @NotBlank(message = "Salon Name required")
    private String name;

    private List<String> images;

    @NotBlank(message = "Salon address required")
    private String address;

    @NotBlank(message = "Contact phone required")
    private String phoneNumber;

    @NotBlank(message = "Salon email required")
    @Email
    private String email;

    @NotBlank(message = "Location city required")
    private String city;

    @NotBlank(message = "Opening hour required")
    private LocalDateTime openTime;

    @NotBlank(message = "Closing hour required")
    private LocalDateTime closeTime;
}
