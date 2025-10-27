package com.example.service;

import com.example.dto.TransportModeDTO;
import com.example.entity.TransportModeEntity;
import com.example.exceptions.IdNotFoundException;
import com.example.mapper.TransportModeMapper;
import com.example.repository.TransportModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportModeService {

    @Autowired
    private TransportModeRepository transportModeRepository;

    @Autowired
    private TransportModeMapper transportModeMapper;

    public List<TransportModeDTO> getAllTransportModes() {
        return transportModeRepository.findAll().stream()
                .map(transportModeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TransportModeDTO getTransportModeById(Long id) {
        TransportModeEntity entity = transportModeRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("TransportMode", "id", id));
        return transportModeMapper.toDTO(entity);
    }

    public List<TransportModeDTO> getTransportsByPackageId(Long packageId) {
        return transportModeRepository.findByTravelPackageId(packageId).stream()
                .map(transportModeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TransportModeDTO> getAvailableTransportsByPackageId(Long packageId) {
        return transportModeRepository.findByTravelPackageIdAndAvailableSeatsGreaterThan(packageId, 0).stream()
                .map(transportModeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TransportModeDTO addTransportMode(TransportModeDTO dto) {
        TransportModeEntity saved = transportModeRepository.saveAndFlush(transportModeMapper.toEntity(dto));
        return transportModeMapper.toDTO(saved);
    }

    public TransportModeDTO updateTransportMode(TransportModeDTO dto, Long id) {
        TransportModeEntity existing = transportModeRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("TransportMode", "id", id));
        TransportModeEntity updated = transportModeMapper.toEntity(dto);
        updated.setId(existing.getId());
        return transportModeMapper.toDTO(transportModeRepository.save(updated));
    }

    public void deleteTransportMode(Long id) {
        TransportModeEntity entity = transportModeRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("TransportMode", "id", id));
        transportModeRepository.delete(entity);
    }
}
