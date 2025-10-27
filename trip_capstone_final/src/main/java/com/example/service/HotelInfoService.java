package com.example.service;

import com.example.dto.HotelInfoDTO;
import com.example.entity.HotelInfoEntity;
import com.example.exceptions.IdNotFoundException;
import com.example.mapper.HotelInfoMapper;
import com.example.repository.HotelInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelInfoService {

    @Autowired
    private HotelInfoRepository hotelInfoRepository;

    @Autowired
    private HotelInfoMapper hotelInfoMapper;

    public List<HotelInfoDTO> getAllHotels() {
        return hotelInfoRepository.findAll().stream()
                .map(hotelInfoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public HotelInfoDTO getHotelById(Long id) {
        HotelInfoEntity entity = hotelInfoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("HotelInfo", "id", id));
        return hotelInfoMapper.toDTO(entity);
    }

    public HotelInfoDTO addHotel(HotelInfoDTO dto) {
        HotelInfoEntity saved = hotelInfoRepository.saveAndFlush(hotelInfoMapper.toEntity(dto));
        return hotelInfoMapper.toDTO(saved);
    }

    public HotelInfoDTO updateHotel(HotelInfoDTO dto, Long id) {
        HotelInfoEntity existing = hotelInfoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("HotelInfo", "id", id));
        HotelInfoEntity updated = hotelInfoMapper.toEntity(dto);
        updated.setId(existing.getId());
        return hotelInfoMapper.toDTO(hotelInfoRepository.save(updated));
    }

    public void deleteHotel(Long id) {
        HotelInfoEntity entity = hotelInfoRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("HotelInfo", "id", id));
        hotelInfoRepository.delete(entity);
    }

   
      public List<HotelInfoDTO> getHotelsByPackageId(Long packageId) {
        return hotelInfoRepository.findByTravelPackageId(packageId)
                .stream()
                .map(hotelInfoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
