package com.salon.service.impl;

import com.salon.dto.SalonDTO;
import com.salon.dto.SalonUpdateDTO;
import com.salon.dto.UserDTO;
import com.salon.exception.ResourceNotFoundException;
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
    public Salon updateSalon(SalonUpdateDTO salonDTO, UserDTO userDTO, Long salonId) throws Exception {
        Salon existingSalon = salonRepository.findById(salonId).orElse(null);
        if (existingSalon!=null && existingSalon.getOwnerId().equals(userDTO.getId())){
            existingSalon.setName(salonDTO.getName());
            existingSalon.setCity(salonDTO.getCity());
            existingSalon.setEmail(salonDTO.getEmail());
            existingSalon.setPhoneNumber(salonDTO.getPhoneNumber());
            existingSalon.setImages(salonDTO.getImages());
            existingSalon.setAddress(salonDTO.getAddress());
            existingSalon.setOpenTime(salonDTO.getOpenTime());
            existingSalon.setCloseTime(salonDTO.getCloseTime());

            return salonRepository.save(existingSalon);
        }
        throw new ResourceNotFoundException("Salon doesn't exist");
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long salonId) throws Exception {
        Salon salon = salonRepository.findById(salonId).orElse(null);
        if (salon==null){
            throw new ResourceNotFoundException("Salon Not Found");
        }

        return salon;
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
        return salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Salon> searchSalonByCity(String city) {
        return salonRepository.searchSalon(city);
    }
}
