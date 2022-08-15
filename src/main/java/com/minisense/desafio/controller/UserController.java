package com.minisense.desafio.controller;

import java.net.URI;
import java.util.List;

import com.minisense.desafio.dto.UserAddRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.minisense.desafio.dto.UserDto;
import com.minisense.desafio.dto.UserInsertDto;
import com.minisense.desafio.services.UserService;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<UserDto> insert(@RequestBody UserInsertDto insertDto) {
		UserDto dto = userService.save(insertDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll(){
		return ResponseEntity.ok().body(userService.finalAll());
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDto> update(@PathVariable("id") Long id, @RequestBody UserDto dto) {
		dto = userService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserDto> delete(@PathVariable("id") Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}/roles")
	public ResponseEntity<UserDto> addRole(@PathVariable("id") Long id, @RequestBody UserAddRoleDto dto) {
		UserDto userDto = userService.addRoles(id, dto);
		return ResponseEntity.ok().body(userDto);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}/roles")
	public ResponseEntity<UserAddRoleDto> deleteRole(@PathVariable("id") Long id, @RequestBody UserAddRoleDto dto) {
		userService.removeRoles(id, dto);
		return ResponseEntity.noContent().build();
	}
}
