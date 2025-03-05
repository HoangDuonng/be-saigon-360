package com.be_servicie.saigon_travel.be_service.dto.request;
import lombok.Data;


@Data
public class MenuFunctionRequest {
    private String name_en;
    private String name_vi;
    private Boolean active;
}
