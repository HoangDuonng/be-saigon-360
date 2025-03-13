package com.be_servicie.saigon_travel.be_service.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDestinationDTO {
    private String userId;
    private String destinationId;
}