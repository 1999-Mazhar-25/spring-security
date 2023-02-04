package com.mazhar.security.filter;

import com.mazhar.security.auth.SecretKeyAuthToken;
import com.mazhar.security.auth.UserPasswordAuthToken;
import com.mazhar.security.entity.SecretKey;
import com.mazhar.security.repo.ReceiptManager;
import com.mazhar.security.repo.SecretKeyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@Component
public class UserPasswordAuthFilter extends OncePerRequestFilter {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    SecretKeyRepo secretKeyRepo;

    @Autowired
    ReceiptManager receiptManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String uname = request.getHeader("uname");
        String password = request.getHeader("password");

        String key = request.getHeader("secret-key");

        if(key == null)
        {
            UserPasswordAuthToken a = new UserPasswordAuthToken(uname, password);
            var auth = authenticationManager.authenticate(a);


            SecretKey secretKey = new SecretKey();
            secretKey.setKey(new Random().nextInt(999) * 1000 + "");
            secretKey.setUsername(uname);

            secretKeyRepo.save(secretKey);
        }
        else {
            // through the key
            var auth = authenticationManager.authenticate
                    (new SecretKeyAuthToken(uname,key));

            //store inside db
            String str = UUID.randomUUID().toString();
            receiptManager.add(str);

            // generate a token
            response.setHeader("Authorization", str);
        }




    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest req)
            throws ServletException {
        return !req.getServletPath().equals("/login");
    }


}
