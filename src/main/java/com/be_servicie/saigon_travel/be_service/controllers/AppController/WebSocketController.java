package com.be_servicie.saigon_travel.be_service.controllers.AppController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.be_servicie.saigon_travel.be_service.services.AppService.CustomWebSocketHandler;

@RestController
public class WebSocketController {

    @Autowired
    private final CustomWebSocketHandler webSocketHandler;

    public WebSocketController(CustomWebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    @GetMapping("/send-message")
    public String sendMessage(@RequestParam String sessionId, @RequestParam String message) {
        try {
            webSocketHandler.sendMessageToSession(sessionId, message);
            return "Message sent to session: " + sessionId;
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send message";
        }
    }

}
