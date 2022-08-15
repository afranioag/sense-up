package com.minisense.desafio.dto;

import java.io.Serializable;

import com.minisense.desafio.entities.Role;

public class UserRoleResDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String authoriry;
	
	public UserRoleResDto() {}
	
	public UserRoleResDto(Long id, String authoriry) {
		this.id = id;
		this.authoriry = authoriry;
	}
	
	public UserRoleResDto(Role role) {
		this.id = role.getId();
		this.authoriry = role.getAuthority();
	}
	
	public UserRoleResDto(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthoriry() {
		return authoriry;
	}

	public void setAuthoriry(String authoriry) {
		this.authoriry = authoriry;
	}

}
