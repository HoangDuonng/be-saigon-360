package com.be_servicie.saigon_travel.be_service.services;

import java.util.List;

import com.be_servicie.saigon_travel.be_service.dto.request.UserCreateRequest;
import com.be_servicie.saigon_travel.be_service.dto.response.UserDTO;

public interface AdminService {
    UserDTO createUser(UserCreateRequest request);

    List<UserDTO> getUsers();

    UserDTO getUser(String  id);

    void deleteUser(String id);
}
