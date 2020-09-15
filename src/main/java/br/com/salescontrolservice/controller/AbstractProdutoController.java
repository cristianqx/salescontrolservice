package br.com.salescontrolservice.controller;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.salescontrolservice.domain.dto.ProdutoDto;
import br.com.salescontrolservice.domain.entity.Produto;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.service.ProdutoService;

public abstract class AbstractProdutoController {

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private ProdutoService service;
    
	@SuppressWarnings("unused")
	public ProdutoDto convertToDto(Produto produto) {
		ProdutoDto postDto = modelMapper.map(produto, ProdutoDto.class);
	    return postDto;
	}
	
	@SuppressWarnings("unused")
	public Produto convertToEntity(ProdutoDto produtoDto) throws BusinessException {
		Produto produto = modelMapper.map(produtoDto, Produto.class);
	    
	    if (Objects.nonNull(produtoDto.getId())) {
	    	Produto produtoAntigo = service.findById(produtoDto.getId());
	    	produto.setId(produto.getId());
	    	produto.setAtivo(produtoAntigo.isAtivo());
	    	produto.setDescricao(produtoAntigo.getDescricao());
	    	produto.setValorUnitario(produtoAntigo.getValorUnitario());
	    }
	    
	    return produto;
	}
}
