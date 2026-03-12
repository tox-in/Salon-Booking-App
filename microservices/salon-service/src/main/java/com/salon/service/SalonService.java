package com.salon.service;

import com.salon.dto.SalonDTO;
import com.salon.dto.UserDTO;
import com.salon.model.Salon;

import java.util.List;

public interface SalonService {
    Salon createSalon(SalonDTO salonDTO, UserDTO userDTO);
    Salon updateSalon(SalonDTO salonDTO, UserDTO userDTO, Long userId);
    List<Salon> getAllSalon();
    Salon getSalonById(Long salonId);
    List<Salon> getSalonByOwnerId(Long ownerId);
    List<Salon> searchSalonByCity(String city);
}
