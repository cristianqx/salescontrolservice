package br.com.salescontrolservice.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.salescontrolservice.domain.dto.UsuarioDto;
import br.com.salescontrolservice.domain.entity.Usuario;
import br.com.salescontrolservice.exception.BusinessException;
import br.com.salescontrolservice.exception.UsuarioExistsException;
import br.com.salescontrolservice.repository.UsuarioRepository;

@RestController
public class UsuarioServiceImpl extends AbstractService implements UsuarioService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void cadastrarUsuario(@Valid UsuarioDto usuario) throws BusinessException {
		
	}

	@Override
	@Transactional
	public void atualizarUsuario(@Valid UsuarioDto usuario, @Valid Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteUsuario(@Valid Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario findById(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void validateCreate(final UsuarioDto usuario) throws BusinessException {
		if(usuarioRepository.existsUsuarioByEmail(usuario.getEmail())) {
			throw new UsuarioExistsException();
		}
	}
	
}
