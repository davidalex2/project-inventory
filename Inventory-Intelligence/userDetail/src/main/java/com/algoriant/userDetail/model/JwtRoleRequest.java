package com.algoriant.userDetail.model;

public class JwtRoleRequest {

    private String role;
    private String roleDesc;
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return roleDesc;
    }

    public void setDescription(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    public JwtRoleRequest getRoleRequest(JwtRole role){
        JwtRoleRequest roleRequest = new JwtRoleRequest();
        roleRequest.setRole(role.getRole());
        roleRequest.setDescription(role.getRoleDesc());
        return roleRequest;

    }

}
