package com.vmware.talentboost.finaltask.networkofgiving.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Service
public class Authentication {
    @Autowired
    private JwtUtil jwtUtil;

    protected boolean checkAuthentication(HttpServletRequest request) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        String JsonWebToken = null;
        // JWT Token is in the form "Bearer token". Remove Bearer word and get
        // only the Token
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            JsonWebToken = requestTokenHeader.substring(7);
        }
        return JsonWebToken != null & jwtUtil.validateToken(JsonWebToken);
    }

    public int getUserID(HttpServletRequest request) {
        String requestTokenHeader = request.getHeader("Authorization");
        String JsonWebToken = null;
        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
            JsonWebToken = requestTokenHeader.substring(7);
        }
        if(JsonWebToken != null) {
            return Integer.parseInt(jwtUtil.getUsernameFromToken(JsonWebToken));
        }
        return -1;
    }
}
