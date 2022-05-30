package com.thabcode.mapper;

import org.springframework.stereotype.Component;

import com.thabcode.dto.ClienteDTO;
import com.thabcode.entities.Cliente;

@Component
public class ClienteMapper {
	public Cliente toEntity(ClienteDTO dto) {
		return Cliente.builder()
				.id(dto.getId())
				.cpf(null)
				.nomeCompleto(dto.getNomeCompleto())
				.dataNascimento(dto.getDataNascimento())
				.tipo(dto.getTipo())
				.email(dto.getEmail())
				.telefone(dto.getTelefone())
				.build();
				
	}
	
	public ClienteDTO toDTO(Cliente cliente) {
		return ClienteDTO.builder()
				.id(cliente.getId())
				.cpf(cliente.getCpf())
				.nomeCompleto(cliente.getNomeCompleto())
				.dataNascimento(cliente.getDataNascimento())
				.tipo(cliente.getTipo())
				.email(cliente.getEmail())
				.telefone(cliente.getTelefone())
				.build();
	}

}
