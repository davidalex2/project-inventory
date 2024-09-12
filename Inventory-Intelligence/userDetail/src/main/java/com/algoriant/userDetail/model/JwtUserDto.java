package com.algoriant.userDetail.model;

import java.util.HashSet;
import java.util.Set;

public class JwtUserDto {

    private String username;
    private Set<JwtRole> roles = new HashSet<>();
    private  String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<JwtRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<JwtRole> roles)
    {
        this.roles = roles;
    }
    public static JwtUserDto toDto(JwtAuthUser user){
        JwtUserDto jwtUserDto = new JwtUserDto();
        jwtUserDto.setUsername(user.getUsername());
        jwtUserDto.setRoles(user.getRoles());
        jwtUserDto.setPassword(user.getPassword());
        return jwtUserDto;
    }
}
