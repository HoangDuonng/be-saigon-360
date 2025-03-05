package com.be_servicie.saigon_travel.be_service.mapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.be_servicie.saigon_travel.be_service.dto.response.DestinationDTO;
import com.be_servicie.saigon_travel.be_service.entity.Destination;

@Component
public class DestinationMapper {

    public DestinationDTO toDTO(Destination destination, String lang) {
        if (destination == null) {
            return null;  
        }

        return DestinationDTO.builder()
                .id(destination.getId())
                .name_vi(Objects.equals(lang, "vi") ? destination.getName_vi() : null)
                .name_en(Objects.equals(lang, "en") ? destination.getName_en() : null)
                .address_vi(Objects.equals(lang, "vi") ? destination.getAddress_vi() : null)
                .address_en(Objects.equals(lang, "en") ? destination.getAddress_en() : null)
                .open_time(destination.getOpen_time())
                .title_vi(Objects.equals(lang, "vi") ? destination.getTitle_vi() : null)
                .title_en(Objects.equals(lang, "en") ? destination.getTitle_en() : null)
                .description_vi(Objects.equals(lang, "vi") ? destination.getDescription_vi() : null)
                .description_en(Objects.equals(lang, "en") ? destination.getDescription_en() : null)
                .image_banner(destination.getImage_banner())
                .image_content(destination.getImage_content())
                .status(destination.getStatus())
                .build();
    }

    public List<DestinationDTO> toListDTO(List<Destination> destinations, String lang) {
        if (destinations == null || destinations.isEmpty()) {
            return Collections.emptyList(); 
        }

        return destinations.stream()
                .map(destination -> toDTO(destination, lang))
                .collect(Collectors.toList());
    }
}
