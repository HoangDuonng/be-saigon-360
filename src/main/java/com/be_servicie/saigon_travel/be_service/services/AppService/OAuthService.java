package com.be_servicie.saigon_travel.be_service.services.AppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import com.be_servicie.saigon_travel.be_service.dto.response.OAuth2Token;

@Service
public class OAuthService {
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    public OAuth2Token getOAuth2Tokens(OAuth2AuthenticationToken authenticationToken) {
        String clientRegistrationId = authenticationToken.getAuthorizedClientRegistrationId();
        String principalName = authenticationToken.getName();
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(clientRegistrationId,
                principalName);

        String accessToken = client.getAccessToken().getTokenValue();
        String refreshToken = client.getRefreshToken() != null ? client.getRefreshToken().getTokenValue() : null;

        return new OAuth2Token(accessToken, refreshToken);
    }
}