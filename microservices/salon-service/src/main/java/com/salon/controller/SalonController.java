package com.salon.controller;

import com.salon.dto.SalonDTO;
import com.salon.dto.SalonUpdateDTO;
import com.salon.dto.UserDTO;
import com.salon.mapper.SalonResponseMapper;
import com.salon.model.Salon;
import com.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.createSalon(salonDTO, userDTO);
        SalonDTO salonDTO1 = SalonResponseMapper.mapToDTO(salon);
        return ResponseEntity.ok(salonDTO1);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SalonUpdateDTO> updateSalon(@PathVariable("id") Long salonId,  @RequestBody SalonUpdateDTO salonUpdateDTO) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.updateSalon(salonUpdateDTO, userDTO, salonId);
        SalonUpdateDTO salonUpdateDTO1 = SalonResponseMapper.mapToUpdateDTO(salon);
        return ResponseEntity.ok(salonUpdateDTO1);
    }

    @GetMapping
    public ResponseEntity<List<SalonDTO>> getSalons() throws Exception{
        List<Salon> salons = salonService.getAllSalons();

        List<SalonDTO> salonDTOS = salons.stream().map((salon) -> {
            SalonDTO salonDTO = SalonResponseMapper.mapToDTO(salon);
            return salonDTO;
        }).toList();
        return ResponseEntity.ok(salonDTOS);
    }

    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDTO> searchSalon(@PathVariable Long salonId) throws Exception{
        Salon salon = salonService.getSalonById(salonId);
        SalonDTO salonDTO = SalonResponseMapper.mapToDTO(salon);

        return ResponseEntity.ok(salonDTO);
    }

    //http://localhost:5002/api/salons/search?city=huye
    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>> searchSalons(@RequestParam("city") String city) throws Exception{
        List<Salon> salons = salonService.searchSalonByCity(city);

        List<SalonDTO> salonDTOS = salons.stream().map((salon) -> {
            SalonDTO salonDTO = SalonResponseMapper.mapToDTO(salon);
            return salonDTO;
        }).toList();
        return ResponseEntity.ok(salonDTOS);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<SalonDTO> getSalonByOwnerId(@PathVariable Long ownerId) throws Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Salon salon = salonService.getSalonByOwnerId(userDTO.getId());
        SalonDTO salonDTO = SalonResponseMapper.mapToDTO(salon);

        return ResponseEntity.ok(salonDTO);
    }
}
