package br.com.salescontrolservice.domain.dto;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.salescontrolservice.domain.entity.ItemPedidoPK;
import br.com.salescontrolservice.domain.entity.Pedido;
import br.com.salescontrolservice.domain.entity.Produto;

public class ItemPedidoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @JsonIgnore
	@EmbeddedId
	private ItemPedidoPKDTO id = new ItemPedidoPKDTO();
    private Double desconto;
 	private Integer quantidade;
 	private Double preco;
 	
	public ItemPedidoDTO() {
	}
	
	public ItemPedidoDTO(PedidoDTO pedido, ProdutoDto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	public ProdutoDto getProduto() {
		return id.getProduto();
	}

	public void setProduto(ProdutoDto produto) {
		id.setProduto(produto);
	}
	
	public void setPedido(PedidoDTO pedido) {
		id.setPedido(pedido);
	}
	
	public ItemPedidoPKDTO getId() {
		return id;
	}

	public void setId(ItemPedidoPKDTO id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoDTO other = (ItemPedidoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
