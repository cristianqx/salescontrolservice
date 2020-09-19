package br.com.salescontrolservice.domain.dto;

import javax.persistence.Convert;

import br.com.salescontrolservice.enumeration.StatusEnum;

public class ProdutoDto {

	private Long id;
	private String descricao;
	private Double valorUnitario;
	private StatusEnum status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
}
