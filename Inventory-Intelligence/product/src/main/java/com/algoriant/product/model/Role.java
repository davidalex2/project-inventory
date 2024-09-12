package com.algoriant.product.model;

import javax.persistence.*;

@Entity
@Table(name = "roles_detail")
public class Role {

    @Id
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    @Column(name = "name")
    private String roleDesc;

    public Role() {
    }

    public Role(String role) {
        this.role = RoleEnum.valueOf(role);
    }

    public String getRole() {
        return String.valueOf(role);
    }

    public void setRole(String role) {
        this.role = RoleEnum.valueOf(role);
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
}
