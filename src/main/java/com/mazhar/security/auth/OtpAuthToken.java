package com.mazhar.security.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class OtpAuthToken extends UserPasswordAuthToken {

    public OtpAuthToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public OtpAuthToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
