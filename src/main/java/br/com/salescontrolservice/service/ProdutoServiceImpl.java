package br.com.salescontrolservice.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salescontrolservice.domain.entity.Produto;
import br.com.salescontrolservice.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void cadastrarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public Produto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
