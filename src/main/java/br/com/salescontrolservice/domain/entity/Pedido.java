package br.com.salescontrolservice.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pedido")
public class Pedido extends AbstractEntity<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "data_pedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    @JsonBackReference
    private Collection<ItemPedido> itemPedidoCollection;

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Collection<ItemPedido> getItemPedidoCollection() {
		return itemPedidoCollection;
	}

	public void setItemPedidoCollection(Collection<ItemPedido> itemPedidoCollection) {
		this.itemPedidoCollection = itemPedidoCollection;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(getId(), pedido.getId()) &&
                Objects.equals(getDataPedido(), pedido.getDataPedido());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getDataPedido());
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", dataPedido=" + dataPedido +
                ", itemDoPedidoCollection=" + itemPedidoCollection +
                ", cliente=" +
                '}';
    }
}
