package com.algoriant.userDetail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user_detail")
@JsonIgnoreProperties(ignoreUnknown = true)
public class JwtAuthUser implements UserDetails {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "detail_role",joinColumns =@JoinColumn(name = "username",referencedColumnName = "username"),
            inverseJoinColumns ={@JoinColumn(name = "id_role",referencedColumnName = "role_id")})
    private Set<JwtRole> roles = new HashSet<>();

    public JwtAuthUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static JwtAuthUser toEntity(JwtUserDto jwtUserDto) {
        JwtAuthUser jwtAuthUser = new JwtAuthUser();
        jwtAuthUser.setUsername(jwtUserDto.getUsername());
        jwtAuthUser.setRoles(jwtUserDto.getRoles());
        jwtAuthUser.setPassword(jwtUserDto.getPassword());
        return jwtAuthUser;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (JwtRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }

    public Set<JwtRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<JwtRole> roles) {
        this.roles = roles;
    }

    public void addRole(JwtRole role) {
        this.roles.add(role);
    }
}
