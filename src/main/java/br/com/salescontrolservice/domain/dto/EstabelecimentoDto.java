package br.com.salescontrolservice.domain.dto;

import br.com.salescontrolservice.enumeration.StatusEnum;

public class EstabelecimentoDto {
	
    private Integer id;
	private String nome;
	private StatusEnum status;

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
	
	public StatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
}
