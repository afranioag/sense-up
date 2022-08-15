package com.minisense.desafio.dto;

import javax.validation.constraints.Positive;
import java.io.Serializable;

public class UserRoleDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Positive
    private Long roleId;
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
