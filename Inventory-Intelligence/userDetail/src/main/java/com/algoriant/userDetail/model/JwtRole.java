package com.algoriant.userDetail.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "roles_detail")
public class JwtRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roldeId;
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleName role;
    @Column(name = "role_desc")
    private String roleDesc;
    @ManyToMany(mappedBy = "roles")
    private Set<JwtAuthUser> jwtAuthUserSet =new HashSet<>();

    public JwtRole() {
    }
    public JwtRole(String role) {
        this.role = RoleName.valueOf(role);
    }


    public String getRole() {
        return String.valueOf(role);
    }

    public void setRole(String role) {
        this.role = RoleName.valueOf(role);
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return String.valueOf(this.role);
    }
    public JwtRole toEntity(JwtRoleRequest role){
        this.role = RoleName.valueOf(role.getRole());
        this.roleDesc = role.getDescription();
        return this;
    }

}
