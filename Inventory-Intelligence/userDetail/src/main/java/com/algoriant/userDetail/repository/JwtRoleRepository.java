package com.algoriant.userDetail.repository;


import com.algoriant.userDetail.model.JwtRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JwtRoleRepository extends JpaRepository<JwtRole, Integer> {
    @Modifying
    @Query(value ="\n" +
            "INSERT INTO roles_detail(role_name,role_desc) \n" +
            "SELECT :role_name,:role_desc " +
            "WHERE NOT EXISTS(select 1 from roles_detail where role_name='role_name')\n",nativeQuery = true)
    void createRole(@Param("role_name")String role_name, @Param("role_desc")String role_desc);

}
