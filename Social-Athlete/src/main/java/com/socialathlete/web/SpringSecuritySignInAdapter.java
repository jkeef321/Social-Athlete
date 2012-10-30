package com.socialathlete.web;

import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Service
public class SpringSecuritySignInAdapter implements SignInAdapter {
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken(localUserId, null, null));
        return null;
    }
}
