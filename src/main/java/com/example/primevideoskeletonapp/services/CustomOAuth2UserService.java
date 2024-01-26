package com.example.primevideoskeletonapp.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User delegate = new DefaultOAuth2User(getAuthorities(), userRequest.getAccessToken().getAttributes(), "sub");

        // You can extract additional information from userRequest and delegate to customize loading user details

        return new CustomOAuth2User(delegate);
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        // Define your authorities if needed
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    private static class CustomOAuth2User extends DefaultOAuth2User {
        private CustomOAuth2User(OAuth2User delegate) {
            super(delegate.getAuthorities(), delegate.getAttributes(), delegate.getNameAttributeKey());
        }
    }
}