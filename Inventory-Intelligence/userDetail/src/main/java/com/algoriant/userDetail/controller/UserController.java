package com.algoriant.userDetail.controller;

import com.algoriant.userDetail.model.UserModel;
import com.algoriant.userDetail.model.UserRequest;
import com.algoriant.userDetail.service.UserSerivceWithQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserSerivceWithQuery userSerivceWithQuery;

    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN','CUSTOMER_ADMIN','STOCK_MANAGER')")
    @PostMapping("/createUser/{username}")
    public ResponseEntity<UserModel> createUserQuery(@RequestBody UserRequest userRequest,@PathVariable("username") String username) {
        return new ResponseEntity<>(userSerivceWithQuery.createUser(username, userRequest),HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER','STOCK_ASSOCIATE')")
    @GetMapping("/getById/{id}")
    public ResponseEntity<UserModel> getByIdQuery(@PathVariable("id") int id) {
        return new ResponseEntity<>(userSerivceWithQuery.findById(id), HttpStatus.OK);

    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN','STOCK_MANAGER','STOCK_ASSOCIATE')")
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserModel>> getAllUsersQuery() {
        List<UserModel> userModels = userSerivceWithQuery.findAll();
        return new ResponseEntity<>(userModels, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN','CUSTOMER_ADMIN','STOCK_MANAGER')")
    @DeleteMapping("/removeById/{id}")
    public ResponseEntity<Integer> deleteByIdQuery(@PathVariable("id") int id) {
        userSerivceWithQuery.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN','CUSTOMER_ADMIN','STOCK_MANAGER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<UserModel> updateByIdQuery(@PathVariable("id") int id, @RequestBody UserRequest userRequest) {
        UserModel userModel = userSerivceWithQuery.updateById(id,userRequest);
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }
}
