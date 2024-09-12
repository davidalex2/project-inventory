package com.algoriant.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles_detail")
public class Role {

    @Id
    @Column(name = "role_name")
    private String role;
    @Column(name = "name")
    private String roleDesc;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
