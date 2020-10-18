package br.com.salescontrolservice.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private ItemPedidoPK itemPedidoPK;

    @Column(name = "quantidade", length = 11)
    private Integer quantidade;

    @JoinColumn(name = "id_pedido", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    @JoinColumn(name = "id_produto", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonManagedReference
    @ManyToOne(optional = false)
    private Produto produto;

    public ItemPedido(ItemPedidoPK itemPedidoPK) {
        this.itemPedidoPK = itemPedidoPK;
    }

    public ItemPedido() {
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

    
    public ItemPedidoPK getItemPedidoPK() {
		return itemPedidoPK;
	}

	public void setItemPedidoPK(ItemPedidoPK itemPedidoPK) {
		this.itemPedidoPK = itemPedidoPK;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido)) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(getItemPedidoPK(), that.getItemPedidoPK()) &&
                Objects.equals(getQuantidade(), that.getQuantidade()) &&
                Objects.equals(getPedido(), that.getPedido()) &&
                Objects.equals(getProduto(), that.getProduto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemPedidoPK(), getQuantidade(), getPedido(), getProduto());
    }

    @Override
    public String toString() {
        return "ItemDoPedido{" +
                "itemDoPedidoPK=" + itemPedidoPK +
                ", qtdade='" + getQuantidade() + '\'' +
                ", produto=" + produto +
                '}';
    }
}
