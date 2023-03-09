package com.mazhar.security.provider;

import com.mazhar.security.auth.OtpAuthToken;
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
public class OtpAuthProvider implements AuthenticationProvider {

    @Autowired
    SecretKeyRepo secretKeyRepo;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

       var user = secretKeyRepo.findByUsername(authentication.getName());
       if(user.isPresent())
       {
           return new OtpAuthToken(authentication.getName(),
                   authentication.getCredentials(), Arrays.asList(()->"read"));
       }
       throw new BadCredentialsException("Failed OTP Auth provider");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OtpAuthToken.class.equals(authentication);
    }
}
