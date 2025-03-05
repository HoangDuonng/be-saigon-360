package com.be_servicie.saigon_travel.be_service.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.Media;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping(path="/api/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @GetMapping("/session")
    public ResponseEntity<Map<String, String>> getSessionId(HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> response = new HashMap<>();

        response.put("sessionId", sessionId);

        return ResponseEntity.ok(response);
    }


    
    
}
