package com.be_servicie.saigon_travel.be_service.dto.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DestinationRequest {
    private String name_vi;
    private String name_en;
    private Boolean active;
}