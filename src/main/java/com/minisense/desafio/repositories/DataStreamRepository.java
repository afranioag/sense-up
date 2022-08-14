package com.minisense.desafio.repositories;

import com.minisense.desafio.entities.DataStream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataStreamRepository extends JpaRepository<DataStream, Long>{

}
