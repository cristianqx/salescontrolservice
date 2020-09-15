package br.com.salescontrolservice.domain.entity;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name="sale")
public class Venda extends AbstractEntity<Long>{


	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto")
	private List<Produto> produtos;


	public Venda(List<Produto> venda) {
		this.produtos = venda;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
