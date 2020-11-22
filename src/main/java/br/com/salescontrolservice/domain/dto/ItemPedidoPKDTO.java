package br.com.salescontrolservice.domain.dto;

import java.io.Serializable;

public class ItemPedidoPKDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private PedidoDTO pedido;
	private ProdutoDto produto;
	
	public PedidoDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	public ProdutoDto getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDto produto) {
		this.produto = produto;
	}
	
	

}
