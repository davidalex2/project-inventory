package com.algoriant.userDetail.model;

import java.util.HashSet;
import java.util.Set;

public class JwtResponse<T> {

    private String username;
    private Set<JwtRole> roles = new HashSet<>();
    private String accessToken;

    public JwtResponse() {}

    public JwtResponse(String username, String accessToken,Set<JwtRole> roles) {
        this.username = username;
        this.accessToken = accessToken;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    public Set<JwtRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<JwtRole> roles) {
        this.roles = roles;
    }
}
