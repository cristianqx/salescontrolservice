package br.com.salescontrolservice.service;

import javax.validation.Valid;

import br.com.salescontrolservice.domain.entity.Produto;
import br.com.salescontrolservice.exception.ProdutoNotFoundException;

public interface ProdutoService {

	void cadastrarProduto(@Valid Produto produto);
	
	Produto findById(final Long id) throws ProdutoNotFoundException;
}
