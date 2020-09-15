package br.com.salescontrolservice.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.salescontrolservice.domain.entity.Produto;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Override
	public void cadastrarProduto(@Valid Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
