package com.thabcode.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotEmpty(message ="Preenchimento obrigatorio")
	@Length(min=11, max=11, message= "Preencher com os 11 digitos do cpf")
	private String cpf;
	
	@NotEmpty(message ="Preenchimento obrigatorio")
	@Length(min=5, max=80, message= "Minimo 5 maximo 80")
	private String nomeCompleto;
	
	private LocalDate dataNascimento;
	private Integer tipo;
	private String email;
	private String  telefone;
	
	
	/*public ClienteDTO(Cliente obj){
		id = obj.getId();
		cpf = obj.getCpf();
		nomeCompleto = obj.getNomeCompleto();
	}*/	
}
