package br.com.salescontrolservice.domain.dto;

import java.io.Serializable;

import br.com.salescontrolservice.domain.entity.Pedido;
import br.com.salescontrolservice.domain.entity.Produto;

public class ItemPedidoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer quantidade;
	private Pedido pedido;
	private Produto produto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
