package com.algoriant.userDetail.controller;

import com.algoriant.userDetail.model.JwtRole;
import com.algoriant.userDetail.model.JwtRoleRequest;
import com.algoriant.userDetail.service.JwtRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/roleController")
public class JwtRoleController {

    @Autowired
    private JwtRoleService roleService;

    @PostMapping("/createRole")
    public ResponseEntity<JwtRole> saveRole(@RequestBody JwtRole role) {
        return new ResponseEntity<>(roleService.saveRole(role), HttpStatus.CREATED);
    }
}
