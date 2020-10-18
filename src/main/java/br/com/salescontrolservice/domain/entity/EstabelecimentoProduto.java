package br.com.salescontrolservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="estabelecimento")
public class EstabelecimentoProduto { // extends AbstractEntity<Integer>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Integer id;
	
	@NotNull
	@NotBlank(message = "O nome do estabelecimento deve ser preenchido")
	@Column(name = "nome_estabelecimento")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
