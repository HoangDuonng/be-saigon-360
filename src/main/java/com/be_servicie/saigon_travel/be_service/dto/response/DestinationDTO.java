package com.be_servicie.saigon_travel.be_service.dto.response;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DestinationDTO {
    private String id;
    private String name_vi;
    private String name_en;
    private String address_vi;
    private String address_en;
    private String open_time;
    private String title_vi;
    private String title_en;
    private String description_vi;
    private String description_en;
    private String image_banner;
    private String image_content;
    private Boolean status;
}
