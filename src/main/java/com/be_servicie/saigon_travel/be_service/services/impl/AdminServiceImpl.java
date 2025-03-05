package com.be_servicie.saigon_travel.be_service.services.impl;

import java.util.List;

import com.be_servicie.saigon_travel.be_service.dto.request.UserCreateRequest;
import com.be_servicie.saigon_travel.be_service.dto.response.UserDTO;
import com.be_servicie.saigon_travel.be_service.services.AdminService;

public class AdminServiceImpl implements AdminService {

    @Override
    public UserDTO createUser(UserCreateRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public List<UserDTO> getUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }

    @Override
    public UserDTO getUser(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public void deleteUser(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
    
}
