package com.be_servicie.saigon_travel.be_service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
        @Value("${custom.port.client}")
        private String client;

        @Autowired
        private OAuth2AuthorizedClientService authorizedClientService;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http,
                        ClientRegistrationRepository clientRegistrationRepository) throws Exception {

                http
                                .headers(headers -> headers
                                                .defaultsDisabled()
                                                .cacheControl(cache -> cache.disable())
                                                .contentTypeOptions(contentType -> contentType.disable())
                                                .httpStrictTransportSecurity(hsts -> hsts.disable())
                                                .frameOptions(frame -> frame.sameOrigin())
                                                .addHeaderWriter((request, response) -> {
                                                        response.setHeader("Cross-Origin-Opener-Policy", "same-origin");
                                                }))
                                .csrf(csrf -> csrf.disable()) // Disable CSRF
                                .authorizeHttpRequests(authz -> authz
                                                .requestMatchers("/ws").permitAll() // Bỏ qua WebSocket
                                                .requestMatchers("/api/users/", "/api/history/")
                                                .authenticated()
                                                .anyRequest().permitAll())
                                .oauth2Login(oauth2 -> oauth2
                                                .authorizationEndpoint(authorizationEndpoint -> authorizationEndpoint
                                                                .authorizationRequestResolver(
                                                                                new CustomAuthorizationRequestResolver(
                                                                                                new DefaultOAuth2AuthorizationRequestResolver(
                                                                                                                clientRegistrationRepository,
                                                                                                                "/oauth2/authorization"))))
                                                .successHandler((request, response, authentication) -> {
                                                        OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) authentication;
                                                        OAuth2AuthorizedClient authorizedClient = authorizedClientService
                                                                        .loadAuthorizedClient(authToken
                                                                                        .getAuthorizedClientRegistrationId(),
                                                                                        authToken.getName());

                                                        if (authorizedClient != null) {
                                                                OAuth2AccessToken accessToken = authorizedClient
                                                                                .getAccessToken();
                                                                log.info("Access Token: {}",
                                                                                accessToken.getTokenValue());
                                                                log.info("Refresh Token: {}", authorizedClient
                                                                                .getRefreshToken().getTokenValue());
                                                        }

                                                        response.sendRedirect(client + "/en");
                                                }));

                return http.build();
        }

}