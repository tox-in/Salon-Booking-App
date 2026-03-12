package com.salon.service.impl;

import com.salon.dto.SalonDTO;
import com.salon.dto.UserDTO;
import com.salon.model.Salon;
import com.salon.repository.SalonRepository;
import com.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImp implements SalonService{
    private final SalonRepository salonRepository;

    @Override
    public Salon createSalon(SalonDTO salonDTO, UserDTO userDTO) {
        Salon salon = new Salon();
        salon.setName(salonDTO.getName());
        salon.setCity(salonDTO.getCity());
        salon.setEmail(salonDTO.getEmail());
        salon.setPhoneNumber(salonDTO.getPhoneNumber());
        salon.setImages(salonDTO.getImages());
        salon.setAddress(salonDTO.getAddress());
        salon.setOwnerId(userDTO.getId());
        salon.setOpenTime(salonDTO.getOpenTime());
        salon.setCloseTime(salonDTO.getCloseTime());

        return salonRepository.save(salon);
    }

    @Override
    public Salon updateSalon(SalonDTO salonDTO, UserDTO userDTO, Long userId) {
        return null;
    }

    @Override
    public List<Salon> getAllSalon() {
        return null;
    }

    @Override
    public Salon getSalonById(Long salonId) {
        return null;
    }

    @Override
    public List<Salon> getSalonByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public List<Salon> searchSalonByCity(String city) {
        return null;
    }
}
