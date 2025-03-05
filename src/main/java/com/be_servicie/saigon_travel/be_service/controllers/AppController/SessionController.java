package com.be_servicie.saigon_travel.be_service.controllers.AppController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SessionController {
    @GetMapping("/api/guest-session")
    public Map<String, String> generateGuestSession() {
        Map<String, String> response = new HashMap<>();
        response.put("sessionId", UUID.randomUUID().toString());
        return response;
    }
}
