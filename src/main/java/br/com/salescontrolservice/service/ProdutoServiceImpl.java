package br.com.salescontrolservice.service;

import java.util.Objects;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.salescontrolservice.domain.dto.ProdutoDto;
import br.com.salescontrolservice.domain.entity.Produto;
import br.com.salescontrolservice.enumeration.StatusEnum;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.exception.ProdutoExistsException;
import br.com.salescontrolservice.exception.ProdutoNotFoundException;
import br.com.salescontrolservice.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl extends AbstractService implements ProdutoService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	@Transactional
	public void cadastrarProduto(@Valid ProdutoDto dto) throws BusinessException {
		validateCreate(dto);	
		
		if(Objects.nonNull(dto) && Objects.nonNull(dto.getEstabelecimento()) && dto.getEstabelecimento().size() > 0) {
			dto.getEstabelecimento().stream().forEach(estabelecimento -> {
				Produto entity = modelMapper.map(dto, Produto.class);
				prepareCreate(entity, dto);
				entity.setEstabelecimento(estabelecimento);
				produtoRepository.saveAndFlush(entity);
			});
		}
	}

	@Override
	public Produto findById(Integer id) throws BusinessException {
		return produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
	}


	@Override
	public Iterable<Produto> findByDescricao(Integer estabelecimentoId, String descricao) throws BusinessException {
		return produtoRepository.findByEstabelecimentoIdAndDescricao(estabelecimentoId, descricao);
	}
	
	@Override
	@Transactional
	public void atualizarProduto(@Valid ProdutoDto dto, @Valid Integer id) throws BusinessException {
		Produto old = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
		
		if(Objects.nonNull(dto) && Objects.nonNull(dto.getEstabelecimento()) && dto.getEstabelecimento().size() > 0) {
			dto.getEstabelecimento().stream().forEach(estabelecimento -> {			
				Produto entity = modelMapper.map(dto, Produto.class);
				prepareUpdate(entity,old, id, dto);
				entity.setEstabelecimento(estabelecimento);

				produtoRepository.save(entity);
			});
		}
	}
	
	@Override
	@Transactional
	public void deleteProduto(@Valid Integer id) throws BusinessException {
		Produto entity = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
		entity.setStatus(StatusEnum.EXCLUIDO);
		produtoRepository.save(entity);
	}
	
	@Override
	public Iterable<Produto> findAll(Integer idEstabelecimento) {
		return produtoRepository.findAllByEstabelecimentoIdOrderByIdDesc(idEstabelecimento);		
	}
	
	private void prepareCreate(final Produto entity, final ProdutoDto dto) {
		entity.setStatus(StatusEnum.ATIVO);
		entity.setDescricao(capitalize(entity.getDescricao()));
	}
	
	private void prepareUpdate(final Produto entity, final Produto old, final Integer id, final ProdutoDto dto) {
		entity.setId(id);
		entity.setDescricao(capitalize(dto.getDescricao()));
		entity.setStatus(old.getStatus());
	}
	
	private void validateCreate(final ProdutoDto dto) throws BusinessException{
		if(Objects.nonNull(dto) && Objects.nonNull(dto.getEstabelecimento()) && dto.getEstabelecimento().size() > 0) {
			for(int i = 0; i < dto.getEstabelecimento().size(); i++) {
				if(produtoRepository.existsProdutoByDescricaoAndEstabelecimentoId(dto.getDescricao(), dto.getEstabelecimento().get(i).getId())) {
					throw new ProdutoExistsException();
				}
			}
		}
	}

}
