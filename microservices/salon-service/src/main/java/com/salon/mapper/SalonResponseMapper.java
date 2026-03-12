package com.salon.mapper;

import com.salon.dto.SalonDTO;
import com.salon.dto.SalonUpdateDTO;
import com.salon.model.Salon;

public class SalonResponseMapper {
    public static SalonDTO mapToDTO(Salon salon) {
        SalonDTO salonDTO = new SalonDTO();

        salonDTO.setId(salon.getId());
        salonDTO.setName(salon.getName());
        salonDTO.setEmail(salon.getEmail());
        salonDTO.setPhoneNumber(salon.getPhoneNumber());
        salonDTO.setCity(salon.getCity());
        salonDTO.setAddress(salon.getAddress());
        salonDTO.setImages(salon.getImages());
        salonDTO.setCloseTime(salon.getCloseTime());
        salonDTO.setOpenTime(salon.getOpenTime());
        salonDTO.setOwnerId(salon.getOwnerId());

        return salonDTO;
    }

    public static SalonUpdateDTO mapToUpdateDTO(Salon salon) {
        SalonUpdateDTO salonUpdateDTO = new SalonUpdateDTO();

        salonUpdateDTO.setName(salon.getName());
        salonUpdateDTO.setEmail(salon.getEmail());
        salonUpdateDTO.setPhoneNumber(salon.getPhoneNumber());
        salonUpdateDTO.setCity(salon.getCity());
        salonUpdateDTO.setAddress(salon.getAddress());
        salonUpdateDTO.setImages(salon.getImages());
        salonUpdateDTO.setCloseTime(salon.getCloseTime());
        salonUpdateDTO.setOpenTime(salon.getOpenTime());

        return salonUpdateDTO;
    }
}
