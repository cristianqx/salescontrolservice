package br.com.salescontrolservice.service;

import java.util.List;

import javax.validation.Valid;

import br.com.salescontrolservice.domain.dto.ProdutoDto;
import br.com.salescontrolservice.domain.entity.Produto;
import br.com.salescontrolservice.exception.BusinessException;

public interface ProdutoService {

	void cadastrarProduto(@Valid ProdutoDto produto) throws BusinessException;
	
	void atualizarProduto(@Valid ProdutoDto produto, @Valid Long id) throws BusinessException;
	
	void deleteProduto(@Valid Long id) throws BusinessException;
	
	Produto findById(final Long id) throws BusinessException;
	
	Iterable<Produto> findAll();
}
