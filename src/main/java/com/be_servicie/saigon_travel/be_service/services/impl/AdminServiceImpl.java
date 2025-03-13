package com.be_servicie.saigon_travel.be_service.services.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.be_servicie.saigon_travel.be_service.dto.request.UserCreateRequest;
import com.be_servicie.saigon_travel.be_service.dto.response.UserDTO;
import com.be_servicie.saigon_travel.be_service.entity.Role;
import com.be_servicie.saigon_travel.be_service.entity.User;
import com.be_servicie.saigon_travel.be_service.exception.AuthException;
import com.be_servicie.saigon_travel.be_service.mapper.UserToDTOMapper;
import com.be_servicie.saigon_travel.be_service.repository.AdminRepository;
import com.be_servicie.saigon_travel.be_service.repository.RoleRepository;
import com.be_servicie.saigon_travel.be_service.services.AdminService;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserToDTOMapper userToDTOMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public UserDTO createUser(UserCreateRequest request) {
        if (adminRepository.existsByEmail(request.getEmail())) {
            throw AuthException.emailExist();
        }

        User user = User.builder()
                    .id(request.getId())
                    .name(request.getName())
                    .email(request.getEmail())
                    .imageUrl(request.getImageUrl())
                    .token(request.getToken())
                    .expiry(request.getExpiry())
                    .status(request.getStatus())
                    .roles(new HashSet<>())
                    .build();


            Role userRole = roleRepository.findById("role2")
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            user.getRoles().add(userRole);
        return userToDTOMapper.toDto(adminRepository.save(user));
    }

    @Override
    public List<UserDTO> getUsers() {
        return userToDTOMapper.toListDto(adminRepository.findAll());
    }

    @Override
    public UserDTO getUserById(String id) {
        User user = adminRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("USER not found with ID: " + id));
        return userToDTOMapper.toDto(user);
    }

    // @Override
    // public void deleteUser(String id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    // }
    
}
