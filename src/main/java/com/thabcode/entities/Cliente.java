package com.thabcode.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_cliente")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String cpf;
	private String nomeCompleto;
	
	private LocalDate dataNascimento;
	private Integer tipo;
	private String email;
	private String  telefone;
	
	@CreatedDate
	private Instant criadoEm;
	
	

}
