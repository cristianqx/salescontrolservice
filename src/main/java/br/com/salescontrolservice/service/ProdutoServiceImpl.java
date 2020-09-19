package br.com.salescontrolservice.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salescontrolservice.domain.dto.ProdutoDto;
import br.com.salescontrolservice.domain.entity.Produto;
import br.com.salescontrolservice.exception.ProdutoNotFoundException;
import br.com.salescontrolservice.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void cadastrarProduto(@Valid ProdutoDto dto) {
		Produto entity = modelMapper.map(dto, Produto.class);
		produtoRepository.save(entity);
	}

	@Override
	public Produto findById(Long id) throws ProdutoNotFoundException {
		return produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
	}

}
