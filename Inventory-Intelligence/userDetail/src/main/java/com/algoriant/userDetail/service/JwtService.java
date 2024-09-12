package com.algoriant.userDetail.service;

import com.algoriant.userDetail.jwtUtil.JwtTokenUtil;
import com.algoriant.userDetail.model.JwtAuthUser;
import com.algoriant.userDetail.model.JwtRequest;
import com.algoriant.userDetail.model.JwtResponse;
import com.algoriant.userDetail.repository.JwtAuthUserRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class JwtService {

    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtAuthUserRepository jwtAuthUserRepository;
    @Autowired
    JwtTokenUtil jwtUtil;


    public JwtResponse login(JwtRequest jwtRequest) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
        JwtAuthUser user = (JwtAuthUser) authentication.getPrincipal();
        String accessToken = jwtUtil.generateAccessToken(user);

        return new JwtResponse();
    }

    public String validateToken(String token) {
        Boolean validated = jwtUtil.validateAccessToken(token);
        if (validated == true) {
            return "Validate Token!";
        }
        return "Invalid Token!";
    }

    public Claims parseClaim(String token) {
        return jwtUtil.parseClaims(token);
    }
}
