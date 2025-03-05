package com.be_servicie.saigon_travel.be_service.services.impl;


import com.be_servicie.saigon_travel.be_service.dto.response.DestinationDTO;
import com.be_servicie.saigon_travel.be_service.entity.Destination;
import com.be_servicie.saigon_travel.be_service.mapper.DestinationMapper;
import com.be_servicie.saigon_travel.be_service.repository.DestinationRepository;
import com.be_servicie.saigon_travel.be_service.services.DestinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationServiceImpl implements DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private DestinationMapper destinationMapper;

    @Override
    public List<DestinationDTO> getAllDestinations(String lang) {
        List<Destination> destinations = destinationRepository.findAll();
        return destinationMapper.toListDTO(destinations, lang);
    }

    @Override
    public Optional<DestinationDTO> getDestinationById(String id, String lang) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        return optionalDestination.map(des -> destinationMapper.toDTO(des, lang));
    }
}
