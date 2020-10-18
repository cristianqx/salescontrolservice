package br.com.salescontrolservice.service;

import javax.validation.Valid;

import br.com.salescontrolservice.domain.dto.ProdutoDto;
import br.com.salescontrolservice.domain.entity.Produto;
import br.com.salescontrolservice.exception.BusinessException;

public interface ProdutoService {

	void cadastrarProduto(@Valid ProdutoDto produto) throws BusinessException;
	
	void atualizarProduto(@Valid ProdutoDto produto, @Valid Integer id) throws BusinessException;
	
	void deleteProduto(@Valid Integer id) throws BusinessException;
	
	Produto findById(final Integer id) throws BusinessException;
	
	Iterable<Produto> findAll(final Integer idEstabelecimento);
}
