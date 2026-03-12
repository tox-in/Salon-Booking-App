package com.salon.service;

import com.salon.dto.SalonDTO;
import com.salon.dto.SalonUpdateDTO;
import com.salon.dto.UserDTO;
import com.salon.model.Salon;

import java.util.List;

public interface SalonService {
    Salon createSalon(SalonDTO salonDTO, UserDTO userDTO);
    Salon updateSalon(SalonUpdateDTO salonDTO, UserDTO userDTO, Long userId) throws Exception;
    List<Salon> getAllSalons();
    Salon getSalonById(Long salonId) throws Exception;
    Salon getSalonByOwnerId(Long ownerId);
    List<Salon> searchSalonByCity(String city);
}
