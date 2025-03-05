package com.be_servicie.saigon_travel.be_service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import com.be_servicie.saigon_travel.be_service.dto.response.SubMenuFunctionDTO;
import com.be_servicie.saigon_travel.be_service.entity.SubFunction;

@Component
public class SubMenuFunctionMapper {
    public SubMenuFunctionDTO.FullDTO toFullDTO(SubFunction subMenuFunction, String lang) {
        String menuFunctionId = null;
        String menuFunctionName = null;

        if (subMenuFunction.getMenuFunction() != null) {
            menuFunctionId = subMenuFunction.getMenuFunction().getId();
            menuFunctionName = "en".equals(lang) 
                ? subMenuFunction.getMenuFunction().getNameEn() 
                : subMenuFunction.getMenuFunction().getNameVi();
        }

        return SubMenuFunctionDTO.FullDTO.builder()
                .id(subMenuFunction.getId())
                .name("en".equals(lang) ? subMenuFunction.getNameEn() : subMenuFunction.getNameVi())
                .url(subMenuFunction.getUrl())
                .active(subMenuFunction.getActive())
                .menuFunctionId(menuFunctionId)
                .menuFunctionName(menuFunctionName)
                .build();
    }

    public SubMenuFunctionDTO.ShortDTO toShortDTO(SubFunction subMenuFunction, String lang) {
        return SubMenuFunctionDTO.ShortDTO.builder()
                .name("en".equals(lang) ? subMenuFunction.getNameEn() : subMenuFunction.getNameVi())
                .url(subMenuFunction.getUrl())
                .build();
    }

    public List<SubMenuFunctionDTO.FullDTO> toListFullDTO(List<SubFunction> subMenuFunctions, String lang) {
        return subMenuFunctions.stream()
                .map(sub -> toFullDTO(sub, lang))
                .collect(Collectors.toList());
    }

    public List<SubMenuFunctionDTO.ShortDTO> toListShortDTO(List<SubFunction> subMenuFunctions, String lang) {
        return subMenuFunctions.stream()
                .map(sub -> toShortDTO(sub, lang))
                .collect(Collectors.toList());
    }
}
