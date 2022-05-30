package com.thabcode.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thabcode.dto.ClienteDTO;
import com.thabcode.entities.Cliente;
import com.thabcode.service.ClienteService;

@RestController
@RequestMapping(path = "clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> findPage(Pageable pageable){
		return ResponseEntity.ok(clienteService.findPage(pageable));
		
	}
	
	
	/* Forma simples de buscar todos os clientes
		@GetMapping
		public List<Cliente> findAll(){
			return clienteService.findAll();
		}
	*/
	
	/*Forma mais complexa   Falta ajustar o DTO
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> findAll() {
		
			List<Cliente> list = clienteService.findAll();
			
			List<ClienteDTO> listDTO = list
					.stream()
					.map(obj -> new ClienteDTO(obj))
					.collect(Collectors.toList());
			
			return ResponseEntity.ok().body(listDTO);
			
		}
		
		*/
		
	/*	
	
	@RequestMapping(path = "page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> findPages(
			
			@RequestParam(value="page", defaultValue= "0")  Integer page, 

			@RequestParam(value="linesPerPage", defaultValue= "10") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue= "nomeCompleto") String orderBy,
			@RequestParam(value="direction", defaultValue= "ASC")  String direction 
			
			
			) {
		
		
		
			List<Cliente> list = clienteService.findAll();
			
			List<ClienteDTO> listDTO = list
					.stream()
					.map(obj -> new ClienteDTO(obj))
					.collect(Collectors.toList());
			
			return ResponseEntity.ok().body(listDTO);
			
		}
	
	*/
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		
		Cliente obj = clienteService.findById(id);
		
		return ResponseEntity.ok().body(obj);
		 
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<ClienteDTO> insert(@Valid @RequestBody ClienteDTO dto) {
		
		dto = clienteService.insert(dto);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(dto.getId())
					.toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	

	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update( @RequestBody Cliente obj, @PathVariable Long id) {
		obj.setId(id);
		
		obj = clienteService.update(obj); 
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		clienteService.delete(id); 
		
		return ResponseEntity.noContent().build();
	}
	


	

}
