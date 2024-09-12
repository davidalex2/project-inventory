package com.algoriant.userDetail.service;

import com.algoriant.userDetail.model.JwtRole;
import com.algoriant.userDetail.repository.JwtRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class JwtRoleService {

    @Autowired
    private JwtRoleRepository roleRepository;

    @Transactional
    public JwtRole saveRole(JwtRole role) {
         roleRepository.createRole(role.getRole(),role.getRoleDesc());
//         return roleRepository.checkRole(role.getRole(), role.getRoleDesc());
        return role;
    }
}
