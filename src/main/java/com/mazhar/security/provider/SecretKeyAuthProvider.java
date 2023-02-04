package com.mazhar.security.provider;

import com.mazhar.security.auth.SecretKeyAuthToken;
import com.mazhar.security.auth.UserPasswordAuthToken;
import com.mazhar.security.repo.SecretKeyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SecretKeyAuthProvider implements AuthenticationProvider {

    @Autowired
    SecretKeyRepo secretKeyRepo;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

       var user = secretKeyRepo.findByUsername(authentication.getName());
       if(user.isPresent())
       {
           return new SecretKeyAuthToken(authentication.getName(),
                   authentication.getCredentials(), Arrays.asList(()->"read"));
       }
       throw new BadCredentialsException("Failed OTP Auth provider");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SecretKeyAuthToken.class.equals(authentication);
    }
}
