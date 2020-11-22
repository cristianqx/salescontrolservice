package br.com.salescontrolservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.salescontrolservice.domain.dto.PedidoDTO;
import br.com.salescontrolservice.domain.entity.Pedido;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.service.PedidoService;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/pedido")
@RestController
@Valid
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController extends AbstractController {

	@Autowired
	private PedidoService pedidoService;
	
    @ApiOperation(value = "Cadastra um pedido")
	@PostMapping(consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody PedidoDTO pedido) throws BusinessException {
    	pedidoService.cadastrarPedido(pedido);
	}
    
    @ApiOperation(value = "Retorna dados de um pedido pelo id")
	@GetMapping(value = "{id}")
	@ResponseStatus(HttpStatus.OK)
	public PedidoDTO findById(@PathVariable final Integer id) throws BusinessException {
    	return convertToDTO(pedidoService.findById(id), PedidoDTO.class);	
	}
    
    @ApiOperation(value = "Cancela um pedido")
	@DeleteMapping(value = "{id}", consumes = { "application/json" },  produces = { "application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) throws BusinessException {
    	pedidoService.cancelarPedido(id);
	}
    
    @ApiOperation(value = "Retorna uma lista de pedidos de um determinado estabelecimento")
    @GetMapping(value = "/estabelecimento/{idEstabelecimento}")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<PedidoDTO> findAll(@PathVariable final Integer idEstabelecimento) throws BusinessException {
		return convertToDTO(pedidoService.findAll(idEstabelecimento), PedidoDTO.class);
	}
    
}
