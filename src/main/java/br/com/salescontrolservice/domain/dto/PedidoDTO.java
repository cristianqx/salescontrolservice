package br.com.salescontrolservice.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import br.com.salescontrolservice.domain.entity.Estabelecimento;
import br.com.salescontrolservice.enumeration.StatusEnum;
import br.com.salescontrolservice.util.DataUtil;

public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = 3846314520598617471L;
	
	private Integer id;
	private List<ItemPedidoDTO> itens;
	private StatusEnum status;
	private Estabelecimento estabelecimento;
	private LocalDateTime dataVenda;
	private UsuarioDto usuarioLogado;
	private String data;
	private String hora;
	
	public PedidoDTO(StatusEnum status, Estabelecimento estabelecimento, List<ItemPedidoDTO> itens, LocalDateTime dataVenda) {
		super();
		this.status = status;
		this.data = DataUtil.convertLocalDateTimeToDate(dataVenda);
		this.hora = DataUtil.convertLocalDateTimeToTime(dataVenda);
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

	public List<ItemPedidoDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoDTO> itens) {
		this.itens = itens;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
