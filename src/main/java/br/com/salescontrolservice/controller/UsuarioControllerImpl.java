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

import br.com.salescontrolservice.domain.dto.UsuarioDto;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.service.UsuarioService;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/usuario")
@RestController
@Valid
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioControllerImpl extends AbstractController {
	
    @Autowired
    private UsuarioService usuarioService;
    
    @ApiOperation(value = "Cadastra um usuário")
	@PostMapping(consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody UsuarioDto dto) throws BusinessException {
    	usuarioService.cadastrarUsuario(dto);
	}
	
    
    @ApiOperation(value = "Atualiza dados de um usuario específico")
	@PutMapping(value = "{id}", consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody UsuarioDto dto, @PathVariable Long id) throws BusinessException {
    	usuarioService.atualizarUsuario(dto, id);
	}
	
    @ApiOperation(value = "Retorna dados de um usuario pelo id")
	@GetMapping(value = "{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioDto findById(@PathVariable final Long id) throws BusinessException {
		return convertToDTO(usuarioService.findById(id), UsuarioDto.class);	
	}
	
    @ApiOperation(value = "Deleta um um usuario")
	@DeleteMapping(value = "{id}", consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws BusinessException {
    	usuarioService.deleteUsuario(id);
	}
    
    @ApiOperation(value = "Retorna uma lista de produtos")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<UsuarioDto> findAll() throws BusinessException {
		return convertToDTO(usuarioService.findAll(), UsuarioDto.class);
	}
    
}

