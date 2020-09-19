package br.com.salescontrolservice.service;

import java.util.Objects;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.salescontrolservice.constant.MensagemConstants;
import br.com.salescontrolservice.domain.dto.ProdutoDto;
import br.com.salescontrolservice.domain.entity.Produto;
import br.com.salescontrolservice.enumeration.StatusEnum;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.exception.ProdutoNotFoundException;
import br.com.salescontrolservice.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void cadastrarProduto(@Valid ProdutoDto dto) throws BusinessException {
		Produto entity = modelMapper.map(dto, Produto.class);
		prepareCreate(entity);
		produtoRepository.save(entity);
	}

	@Override
	public Produto findById(Long id) throws BusinessException {
		return produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
	}

	@Override
	@Transactional
	public void atualizarProduto(@Valid ProdutoDto dto, @Valid Long id) throws BusinessException {
		Produto old = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
		
		Produto entity = modelMapper.map(dto, Produto.class);
		prepareUpdate(entity, id, old);
		
		produtoRepository.save(entity);
	}
	
	@Override
	public void deleteProduto(@Valid Long id) throws BusinessException {
		Produto entity = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
		entity.setStatus(StatusEnum.EXCLUIDO);
		produtoRepository.save(entity);
	}
	
	private void prepareCreate(final Produto entity) {
		entity.setStatus(StatusEnum.ATIVO);
	}
	
	private void prepareUpdate(final Produto entity, final Long id, Produto old) {
		entity.setId(id);
		entity.setStatus(old.getStatus());
	}
	
}
