package com.be_servicie.saigon_travel.be_service.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.be_servicie.saigon_travel.be_service.dto.response.MenuFunctionDTO;
import com.be_servicie.saigon_travel.be_service.dto.response.SubMenuFunctionDTO;
import com.be_servicie.saigon_travel.be_service.entity.MenuFunction;

@Component
public class MenuFunctionMapper {

    @Autowired
    private SubMenuFunctionMapper subFunctionMapper;

    public MenuFunctionDTO toDTO(MenuFunction menuFunction, String lang) {
        if (menuFunction == null) {
            return null;  // ✅ Avoid NullPointerException
        }

        List<SubMenuFunctionDTO.ShortDTO> subFunctionShortDTOs = Optional.ofNullable(menuFunction.getSubFunctions())
                .map(subFunctions -> subFunctions.stream()
                        .map(sub -> subFunctionMapper.toShortDTO(sub, lang))
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        return MenuFunctionDTO.builder()
                .id(menuFunction.getId())
                .nameEn(menuFunction.getNameEn())
                .nameVi(menuFunction.getNameVi())
                .active(menuFunction.getActive())
                .subFunctions(subFunctionShortDTOs)
                .build();
    }

    public List<MenuFunctionDTO> toListDTO(List<MenuFunction> menuFunctions, String lang) {
        if (menuFunctions == null || menuFunctions.isEmpty()) {
            return Collections.emptyList();  // ✅ Avoid NullPointerException
        }

        return menuFunctions.stream()
                .map(menu -> toDTO(menu, lang))
                .collect(Collectors.toList());
    }
}
