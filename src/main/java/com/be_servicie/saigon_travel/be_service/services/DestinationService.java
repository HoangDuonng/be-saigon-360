package com.be_servicie.saigon_travel.be_service.services;

import com.be_servicie.saigon_travel.be_service.dto.response.DestinationDTO;
import java.util.List;
import java.util.Optional;

public interface DestinationService {
    List<DestinationDTO> getAllDestinations(String lang);
    Optional<DestinationDTO> getDestinationById(String id, String lang);
}