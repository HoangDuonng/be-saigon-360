package com.be_servicie.saigon_travel.be_service.controllers;

import com.be_servicie.saigon_travel.be_service.dto.response.DestinationDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.be_servicie.saigon_travel.be_service.services.DestinationService;

@RestController
@RequestMapping(path = "/api/destinations")
public class DestinationController {
    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public ResponseEntity<List<DestinationDTO>> getDestination(
        @RequestParam(defaultValue = "vi") String lang
    ) {
        List<DestinationDTO> des = destinationService.getAllDestinations(lang);
        return ResponseEntity.ok(des);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinationDTO> getDestinationById(
        @PathVariable("id") String id,
        @RequestParam(defaultValue = "vi") String lang
    ) {

        Optional<DestinationDTO> desOptional = destinationService.getDestinationById(id, lang);

        return desOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}

