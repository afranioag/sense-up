package com.minisense.desafio.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class UserRoleDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long roleId;
    @NotBlank(message = "Role not empty")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
