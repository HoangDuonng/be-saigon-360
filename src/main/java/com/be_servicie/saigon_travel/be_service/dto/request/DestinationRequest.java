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
    private String address_vi;
    private String address_en;
    private String title_vi;
    private String title_en;
    private String description_vi;
    private String description_en;
    private String content_vi;
    private String content_en;
    private String open_time;
}