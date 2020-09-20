package br.com.salescontrolservice.service;

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
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void cadastrarProduto(@Valid ProdutoDto dto) throws BusinessException {
		validateCreate(dto);
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
		prepareUpdate(entity,old, id, dto);
		
		produtoRepository.save(entity);
	}
	
	@Override
	@Transactional
	public void deleteProduto(@Valid Long id) throws BusinessException {
		Produto entity = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
		entity.setStatus(StatusEnum.EXCLUIDO);
		produtoRepository.save(entity);
	}
	
	@Override
	public Iterable<Produto> findAll() {
		return produtoRepository.findAll();		
	}
	
	private void prepareCreate(final Produto entity) {
		entity.setStatus(StatusEnum.ATIVO);
		entity.setDescricao(capitalize(entity.getDescricao()));
	}
	
	private void prepareUpdate(final Produto entity, final Produto old, final Long id, final ProdutoDto dto) {
		entity.setId(id);
		entity.setDescricao(capitalize(dto.getDescricao()));
		entity.setStatus(old.getStatus());
	}
	
	private void validateCreate(final ProdutoDto dto) throws BusinessException{
		if (produtoRepository.existsProdutoByDescricao(dto.getDescricao())) {
			throw new ProdutoExistsException();
		}
	}
	
	public static String capitalize (String str) {
	    char[] letras = str.toCharArray();
	    for (int i = 0; i < letras.length; ++i) {
	        if (i == 0 || !Character.isLetterOrDigit (letras[i-1])) {
	            letras[i] = Character.toUpperCase (letras[i]);
	        }
	    }
	    return new String (letras);
	}
	
}
