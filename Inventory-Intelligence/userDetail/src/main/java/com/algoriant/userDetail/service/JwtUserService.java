package com.algoriant.userDetail.service;

import com.algoriant.userDetail.model.JwtAuthUser;
import com.algoriant.userDetail.model.JwtRole;
import com.algoriant.userDetail.model.JwtUserDto;
import com.algoriant.userDetail.repository.JwtAuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import static com.algoriant.userDetail.model.JwtAuthUser.toEntity;

@Service
public class JwtUserService implements UserDetailsService {

    @Autowired
    private JwtAuthUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        JwtAuthUser jwtAuthUser = new JwtAuthUser();
        Optional<JwtAuthUser> optionalJwtAuthUser = userRepository.findByUsername(userName);
        if(optionalJwtAuthUser.isPresent()){
            jwtAuthUser = optionalJwtAuthUser.get();
        }
        return jwtAuthUser;
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("*"));
    }

    @Transactional
    public JwtAuthUser saveUser(JwtUserDto jwtUserDto) {
        String rawPassword = jwtUserDto.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
        jwtUserDto.setPassword(encodedPassword);
        Set<JwtRole> roles = jwtUserDto.getRoles();
        List<String> myRoles = new ArrayList<String>();
        for (JwtRole role : roles) {
            myRoles.add(role.getRole());
        }
        String roleName = String.join(",", myRoles);
        userRepository.insertUser(jwtUserDto.getUsername(),jwtUserDto.getPassword());
        userRepository.insertUsernameRelation(jwtUserDto.getUsername(), roleName);
//        return userRepository.checkInsertUser(jwtUserDto.getUsername());
        return toEntity(jwtUserDto);
    }
    public void roleFunction(){
        JwtUserDto jwtUserDto = new JwtUserDto();

    }
}