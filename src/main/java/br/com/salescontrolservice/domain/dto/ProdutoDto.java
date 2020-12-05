package br.com.salescontrolservice.domain.dto;

import java.util.List;

import javax.persistence.Convert;

import br.com.salescontrolservice.domain.converter.StatusConverter;
import br.com.salescontrolservice.domain.entity.Estabelecimento;
import br.com.salescontrolservice.enumeration.StatusEnum;

public class ProdutoDto {

	private Integer id;
	private String descricao;
	private Double valor;
	
	//@Convert(converter = StatusConverter.class)
	private StatusEnum status;
	
    private List<Estabelecimento> estabelecimento;

	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public StatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public List<Estabelecimento> getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(List<Estabelecimento> estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
}
