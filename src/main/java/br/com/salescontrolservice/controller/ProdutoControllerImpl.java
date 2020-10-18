package br.com.salescontrolservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.salescontrolservice.domain.dto.ProdutoDto;
import br.com.salescontrolservice.domain.entity.Produto;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.service.ProdutoService;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/produto")
@RestController
@Valid
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoControllerImpl extends AbstractController {
	
    
    @Autowired
    private ProdutoService produtoService;
    
    @ApiOperation(value = "Cadastra um produto")
	@PostMapping(consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ProdutoDto produtoDto) throws BusinessException {
		produtoService.cadastrarProduto(produtoDto);
	}
	
    
    @ApiOperation(value = "Atualiza um produto específico")
	@PutMapping(value = "{id}", consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody ProdutoDto produtoDto, @PathVariable Integer id) throws BusinessException {
		produtoService.atualizarProduto(produtoDto, id);
	}
	
    @ApiOperation(value = "Retorna dados de um produto pelo id")
	@GetMapping(value = "{id}")
	@ResponseStatus(HttpStatus.OK)
	public Produto findById(@PathVariable final Integer id) throws BusinessException {
		return produtoService.findById(id);	
	}
	
    @ApiOperation(value = "Deleta um um produto")
	@DeleteMapping(value = "{id}", consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) throws BusinessException {
		produtoService.deleteProduto(id);
	}
    
    @ApiOperation(value = "Retorna uma lista de produtos de um determinado estabelecimento")
    @GetMapping(value = "/estabelecimento/{idEstabelecimento}")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Produto> findAll(@PathVariable final Integer idEstabelecimento) throws BusinessException {
		return (produtoService.findAll(idEstabelecimento));
	}
    
}

