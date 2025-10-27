package com.example.service;

import com.example.dto.ItineraryPlanDTO;
import com.example.entity.ItineraryPlanEntity;
import com.example.exceptions.IdNotFoundException;
import com.example.mapper.ItineraryPlanMapper;
import com.example.repository.ItineraryPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItineraryPlanService {

    @Autowired
    private ItineraryPlanRepository itineraryPlanRepository;

    @Autowired
    private ItineraryPlanMapper itineraryPlanMapper;

    public List<ItineraryPlanDTO> getAllItineraryPlans() {
        return itineraryPlanRepository.findAll().stream()
                .map(itineraryPlanMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ItineraryPlanDTO getItineraryPlanById(Long id) {
        ItineraryPlanEntity entity = itineraryPlanRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ItineraryPlan", "id", id));
        return itineraryPlanMapper.toDTO(entity);
    }

    public ItineraryPlanDTO addItineraryPlan(ItineraryPlanDTO dto) {
        ItineraryPlanEntity saved = itineraryPlanRepository.saveAndFlush(itineraryPlanMapper.toEntity(dto));
        return itineraryPlanMapper.toDTO(saved);
    }

    public ItineraryPlanDTO updateItineraryPlan(ItineraryPlanDTO dto, Long id) {
        ItineraryPlanEntity existing = itineraryPlanRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ItineraryPlan", "id", id));
        ItineraryPlanEntity updated = itineraryPlanMapper.toEntity(dto);
        updated.setId(existing.getId());
        return itineraryPlanMapper.toDTO(itineraryPlanRepository.save(updated));
    }

    public void deleteItineraryPlan(Long id) {
        ItineraryPlanEntity entity = itineraryPlanRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ItineraryPlan", "id", id));
        itineraryPlanRepository.delete(entity);
    }


     public List<ItineraryPlanDTO> getItineraryByPackageId(Long packageId) {
        return itineraryPlanRepository.findByTravelPackageId(packageId)
                .stream()
                .map(itineraryPlanMapper::toDTO)
                .collect(Collectors.toList());
    }
}
