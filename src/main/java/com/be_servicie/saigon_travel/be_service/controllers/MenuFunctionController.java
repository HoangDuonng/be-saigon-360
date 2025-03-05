package com.be_servicie.saigon_travel.be_service.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import com.be_servicie.saigon_travel.be_service.dto.response.MenuFunctionDTO;
import com.be_servicie.saigon_travel.be_service.services.MenuFunctionService;


@RestController
@RequestMapping(path = "/api/menu")
public class MenuFunctionController {

    @Autowired
    private MenuFunctionService menuFunctionService;

    @GetMapping
    public ResponseEntity<List<MenuFunctionDTO>> getAllMenu(
        @RequestParam(defaultValue = "vi") String lang
    ) {
        List<MenuFunctionDTO> menu = menuFunctionService.getAllMenu(lang);
        return ResponseEntity.ok(menu);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuFunctionDTO> getMenuById(
        @PathVariable("id") String id,
        @RequestParam(defaultValue = "vi") String lang
    ) {

        Optional<MenuFunctionDTO> menuOptional = menuFunctionService.getMenuById(id, lang);

        return menuOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    public ResponseEntity<List<MenuFunctionDTO>> getMenuTrueActive(
        @RequestParam(defaultValue = "vi") String lang
    ) {
        List<MenuFunctionDTO> menu = menuFunctionService.getMenuTrueActive(lang);
        return ResponseEntity.ok(menu);
    }
}