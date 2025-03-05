package com.be_servicie.saigon_travel.be_service.dto.request;

import java.time.LocalDateTime;
import java.util.Set;

import com.be_servicie.saigon_travel.be_service.entity.Role;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String id;

    private String email;

    private String name;

    private String imageUrl;

    private String token;

    private LocalDateTime expiry;

    private Boolean status;

    private Set<Role> role;
}