package com.minisense.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minisense.desafio.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
