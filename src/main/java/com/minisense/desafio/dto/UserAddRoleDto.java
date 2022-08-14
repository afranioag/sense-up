package com.minisense.desafio.dto;

import java.io.Serializable;

public class UserAddRoleDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long roleId;
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
