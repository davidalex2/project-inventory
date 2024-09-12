package com.algoriant.userDetail.repository;

import com.algoriant.userDetail.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    @Modifying
    @Query(value = "INSERT INTO customer (name, address, age, gender, status,shop, site, p_no, email, u_id)\n" +
            "            SELECT\n" +
            "            :name,\n" +
            "            :address,\n" +
            "            :age,\n" +
            "            :gender,\n" +
            "            :status,\n" +
            "            :shop,\n" +
            "            :site,\n" +
            "            :phoneNo,\n" +
            "            :email,\n" +
            "            (SELECT u_id FROM detail_role WHERE username = :username)", nativeQuery = true)
    public void insertUser(@Param("name") String name, @Param("address") String address, @Param("age") int age,
                           @Param("gender") String gender, @Param("status") String status,
                           @Param("shop") String shop, @Param("site") String site, @Param("phoneNo") Long phoneNo,
                           @Param("email") String email, @Param("username") String username);


    @Query(value = "SELECT * FROM customer WHERE name IS NOT NULL AND u_id IS NOT NULL order by u_id", nativeQuery = true)
    List<UserModel> getAllQuery();

    @Query(value = "SELECT * FROM customer WHERE customer.u_id= :userId", nativeQuery = true)
    UserModel getById(@Param("userId") int userId);

    @Modifying
    @Query(value = "DELETE FROM customer WHERE customer.u_id= :userId", nativeQuery = true)
    void deleteUser(@Param("userId") int userId);

    @Modifying
    @Query(value = "UPDATE customer SET name = :name, address = :address, age = :age, gender = :gender, " +
            "status = :status,shop = :shop, site = :site, " +
            "p_no = :phoneNo, email = :email " +
            "WHERE u_id = :userId", nativeQuery = true)
    void updateById(@Param("userId") int userId, @Param("name") String name, @Param("address") String address,
                    @Param("age") int age, @Param("gender") String gender, @Param("status") String status,
                    @Param("shop") String shop, @Param("site") String site,
                    @Param("phoneNo") Long phoneNo, @Param("email") String email);


}

// CREATE DATABASE inventory_db;
//
//CREATE TABLE IF NOT EXISTS user_detail(userName VARCHAR(255) UNIQUE NOT NULL,password VARCHAR(255) NOT NULL);
//
//CREATE TABLE IF NOT EXISTS roles_detail(role_id SERIAL PRIMARY KEY,role_name VARCHAR(255) NOT NULL,role_desc VARCHAR(255) NOT NULL);
//
//CREATE TABLE IF NOT EXISTS detail_role (username varchar(255) unique not null,id_role INT NOT NULL,u_id Serial PRIMARY KEY,
// FOREIGN KEY (username)REFERENCES user_detail(username)
//,FOREIGN KEY (id_role) REFERENCES roles_detail(role_id));
//
//CREATE TABLE IF NOT EXISTS customer(u_id INT UNIQUE NOT NULL ,name VARCHAR(255),address VARCHAR(255),age INT,gender VARCHAR(255),status VARCHAR(255)
// ,shop VARCHAR(255),site VARCHAR(255),p_no NUMERIC CHECK (p_no > 9),email VARCHAR(255),FOREIGN KEY(u_id) REFERENCES detail_role(u_id));
