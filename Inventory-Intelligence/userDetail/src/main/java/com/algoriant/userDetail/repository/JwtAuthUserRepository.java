package com.algoriant.userDetail.repository;

import com.algoriant.userDetail.model.JwtAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JwtAuthUserRepository extends JpaRepository<JwtAuthUser, Integer> {

    @Query(value = "SELECT\n" +
            "    username,\n" +
            "(SELECT password FROM user_detail WHERE username=:username),\n" +
            "    (SELECT role_name \n" +
            "     FROM roles_detail AS r \n" +
            "     WHERE d.id_role = r.role_id) AS role_name\n" +
            "FROM detail_role AS d \n" +
            "WHERE username = :username", nativeQuery = true)
    Optional<JwtAuthUser> findByUsername(@Param("username") String username);

    @Modifying
    @Query(value = "\n" +
            "INSERT INTO detail_role (username, id_role)\n" +
            "SELECT \n" +
            "    (SELECT username FROM user_detail WHERE username = :username) as username,\n" +
            "    (SELECT role_id FROM roles_detail WHERE role_name = :roleName LIMIT 1) as id_role " +
            "WHERE NOT EXISTS (SELECT username FROM detail_role WHERE username = :username);\n", nativeQuery = true)
    void insertUsernameRelation(@Param("username") String username, @Param("roleName") String role);

    @Modifying
    @Query(value = "INSERT INTO user_detail SELECT :username,:password" +
            " WHERE NOT EXISTS (SELECT username FROM user_detail WHERE username=:username)", nativeQuery = true)
    void insertUser(@Param("username") String username, @Param("password") String password);

}
