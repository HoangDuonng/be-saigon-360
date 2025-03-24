package com.be_servicie.saigon_travel.be_service.services.impl;


import com.be_servicie.saigon_travel.be_service.dto.request.DestinationRequest;
import com.be_servicie.saigon_travel.be_service.dto.response.DestinationDTO;
import com.be_servicie.saigon_travel.be_service.entity.Destination;
import com.be_servicie.saigon_travel.be_service.mapper.DestinationMapper;
import com.be_servicie.saigon_travel.be_service.repository.DestinationRepository;
import com.be_servicie.saigon_travel.be_service.services.DestinationService;
import com.be_servicie.saigon_travel.be_service.services.UploadService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DestinationServiceImpl implements DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private DestinationMapper destinationMapper;

    @Autowired
    private UploadService uploadService;

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

    @Override
    public List<Destination> getAllDestinationsWithoutLang() {
        return destinationRepository.findAll();  
    }

    // @Override
    // @Transactional
    // public DestinationDTO createDestination(DestinationRequest request, MultipartFile image_banner, MultipartFile image_content) {
    //     Destination.DestinationBuilder destinationBuilder = Destination.builder()
    //                                 .name_vi(request.getName_vi())
    //                                 .name_en(request.getName_en())
    //                                 .address_en(request.getAddress_en())
    //                                 .address_vi(request.getAddress_vi())
    //                                 .content_en(request.getContent_en())
    //                                 .content_vi(request.getContent_vi())
    //                                 .description_en(request.getDescription_en())
    //                                 .description_vi(request.getDescription_vi())
    //                                 .title_en(request.getTitle_en())
    //                                 .title_vi(request.getTitle_vi())
    //                                 .open_time(request.getOpen_time());
    //                                 if (image_banner != null && !image_banner.isEmpty()) {
    //                                     String imagePath = uploadService.handleSaveUploadFile(image_banner, "destination");
    //                                     destinationBuilder.image_banner(imagePath);
    //                                 }
    //                                 if (image_content != null && !image_content.isEmpty()) {
    //                                     String imagePath = uploadService.handleSaveUploadFile(image_content, "destination");
    //                                     destinationBuilder.image_content(imagePath);
    //                                 }
    //     Destination destination = destinationBuilder.build();
    //     return destinationMapper.toDTO(destinationRepository.save(destination));                        
    // }

    @Override
    @Transactional
    public DestinationDTO createDestination(DestinationRequest request, List<MultipartFile> image_banners, List<MultipartFile> image_contents) {
        Destination.DestinationBuilder destinationBuilder = Destination.builder()
                .name_vi(request.getName_vi())
                .name_en(request.getName_en())
                .address_en(request.getAddress_en())
                .address_vi(request.getAddress_vi())
                .content_en(request.getContent_en())
                .content_vi(request.getContent_vi())
                .description_en(request.getDescription_en())
                .description_vi(request.getDescription_vi())
                .title_en(request.getTitle_en())
                .title_vi(request.getTitle_vi())
                .open_time(request.getOpen_time());

        // Xử lý upload nhiều ảnh banner
        if (image_banners != null && !image_banners.isEmpty()) {
            String bannerPaths = image_banners.stream()
                    .map(file -> uploadService.handleSaveUploadFile(file, "destination/banner"))
                    .collect(Collectors.joining(","));
            destinationBuilder.image_banner(bannerPaths); // Lưu đường dẫn dưới dạng chuỗi cách nhau bởi dấu phẩy
        }

        // Xử lý upload nhiều ảnh content
        if (image_contents != null && !image_contents.isEmpty()) {
            String contentPaths = image_contents.stream()
                    .map(file -> uploadService.handleSaveUploadFile(file, "destination/content"))
                    .collect(Collectors.joining(","));
            destinationBuilder.image_content(contentPaths);
        }

        Destination destination = destinationBuilder.build();
        return destinationMapper.toDTO(destinationRepository.save(destination));
    }

}
