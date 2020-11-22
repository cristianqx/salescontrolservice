package br.com.salescontrolservice.domain.dto;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ItemPedidoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @JsonIgnore
	@EmbeddedId
	private ItemPedidoPKDTO id;
    
	private Integer quantidade;
	private PedidoDTO pedido;
	private ProdutoDto produto;
	private Double preco;

	public ItemPedidoDTO() {
		
	}
	
	public ItemPedidoDTO(PedidoDTO pedido, ProdutoDto produto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public ItemPedidoPKDTO getId() {
		return id;
	}

	public void setId(ItemPedidoPKDTO id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@JsonIgnore
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
