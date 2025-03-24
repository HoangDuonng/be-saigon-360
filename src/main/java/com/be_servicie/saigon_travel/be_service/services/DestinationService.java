package com.be_servicie.saigon_travel.be_service.services;

import com.be_servicie.saigon_travel.be_service.dto.request.DestinationRequest;
import com.be_servicie.saigon_travel.be_service.dto.response.DestinationDTO;
import com.be_servicie.saigon_travel.be_service.entity.Destination;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

public interface DestinationService {
    DestinationDTO createDestination(DestinationRequest request, List<MultipartFile> image_banners, List<MultipartFile> image_contents);
    List<DestinationDTO> getAllDestinations(String lang);
    Optional<DestinationDTO> getDestinationById(String id, String lang);
    List<Destination> getAllDestinationsWithoutLang();
}