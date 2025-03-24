package com.be_servicie.saigon_travel.be_service.controllers;

import com.be_servicie.saigon_travel.be_service.dto.request.DestinationRequest;
import com.be_servicie.saigon_travel.be_service.dto.response.DestinationDTO;
import com.be_servicie.saigon_travel.be_service.entity.Destination;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Optional;

import com.be_servicie.saigon_travel.be_service.services.DestinationService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(path = "/api/destinations")
public class DestinationController {
    @Autowired
    private DestinationService destinationService;

    // @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    // public ResponseEntity<?> createDestination(
    //         @RequestPart("data") String data,
    //         @RequestPart(value = "image_banner", required = false) MultipartFile image_banner,
    //         @RequestPart(value = "image_content", required = false) MultipartFile image_content) {
    //     try {
    //         // Chuyển đổi String JSON thành DestinationRequest
    //         ObjectMapper objectMapper = new ObjectMapper();
    //         DestinationRequest destinationRequest = objectMapper.readValue(data, DestinationRequest.class);

    //         DestinationDTO newDes = destinationService.createDestination(destinationRequest, image_banner, image_content);
    //         return ResponseEntity.status(HttpStatus.CREATED).body(newDes);
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi xử lý dữ liệu đầu vào!");
    //     }
    // }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> createDestination(
            @RequestPart("data") String data,
            @RequestPart(value = "image_banner", required = false) List<MultipartFile> image_banners,
            @RequestPart(value = "image_content", required = false) List<MultipartFile> image_contents) {
        try {
            // Chuyển đổi String JSON thành DestinationRequest
            ObjectMapper objectMapper = new ObjectMapper();
            DestinationRequest destinationRequest = objectMapper.readValue(data, DestinationRequest.class);

            // Truyền List<MultipartFile> vào service
            DestinationDTO newDes = destinationService.createDestination(destinationRequest, image_banners, image_contents);
            return ResponseEntity.status(HttpStatus.CREATED).body(newDes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lỗi xử lý dữ liệu đầu vào!");
        }
    }


    

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

    @GetMapping("/all")
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> des = destinationService.getAllDestinationsWithoutLang();  // Đổi thành Destination
        return ResponseEntity.ok(des);
    }
}

