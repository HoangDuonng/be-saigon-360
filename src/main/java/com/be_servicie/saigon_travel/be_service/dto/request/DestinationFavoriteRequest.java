package com.be_servicie.saigon_travel.be_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DestinationFavoriteRequest {
    private String destination_id;
    private String user_id;
}
