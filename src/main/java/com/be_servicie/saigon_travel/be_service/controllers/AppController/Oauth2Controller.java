package com.be_servicie.saigon_travel.be_service.controllers.AppController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.be_servicie.saigon_travel.be_service.dto.response.OAuth2Token;
import com.be_servicie.saigon_travel.be_service.dto.response.UserDTO;
import com.be_servicie.saigon_travel.be_service.services.AppService.AuthService;
import com.be_servicie.saigon_travel.be_service.services.AppService.CustomWebSocketHandler;
import com.be_servicie.saigon_travel.be_service.services.AppService.Oauth2Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Oauth2Controller {
    @Autowired
    private AuthService authService;

    @Autowired
    private CustomWebSocketHandler webSocketHandler;

    @Autowired
    private Oauth2Service oAuthService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/auth/google")
        public ResponseEntity<?> loginWithGoogle(@RequestParam("sessionId") String sessionId,
                        @AuthenticationPrincipal OAuth2User principal) {
                if (principal == null) {
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                        .body("Please login via Google OAuth2");
                }

                Map<String, Object> userAttributes = principal.getAttributes();

                try {
                        OAuth2AuthenticationToken authenticationToken = (OAuth2AuthenticationToken) SecurityContextHolder
                                        .getContext().getAuthentication();
                        OAuth2Token tokens = oAuthService.getOAuth2Tokens(authenticationToken);

                        UserDTO user = authService.createUserFromGoogle(userAttributes, tokens.getRefreshToken());
                        log.info("check user login: ", user);

                        String mess;
                        if (user == null) {
                                mess = String.format(
                                                "{\"type\":\"login\",\"access_token\":\"%s\", \"refresh_token\":\"%s\", \"user_id\":\"%s\"}",
                                                tokens.getAccessToken(), tokens.getRefreshToken(), null);
                        } else {
                                mess = String.format(
                                                "{\"type\":\"login\",\"access_token\":\"%s\", \"refresh_token\":\"%s\", \"user_id\":\"%s\"}",
                                                tokens.getAccessToken(), tokens.getRefreshToken(), user.getId());
                        }

                        webSocketHandler.sendMessageToSession(sessionId, mess);
                        log.info("Login successfully! With Mess: ", mess);


                        webSocketHandler.sendMessageToSession(sessionId, mess);

                        return ResponseEntity.ok(user);
                } catch (Exception e) {
                        e.printStackTrace();
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                        .body("Error processing user data from Google: " + e.getMessage());
                }
        }

    @PostMapping("/api/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authorizationHeader) {
                String accessToken = authorizationHeader.replace("Bearer ", "");

                revokeGoogleToken(accessToken);

                return ResponseEntity.ok("Logged out successfully");
        }

    private void revokeGoogleToken(String accessToken) {
        String revokeUrl = "https://oauth2.googleapis.com/revoke?token=" + accessToken;

        webClientBuilder.build()
                                .post()
                                .uri(revokeUrl)
                                .retrieve()
                                .bodyToMono(String.class)
                                .doOnTerminate(() -> System.out.println("Token revoked successfully"))
                                .subscribe();
        }
}