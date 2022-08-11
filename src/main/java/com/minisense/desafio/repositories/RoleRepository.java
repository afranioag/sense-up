package com.minisense.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minisense.desafio.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
