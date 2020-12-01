package br.com.salescontrolservice.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import br.com.salescontrolservice.enumeration.StatusVendasEnum;

public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = 3846314520598617471L;
	
	private Integer id;
	private Set<ItemPedidoDTO> itens;
	private StatusVendasEnum status;
	private EstabelecimentoDto estabelecimento;
	private LocalDateTime dataVenda;
	private UsuarioDto usuarioLogado;

	public PedidoDTO() {
	}
	
	public PedidoDTO(StatusVendasEnum status, EstabelecimentoDto estabelecimento, Set<ItemPedidoDTO> itens, LocalDateTime dataVenda) {
		super();
		this.status = status;
		this.estabelecimento = estabelecimento;
		this.itens = itens;
		this.dataVenda = dataVenda;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioDto getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioDto usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Set<ItemPedidoDTO> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedidoDTO> itens) {
		this.itens = itens;
	}

	public StatusVendasEnum getStatus() {
		return status;
	}

	public void setStatus(StatusVendasEnum status) {
		this.status = status;
	}

	public EstabelecimentoDto getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(EstabelecimentoDto estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
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
		PedidoDTO other = (PedidoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

