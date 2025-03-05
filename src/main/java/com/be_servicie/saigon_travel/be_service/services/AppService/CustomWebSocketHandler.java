package com.be_servicie.saigon_travel.be_service.services.AppService;


import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class CustomWebSocketHandler extends TextWebSocketHandler {

    private final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String query = session.getUri().getQuery();
        if (query != null && query.contains("sessionId=")) {
            String sessionId = query.replace("sessionId=", "");
            sessions.put(sessionId, session);
            log.info("Connected WebSocket with sessionId: {}", sessionId);
        } else {
            log.error("SessionId not found in URI: {}", session.getUri());
            session.close(CloseStatus.BAD_DATA);
        }
        log.info("WebSocket URI: {}", session.getUri());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("Received message: " + message.getPayload());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.values().removeIf(s -> s.equals(session));
    }

    public void sendMessageToSession(String sessionId, String message) throws Exception {
        WebSocketSession session = sessions.get(sessionId);
        if (session != null && session.isOpen()) {
            session.sendMessage(new TextMessage(message));
            System.out.println(("Message send to " + session));
        }
    }
    
    // public void sendMessageToSessi(String sessionId, String message) throws
    // Exception {
    // WebSocketSession session = sessions.get(sessionId);
    // if (session != null && session.isOpen()) {
    // session.sendMessage(new TextMessage(message));
    // }
    // }
}

