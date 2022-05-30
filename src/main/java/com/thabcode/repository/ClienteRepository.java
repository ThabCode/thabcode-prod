package com.thabcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thabcode.dto.ClienteDTO;
import com.thabcode.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	ClienteDTO save(ClienteDTO cliente);

}
