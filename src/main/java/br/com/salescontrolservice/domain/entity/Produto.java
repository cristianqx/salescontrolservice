package br.com.salescontrolservice.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.salescontrolservice.domain.converter.StatusConverter;
import br.com.salescontrolservice.enumeration.StatusEnum;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Length(max = 45)
    @Column(name = "descricao", length = 45, nullable = false)
    private String descricao;
    
    @NotNull(message = "O valor deve ser preenchido")
	@Column(name = "valor_unitario")
	private Double valor;
    
    @Column(name = "status")
	@Convert(converter = StatusConverter.class)
	private StatusEnum status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    @JsonBackReference
    private Collection<ItemPedido> itemDoPedidoCollection;
    
    @ManyToOne
    private Estabelecimento estabelecimento;
    
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

    public Collection<ItemPedido> getItemDoPedidoCollection() {
        return itemDoPedidoCollection;
    }

    public void setItemDoPedidoCollection(Collection<ItemPedido> itemDoPedidoCollection) {
        this.itemDoPedidoCollection = itemDoPedidoCollection;
    }

    public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", status=" + status
				+ ", estabelecimento=" + estabelecimento + "]";
	}

}
