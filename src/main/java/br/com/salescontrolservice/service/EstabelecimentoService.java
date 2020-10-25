package br.com.salescontrolservice.service;

import javax.validation.Valid;

import br.com.salescontrolservice.domain.dto.EstabelecimentoDto;
import br.com.salescontrolservice.domain.entity.Estabelecimento;
import br.com.salescontrolservice.exception.BusinessException;

public interface EstabelecimentoService {

	void cadastrarEstabelecimento(@Valid EstabelecimentoDto dto) throws BusinessException;
	
	void atualizarEstabelecimento(@Valid EstabelecimentoDto dto, @Valid Integer id) throws BusinessException;
	
	void deleteEstabelecimento(@Valid Integer id) throws BusinessException;
	
	Estabelecimento findById(final Integer id) throws BusinessException;
	
	Iterable<Estabelecimento> findAll();
}
