package com.algoriant.userDetail.model;

import com.algoriant.userDetail.repository.UserRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class UserModel {
    @Transient
    @Autowired
    private UserRepository userRepository;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private int userId;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "status")
    private String status;
    @Column(name = "site")
    private String site;
    @Column(name = "shop")
    private String shop;
    @Column(name = "p_no")
    private Long phoneNo;
    @Column(name = "email")
    private String email;

    public UserModel() {
    }


    public UserModel(String name, String address, int age, String gender, String status,String shop, String site,
                     Long phoneNo, String email
    ) {

        this.name = name;
        this.gender = gender;
        this.site = site;
        this.age = age;
        this.status = status;
        this.address = address;
        this.phoneNo = phoneNo;
        this.shop = shop;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "user {" + "userId = " + userId +
                ", name = " + name +
                ", gender = " + gender +
                ", status = " + status +
                ", age = " + age +
                ",status = " + status +
                ",shop = " + shop +
                ", site = " + site +
                ", address = " + address +
                ", phoneNo = " + phoneNo +
                ", email = " + email + "}";
    }

    public static UserModel toEntity(UserRequest customerRequest) {

        UserModel userModel = new UserModel();
        userModel.setGender(customerRequest.getGender());
        userModel.setAge(customerRequest.getAge());
        userModel.setName(customerRequest.getName());
        userModel.setStatus(customerRequest.getStatus());
        userModel.setShop(customerRequest.getShop());
        userModel.setSite(customerRequest.getSite());
        userModel.setAddress(customerRequest.getAddress());
        userModel.setPhoneNo(customerRequest.getPhoneNo());
        userModel.setEmail(customerRequest.getEmail());
        return userModel;
    }
}
