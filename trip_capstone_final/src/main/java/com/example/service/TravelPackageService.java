package com.example.service;

import com.example.dto.TravelPackageDTO;
import com.example.entity.TravelPackageEntity;
import com.example.exceptions.IdNotFoundException;
import com.example.mapper.TravelPackageMapper;
import com.example.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelPackageService {

    @Autowired
    private TravelPackageRepository travelPackageRepository;

    @Autowired
    private TravelPackageMapper travelPackageMapper;

    public List<TravelPackageDTO> getAllPackages() {
        return travelPackageRepository.findAll().stream()
                .map(travelPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TravelPackageDTO> getAllActivePackages() {
        return travelPackageRepository.findByPackageStatus("ACTIVE").stream()
                .map(travelPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TravelPackageDTO getPackageById(Long id) {
        TravelPackageEntity entity = travelPackageRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("TravelPackage", "id", id));
        return travelPackageMapper.toDTO(entity);
    }

    public List<TravelPackageDTO> searchPackages(String source, String destination, Date fromDate, Date toDate) {
        return travelPackageRepository.searchPackages(source, destination, fromDate, toDate).stream()
                .map(travelPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TravelPackageDTO addPackage(TravelPackageDTO dto) {
        TravelPackageEntity saved = travelPackageRepository.saveAndFlush(travelPackageMapper.toEntity(dto));
        return travelPackageMapper.toDTO(saved);
    }

    public TravelPackageDTO updatePackage(TravelPackageDTO dto, Long id) {
        TravelPackageEntity existing = travelPackageRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("TravelPackage", "id", id));
        TravelPackageEntity updated = travelPackageMapper.toEntity(dto);
        updated.setId(existing.getId());
        return travelPackageMapper.toDTO(travelPackageRepository.save(updated));
    }

    public void deletePackage(Long id) {
        TravelPackageEntity entity = travelPackageRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("TravelPackage", "id", id));
        travelPackageRepository.delete(entity);
    }
}
