package br.com.salescontrolservice.domain.entity;

import br.com.salescontrolservice.domain.converter.StatusVendasConverter;
import br.com.salescontrolservice.enumeration.StatusVendasEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido extends AbstractEntity<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "status")
	@Convert(converter = StatusVendasConverter.class)
	@NotNull
	private StatusVendasEnum status;
	
	@OneToOne
	@NotNull
	private Estabelecimento estabelecimento;
	
	@OneToMany(mappedBy="id.pedido")
	@NotNull
	private Set<ItemPedido> itens = new HashSet<>();

	@Column(name = "data_venda")
	@NotNull
	private LocalDateTime dataVenda;

	@OneToOne
	@NotNull
	private Usuario usuarioLogado;
	
	public Pedido() {
		
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public StatusVendasEnum getStatus() {
		return status;
	}

	public void setStatus(StatusVendasEnum status) {
		this.status = status;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

}
