package br.com.salescontrolservice.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="estabelecimento")
public class Estabelecimento implements Serializable { 

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
    private Integer id;
	
	@NotNull
	@NotBlank(message = "O nome do estabelecimento deve ser preenchido")
	@Column(name = "nome_estabelecimento")
	private String nome;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
