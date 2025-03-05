package com.be_servicie.saigon_travel.be_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.be_servicie.saigon_travel.be_service.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String>{
    
}
