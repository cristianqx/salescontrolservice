package br.com.salescontrolservice.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import br.com.salescontrolservice.domain.dto.UsuarioDto;
import br.com.salescontrolservice.domain.entity.Usuario;
import br.com.salescontrolservice.enumeration.StatusEnum;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.exception.UsuarioExistsException;
import br.com.salescontrolservice.exception.UsuarioNotFoundException;
import br.com.salescontrolservice.repository.UsuarioRepository;

@RestController
public class UsuarioServiceImpl extends AbstractService implements UsuarioService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public void cadastrarUsuario(@Valid UsuarioDto usuario) throws BusinessException {
		validateCreate(usuario);
		Usuario entity = modelMapper.map(usuario, Usuario.class);
		prepareCreate(entity);
		usuarioRepository.save(entity);
	}

	@Override
	@Transactional
	public void atualizarUsuario(@Valid UsuarioDto dto, @Valid Long id) throws BusinessException {
		Usuario old = usuarioRepository.findById(id).orElseThrow(UsuarioNotFoundException::new);
		Usuario entity = modelMapper.map(dto, Usuario.class);
		prepareUpdate(entity, old, id, dto);
		usuarioRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteUsuario(@Valid Long id) throws BusinessException {
		Usuario entity = usuarioRepository.findById(id).orElseThrow(UsuarioNotFoundException::new);
		entity.setStatus(StatusEnum.EXCLUIDO);
		usuarioRepository.save(entity);
	}

	@Override
	public Usuario findById(Long id) throws BusinessException {
		return usuarioRepository.findById(id).orElseThrow(UsuarioNotFoundException::new);
	}

	@Override
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAllByOrderByIdDesc();
	}
	
	private void prepareUpdate(final Usuario entity, final Usuario old, final Long id, final UsuarioDto dto) {
		entity.setId(id);
		entity.setNome(capitalize(dto.getNome()));
		entity.setStatus(old.getStatus());
	}
	
	private void prepareCreate(final Usuario entity) {
		entity.setNome(capitalize(entity.getNome()));
		entity.setStatus(StatusEnum.ATIVO);
		entity.setSenha(bcryptEncoder.encode(entity.getSenha()));
	}
	
	private void validateCreate(final UsuarioDto usuario) throws BusinessException {
		if(usuarioRepository.existsUsuarioByEmail(usuario.getEmail())) {
			throw new UsuarioExistsException();
		}
	}
	
}
