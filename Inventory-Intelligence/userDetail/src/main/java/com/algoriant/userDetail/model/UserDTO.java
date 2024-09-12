package com.algoriant.userDetail.model;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private int userId;
    private String address;
    private Long phoneNo;
    private String email;
    private String shop;
    private String status;
    private String gender;
    private String name;
    private String site;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static UserDTO toDTO(UserModel userModel) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userModel.getUserId());
        userDTO.setGender(userModel.getGender());
        userDTO.setAge(userModel.getAge());
        userDTO.setName(userModel.getName());
        userDTO.setStatus(userModel.getStatus());
        userDTO.setSite(userModel.getSite());
        userDTO.setShop(userModel.getShop());
        userDTO.setAddress(userModel.getAddress());
        userDTO.setPhoneNo(userModel.getPhoneNo());
        userDTO.setEmail(userModel.getEmail());
        return userDTO;
    }

    public static List<UserDTO> toListDTO(List<UserModel> userModels) {

        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserModel userModel : userModels) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(userModel.getUserId());
            userDTO.setGender(userModel.getGender());
            userDTO.setAge(userModel.getAge());
            userDTO.setName(userModel.getName());
            userDTO.setStatus(userModel.getStatus());
            userDTO.setSite(userModel.getSite());
            userDTO.setShop(userModel.getShop());
            userDTO.setAddress(userModel.getAddress());
            userDTO.setPhoneNo(userModel.getPhoneNo());
            userDTO.setEmail(userModel.getEmail());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

}
