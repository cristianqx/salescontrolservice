package br.com.salescontrolservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.salescontrolservice.domain.dto.EstabelecimentoDto;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.service.EstabelecimentoService;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/estabelecimento")
@RestController
@Valid
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstabelecimentoControllerImpl extends AbstractController {
	
    @Autowired
    private EstabelecimentoService estabelecimentoService;
    
    @ApiOperation(value = "Cadastra um estabelecimento")
	@PostMapping(consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody EstabelecimentoDto dto) throws BusinessException {
    	estabelecimentoService.cadastrarEstabelecimento(dto);
	}
	
    
    @ApiOperation(value = "Atualiza dados de um estabelecimento específico")
	@PutMapping(value = "{id}", consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody EstabelecimentoDto dto, @PathVariable Integer id) throws BusinessException {
    	estabelecimentoService.atualizarEstabelecimento(dto, id);
	}
	
    @ApiOperation(value = "Retorna dados de um estabelecimento pelo id")
	@GetMapping(value = "{id}")
	@ResponseStatus(HttpStatus.OK)
	public EstabelecimentoDto findById(@PathVariable final Integer id) throws BusinessException {
		return convertToDTO(estabelecimentoService.findById(id), EstabelecimentoDto.class);	
	}
	
    @ApiOperation(value = "Deleta um um estabelecimento")
	@DeleteMapping(value = "{id}", consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) throws BusinessException {
    	estabelecimentoService.deleteEstabelecimento(id);
	}
    
    @ApiOperation(value = "Retorna uma lista de estabelecimento")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<EstabelecimentoDto> findAll() throws BusinessException {
		return convertToDTO(estabelecimentoService.findAll(), EstabelecimentoDto.class);
	}
    
}

