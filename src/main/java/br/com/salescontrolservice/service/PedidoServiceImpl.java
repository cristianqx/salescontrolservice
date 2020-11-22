package br.com.salescontrolservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import br.com.salescontrolservice.domain.dto.ItemPedidoDTO;
import br.com.salescontrolservice.domain.dto.PedidoDTO;
import br.com.salescontrolservice.domain.entity.Estabelecimento;
import br.com.salescontrolservice.domain.entity.ItemPedido;
import br.com.salescontrolservice.domain.entity.Pedido;
import br.com.salescontrolservice.domain.entity.Usuario;
import br.com.salescontrolservice.enumeration.StatusEnum;
import br.com.salescontrolservice.enumeration.StatusVendasEnum;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.exception.EstabelecimentoNotFoundException;
import br.com.salescontrolservice.exception.PedidoNotFoundException;
import br.com.salescontrolservice.exception.ProdutoNaoInformadoException;
import br.com.salescontrolservice.exception.ProdutoNotFoundException;
import br.com.salescontrolservice.exception.UsuarioNotFoundException;
import br.com.salescontrolservice.repository.EstabelecimentoRepository;
import br.com.salescontrolservice.repository.ItemPedidoRepository;
import br.com.salescontrolservice.repository.PedidoRepository;
import br.com.salescontrolservice.repository.ProdutoRepository;
import br.com.salescontrolservice.repository.UsuarioRepository;

@Service
public class PedidoServiceImpl extends AbstractService implements PedidoService{

	@Autowired
	private ModelMapper modelMapper;
		
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	@Transactional(rollbackFor=BusinessException.class)
	public void cadastrarPedido(@Valid final PedidoDTO pedidoDTO) throws BusinessException {
		Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);		
		prepare(pedido);
		validate(pedido);
		validateProduto(pedidoDTO.getItens(), pedido.getEstabelecimento().getId());
		pedidoRepository.save(pedido);
		List<ItemPedido> itensPedido = prepareItensPedido(pedido, pedidoDTO.getItens()
				  .stream()
				  .map(user -> modelMapper.map(user, ItemPedido.class))
				  .collect(Collectors.toList()));
		
		saveItemPedido(itensPedido);
	}

	@Override
	public void cancelarPedido(@Valid Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido findById(Integer id) throws BusinessException {
		return pedidoRepository.findById(id).orElseThrow(PedidoNotFoundException::new);
	}

	@Override
	public Iterable<Pedido> findAll(Integer idEstabelecimento) {
		// TODO Auto-generated method stub
		return null;
	}
	
    private void saveItemPedido(final List<ItemPedido> itens) {
    	itemPedidoRepository.saveAll(itens);
    }

    private void validate(final Pedido pedido) throws BusinessException {
		validateEstabelecimento(pedido.getEstabelecimento());
		validateUsuario(pedido.getUsuarioLogado());
    
    }

    private void prepare(Pedido pedido) {
    	pedido.setStatus(StatusVendasEnum.FINALIZADA);
    }
    
    private List<ItemPedido> prepareItensPedido(Pedido pedido, List<ItemPedido> itens) throws BusinessException {    
		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

    	if(!CollectionUtils.isEmpty(itens)) {
    		itens.forEach(item -> {
    			item = new ItemPedido(pedido, item.getProduto(), null, item.getQuantidade(), item.getPreco());
    			itensPedido.add(item);
    		});
    	} else {
    		throw new ProdutoNaoInformadoException();
    	}
    
		return itensPedido;
    }
    
    
    private void validateProduto(List<ItemPedidoDTO> itemPedido, final Integer idEstabelecimento) throws BusinessException {
    	for(ItemPedidoDTO item : itemPedido) {
        	if(Objects.nonNull(item.getProduto().getDescricao())) {
        		if(!produtoRepository.existsProdutoByDescricaoAndEstabelecimentoId(item.getProduto().getDescricao(), idEstabelecimento)) {
        			throw new ProdutoNotFoundException();
        		}
        	}

    	}
    }
    
	private void validateEstabelecimento(Estabelecimento estabelecimento) throws BusinessException {
		if(Objects.nonNull(estabelecimento.getId())) {
			if(!estabelecimentoRepository.existsById(estabelecimento.getId())) {
				throw new EstabelecimentoNotFoundException();
			}
		}
	}
	

	private void validateUsuario(Usuario usuarioLogado) throws BusinessException {
		if(Objects.nonNull(usuarioLogado)) {
			if(!usuarioRepository.existsById(usuarioLogado.getId())) {
				throw new UsuarioNotFoundException();
			}
		}
	}

}
