package br.com.salescontrolservice.controller;


import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import br.com.salescontrolservice.domain.dto.ProdutoDto;
import br.com.salescontrolservice.domain.entity.Produto;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.service.ProdutoService;

@RestController
public class ProdutoController {
	
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private ProdutoService produtoService;
    
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ProdutoDto produtoDto) throws BusinessException {
		produtoService.cadastrarProduto(convertToEntity(produtoDto));
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ProdutoDto findById(@PathVariable final Long id) {
		return convertToDto(produtoService.findById(id));	
	}
	
	private ProdutoDto convertToDto(Produto produto) {
		ProdutoDto postDto = modelMapper.map(produto, ProdutoDto.class);
	    return postDto;
	}
	
	private Produto convertToEntity(ProdutoDto produtoDto) throws BusinessException {
		Produto produto = modelMapper.map(produtoDto, Produto.class);
	    
	    if (produtoDto.getId() != null) {
	    	Produto produtoAntigo = produtoService.findById(produtoDto.getId());
	    	produto.setAtivo(produtoAntigo.isAtivo());
	    	produto.setDescricao(produtoAntigo.getDescricao());
	    	produto.setValorUnitario(produtoAntigo.getValorUnitario());
	    }
	    
	    return produto;
	}
}

