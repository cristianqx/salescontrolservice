package br.com.salescontrolservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name="product")
public class Produto extends AbstractEntity<Long>{

	@NotNull(message = "O nome da peca deve ser preenchido")
	@Column(name = "desc_product")
	private String descricao;
	
	@NotNull(message = "O valor da peca deve ser preenchido")
	@Column(name = "value_unitary")
	private Double valorUnitario;
	
	@NotNull
	@Column(name = "active")
	private boolean ativo;
	
	public Produto() {
		
	}
	public Produto(String descricao, double valorUnitario, boolean ativo) {
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.ativo = ativo;
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
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
}
