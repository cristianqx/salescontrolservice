package br.com.salescontrolservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.salescontrolservice.domain.dto.ProdutoDto;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.exception.ProdutoNotFoundException;
import br.com.salescontrolservice.service.ProdutoService;

@RequestMapping("/produto")
@RestController
@Valid
public class ProdutoControllerImpl extends AbstractController {
	
    
    @Autowired
    private ProdutoService produtoService;
    
	@PostMapping(consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ProdutoDto produtoDto) throws BusinessException {
		produtoService.cadastrarProduto(produtoDto);
	}
	
	@GetMapping(value = "{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProdutoDto findById(@PathVariable final Long id) throws ProdutoNotFoundException {
		return convertToDTO(produtoService.findById(id), ProdutoDto.class);	
	}
	
}

