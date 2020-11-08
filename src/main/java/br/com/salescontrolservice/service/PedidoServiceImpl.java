package br.com.salescontrolservice.service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import br.com.salescontrolservice.domain.dto.ItemPedidoDTO;
import br.com.salescontrolservice.domain.dto.PedidoDTO;
import br.com.salescontrolservice.domain.dto.UsuarioDto;
import br.com.salescontrolservice.domain.entity.Estabelecimento;
import br.com.salescontrolservice.domain.entity.ItemPedido;
import br.com.salescontrolservice.domain.entity.Pedido;
import br.com.salescontrolservice.domain.entity.Produto;
import br.com.salescontrolservice.domain.entity.Usuario;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.exception.EstabelecimentoNotFoundException;
import br.com.salescontrolservice.exception.ProdutoNotFoundException;
import br.com.salescontrolservice.exception.UsuarioExistsException;
import br.com.salescontrolservice.exception.UsuarioNotFoundException;
import br.com.salescontrolservice.repository.EstabelecimentoRepository;
import br.com.salescontrolservice.repository.ItemPedidoRepository;
import br.com.salescontrolservice.repository.PedidoRepository;
import br.com.salescontrolservice.repository.ProdutoRepository;import br.com.salescontrolservice.repository.UsuarioRepository;

@Service
public class PedidoServiceImpl extends AbstractService implements PedidoService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PedidoRepository pedidoServiceImpl;
	
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
		validate(pedido);
		validateEstabelecimento(pedido.getEstabelecimento());
		validateUsuario(pedido.getUsuarioLogado());
		validateProduto(pedidoDTO.getItens(), pedido.getEstabelecimento().getId());
		
		//falta salvar primeiro o pedido pra depois salvar o itemPedido, pois ele pede o id
		saveItemPedido(pedido.getItens());
	}

	@Override
	public void cancelarPedido(@Valid Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido findById(Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Pedido> findAll(Integer idEstabelecimento) {
		// TODO Auto-generated method stub
		return null;
	}
	
    private void saveItemPedido(final Set<ItemPedido> itens) {
    	itemPedidoRepository.saveAll(itens);
    }

    private void validate(final Pedido pedido) throws BusinessException {

    
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
