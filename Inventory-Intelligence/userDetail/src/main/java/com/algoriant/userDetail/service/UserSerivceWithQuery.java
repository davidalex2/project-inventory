package com.algoriant.userDetail.service;

import com.algoriant.userDetail.jwtUtil.JwtRequestFilter;
import com.algoriant.userDetail.model.UserModel;
import com.algoriant.userDetail.model.UserRequest;
import com.algoriant.userDetail.repository.JwtAuthUserRepository;
import com.algoriant.userDetail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserSerivceWithQuery {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtAuthUserRepository jwtAuthUserRepository;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Transactional
    public UserModel createUser(String username,UserRequest userRequest) {

        userRepository.insertUser(userRequest.getName(), userRequest.getAddress(), userRequest.getAge(), userRequest.getGender(), userRequest.getStatus(),userRequest.getShop(), userRequest.getSite(), userRequest.getPhoneNo(), userRequest.getEmail(),username);
      return UserModel.toEntity(userRequest);
    }

    public List<UserModel> findAll() {
        return userRepository.getAllQuery();
    }

    public UserModel findById(int userId) {
        return userRepository.getById(userId);
    }

    public void removeById(int id) {
        userRepository.deleteUser(id);
    }

    public UserModel updateById(int id, UserRequest userRequest) {
        userRepository.updateById(id, userRequest.getName(), userRequest.getAddress(), userRequest.getAge(), userRequest.getGender(), userRequest.getStatus(), userRequest.getShop(), userRequest.getSite(), userRequest.getPhoneNo(), userRequest.getEmail());
   return UserModel.toEntity(userRequest);
    }
}
