package com.be_servicie.saigon_travel.be_service.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.be_servicie.saigon_travel.be_service.dto.response.SubMenuFunctionDTO;
import com.be_servicie.saigon_travel.be_service.services.SubFunctionService;

@RestController
@RequestMapping(path = "/api/sub-function", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubFunctionController {
    @Autowired
    private SubFunctionService subFunctionService;

    @GetMapping
    public ResponseEntity<List<SubMenuFunctionDTO.FullDTO>> getAllSub(@RequestParam(defaultValue = "vi") String lang) {
        return ResponseEntity.ok(subFunctionService.getAllSub(lang));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubMenuFunctionDTO.FullDTO> getSubById(
            @PathVariable("id") String id,
            @RequestParam(defaultValue = "vi") String lang) {
        
        return subFunctionService.getSub(id, lang)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    public ResponseEntity<List<SubMenuFunctionDTO.FullDTO>> getSubTrueActive(@RequestParam(defaultValue = "vi") String lang) {
        return ResponseEntity.ok(subFunctionService.getSubTrueActive(lang));
    }
}
