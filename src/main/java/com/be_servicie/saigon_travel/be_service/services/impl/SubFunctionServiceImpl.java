package com.be_servicie.saigon_travel.be_service.services.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be_servicie.saigon_travel.be_service.dto.response.SubMenuFunctionDTO;
import com.be_servicie.saigon_travel.be_service.entity.SubFunction;
import com.be_servicie.saigon_travel.be_service.mapper.SubMenuFunctionMapper;
import com.be_servicie.saigon_travel.be_service.repository.MenuFunctionRepository;
import com.be_servicie.saigon_travel.be_service.repository.SubFunctionRepository;
import com.be_servicie.saigon_travel.be_service.services.SubFunctionService;

@Service
public class SubFunctionServiceImpl implements SubFunctionService {

    @Autowired
    private SubFunctionRepository subFunctionRepository;

    @Autowired
    private MenuFunctionRepository menuFunctionRepository;

    @Autowired
    private SubMenuFunctionMapper mapper;

    @Override
    public List<SubMenuFunctionDTO.FullDTO> getAllSub(String lang) {
        List<SubFunction> subFunctions = subFunctionRepository.findAll();
        return subFunctions.stream()
                .map(sub -> convertToFullDTO(sub, lang))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SubMenuFunctionDTO.FullDTO> getSub(String id, String lang) {
        return subFunctionRepository.findById(id)
                .map(sub -> convertToFullDTO(sub, lang));
    }

    @Override
    public List<SubMenuFunctionDTO.FullDTO> getSubTrueActive(String lang) {
        List<SubFunction> activeSubFunctions = subFunctionRepository.findByActiveTrue();
        return activeSubFunctions.stream()
                .map(sub -> convertToFullDTO(sub, lang))
                .collect(Collectors.toList());
    }

    private SubMenuFunctionDTO.FullDTO convertToFullDTO(SubFunction subFunction, String lang) {
        String name = lang.equals("en") ? subFunction.getNameEn() : subFunction.getNameVi();
        return SubMenuFunctionDTO.FullDTO.builder()
                .id(subFunction.getId())
                .name(name)
                .url(subFunction.getUrl())
                .active(subFunction.getActive())
                .menuFunctionId(subFunction.getMenuFunction() != null ? subFunction.getMenuFunction().getId() : null)
                .menuFunctionName(subFunction.getMenuFunction() != null
                        ? (lang.equals("en") ? subFunction.getMenuFunction().getNameEn() : subFunction.getMenuFunction().getNameVi())
                        : null)
                .build();
    }
}
