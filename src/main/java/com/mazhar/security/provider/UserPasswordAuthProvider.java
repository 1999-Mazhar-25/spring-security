package com.mazhar.security.provider;

import com.mazhar.security.auth.UserPasswordAuthToken;
import com.mazhar.security.service.LoginUserDeatilsServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordAuthProvider implements AuthenticationProvider {

    @Autowired
    LoginUserDeatilsServcie userDeatilsServcie;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication auth)
            throws AuthenticationException {

        var user = userDeatilsServcie.loadUserByUsername(auth.getName());

        if(encoder.matches(auth.getCredentials() + "",user.getPassword()))
        {
            return new UserPasswordAuthToken(user.getUsername(),
                    user.getPassword(),user.getAuthorities());
        }
        else {
            System.out.println(auth.getCredentials().toString());
        }
        throw new BadCredentialsException("Failed to login !!!!");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UserPasswordAuthToken.class.equals(authentication);
    }
}
