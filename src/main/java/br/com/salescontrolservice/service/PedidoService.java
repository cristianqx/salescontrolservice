package br.com.salescontrolservice.service;

import javax.validation.Valid;

import br.com.salescontrolservice.domain.dto.PedidoDTO;
import br.com.salescontrolservice.domain.entity.Pedido;
import br.com.salescontrolservice.exception.BusinessException;

public interface PedidoService {
	
	void cadastrarPedido(@Valid PedidoDTO pedido) throws BusinessException;
	
	void cancelarPedido(@Valid Integer id) throws BusinessException;
	
	Pedido findById(final Integer id) throws BusinessException;
	
	Iterable<Pedido> findAll(final Integer idEstabelecimento);
	
}
