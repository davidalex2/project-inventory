package com.algoriant.userDetail.controller;

import com.algoriant.userDetail.model.JwtAuthUser;
import com.algoriant.userDetail.model.JwtUserDto;
import com.algoriant.userDetail.service.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userController")
public class JwtUserController {
    @Autowired
    private JwtUserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<JwtAuthUser> saveUser(@RequestBody JwtUserDto jwtUserDto) {
        return  new ResponseEntity<>(userService.saveUser(jwtUserDto), HttpStatus.CREATED);
    }


}
