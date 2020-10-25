package br.com.salescontrolservice.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salescontrolservice.domain.dto.EstabelecimentoDto;
import br.com.salescontrolservice.domain.entity.Estabelecimento;
import br.com.salescontrolservice.enumeration.StatusEnum;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.exception.EstabelecimentoExistsException;
import br.com.salescontrolservice.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoServiceImpl extends AbstractService implements EstabelecimentoService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@Override
	public void cadastrarEstabelecimento(@Valid EstabelecimentoDto dto) throws BusinessException {
		validateCreate(dto);
		Estabelecimento entity = modelMapper.map(dto, Estabelecimento.class);
		prepareCreate(entity);
		estabelecimentoRepository.save(entity);
	}

	@Override
	public Iterable<Estabelecimento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizarEstabelecimento(@Valid EstabelecimentoDto dto, @Valid Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEstabelecimento(@Valid Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Estabelecimento findById(Integer id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	private void validateCreate(final EstabelecimentoDto dto) throws BusinessException {
		if(estabelecimentoRepository.existsEstabelecimentoByNome(dto.getNome())) {
			throw new EstabelecimentoExistsException();
		}
	}
	
	private void prepareCreate(final Estabelecimento entity) {
		entity.setNome(capitalize(entity.getNome()));
		entity.setStatus(StatusEnum.ATIVO);
	}
	
}
