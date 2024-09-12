package com.algoriant.userDetail.model;

public class UserRequest {
    private String address;
    private Long phoneNo;
    private int age;
    private String email;
    private String status;
    private String gender;
    private String site;
    private String name;

    private String shop;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
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

    public static UserRequest toDto(UserModel userModel) {
        UserRequest userRequest = new UserRequest();
        userRequest.setName(userModel.getName());
        userRequest.setStatus(userModel.getStatus());
        userRequest.setAge(userModel.getAge());
        userRequest.setGender(userModel.getGender());
        userRequest.setSite(userModel.getSite());
        userRequest.setShop(userModel.getShop());
        userRequest.setAddress(userModel.getAddress());
        userRequest.setEmail(userModel.getEmail());
        userRequest.setPhoneNo(userModel.getPhoneNo());
        return userRequest;
    }
}
