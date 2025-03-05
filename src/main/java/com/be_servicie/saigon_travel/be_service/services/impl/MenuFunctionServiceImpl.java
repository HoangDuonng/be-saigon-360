package com.be_servicie.saigon_travel.be_service.services.impl;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be_servicie.saigon_travel.be_service.dto.request.MenuFunctionRequest;
import com.be_servicie.saigon_travel.be_service.dto.response.MenuFunctionDTO;
import com.be_servicie.saigon_travel.be_service.entity.MenuFunction;
import com.be_servicie.saigon_travel.be_service.mapper.MenuFunctionMapper;
import com.be_servicie.saigon_travel.be_service.repository.MenuFunctionRepository;
import com.be_servicie.saigon_travel.be_service.services.MenuFunctionService;


@Service
public class MenuFunctionServiceImpl implements MenuFunctionService {

    @Autowired
    private MenuFunctionRepository menuFunctionRepository;

    @Autowired
    private MenuFunctionMapper mapper;

    @Override
    public List<MenuFunctionDTO> getAllMenu(String lang) {
        return mapper.toListDTO(menuFunctionRepository.findAll(), lang);
    }

    @Override
    public Optional<MenuFunctionDTO> getMenuById(String id, String lang) {
        Optional<MenuFunction> optionalMenuFunction = menuFunctionRepository.findById(id);
        return optionalMenuFunction.map(menu -> mapper.toDTO(menu, lang));
    }

    @Override
    public List<MenuFunctionDTO> getMenuTrueActive(String lang) {
        return mapper.toListDTO(menuFunctionRepository.findByActiveTrue(), lang);
    }


    @Override
    @Transactional
    public MenuFunctionDTO createMenu(MenuFunctionRequest menuFunctionRequest) {
        MenuFunction menu = MenuFunction.builder()
                .nameEn(menuFunctionRequest.getName_en()) 
                .nameVi(menuFunctionRequest.getName_vi())
                .active(menuFunctionRequest.getActive())
                .build();

        return mapper.toDTO(menuFunctionRepository.save(menu), "vi"); // Default response in Vietnamese
    }

    // @Override
    // @Transactional
    // public void deleteMenuById(String id) {
    //     MenuFunction menu = menuFunctionRepository.findById(id)
    //             .orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));
    //     menuFunctionRepository.delete(menu);
    // }

}
