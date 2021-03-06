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
import br.com.salescontrolservice.exception.EstabelecimentoNotFoundException;
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
		return estabelecimentoRepository.findAllByOrderByIdDesc();
	}

	@Override
	public void atualizarEstabelecimento(@Valid EstabelecimentoDto dto, @Valid Integer id) throws BusinessException {
		Estabelecimento old = estabelecimentoRepository.findById(id).orElseThrow(EstabelecimentoNotFoundException::new);
		Estabelecimento entity = modelMapper.map(dto, Estabelecimento.class);
		prepareUpdate(entity, old, id, dto);
		estabelecimentoRepository.save(entity);
	}

	@Override
	public void deleteEstabelecimento(@Valid Integer id) throws BusinessException {
		Estabelecimento entity = estabelecimentoRepository.findById(id).orElseThrow(EstabelecimentoNotFoundException::new);
		entity.setStatus(StatusEnum.EXCLUIDO);
		estabelecimentoRepository.save(entity);
	}

	@Override
	public Estabelecimento findById(Integer id) throws BusinessException {
		return estabelecimentoRepository.findById(id).orElseThrow(EstabelecimentoNotFoundException::new);
	}

	private void validateCreate(final EstabelecimentoDto dto) throws BusinessException {
		if(estabelecimentoRepository.existsEstabelecimentoByNome(dto.getNome())) {
			throw new EstabelecimentoExistsException();
		}
	}
	
	private void prepareUpdate(final Estabelecimento entity, final Estabelecimento old, final Integer id, final EstabelecimentoDto dto) {
		entity.setId(id);
		entity.setNome(capitalize(dto.getNome()));
		entity.setStatus(old.getStatus());
	}
	
	private void prepareCreate(final Estabelecimento entity) {
		entity.setNome(capitalize(entity.getNome()));
		entity.setStatus(StatusEnum.ATIVO);
	}
	
}
