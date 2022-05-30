package com.thabcode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thabcode.dto.ClienteDTO;
import com.thabcode.entities.Cliente;
import com.thabcode.mapper.ClienteMapper;
import com.thabcode.repository.ClienteRepository;
import com.thabcode.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	
	
	
	public List<Cliente> findAll() {
		return  clienteRepository.findAll();
		 
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	

	
	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		dto.setId(null);
		return clienteMapper.toDTO(clienteRepository.save(clienteMapper.toEntity(dto)));
	}
	

	public Cliente update(Cliente cliente) {
		
		return clienteRepository.save(cliente);
		
	}
	
	
			public void delete (Long id){
				findById(id);
				
				clienteRepository.deleteById(id);
		}
			
		/*EXEMPLO DO PAGE DO CURSO DO NELIO*/	
	
		/*	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
				
				PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
				
				return clienteRepository.findAll(pageRequest);
	} */
			@Transactional(readOnly = true)
			public Page<ClienteDTO> findPage(Pageable pageable){
				return clienteRepository.findAll(pageable).map(cliente -> clienteMapper.toDTO(cliente));
				
			}

}
