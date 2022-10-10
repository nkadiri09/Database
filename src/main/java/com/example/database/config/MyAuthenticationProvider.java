package com.example.database.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        Object credentials = authentication.getCredentials();
        if ((userName != null && userName.equals("nkadiri"))
                && (credentials != null && credentials.equals("NAREN@ram5*"))) {
            return new UsernamePasswordAuthenticationToken(userName, credentials, Collections.emptyList());
        } else {
            throw new RuntimeException("Invalid UserName or Password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}