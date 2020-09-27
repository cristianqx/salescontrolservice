package br.com.salescontrolservice.service;

import javax.validation.Valid;

import br.com.salescontrolservice.domain.dto.UsuarioDto;
import br.com.salescontrolservice.domain.entity.Usuario;
import br.com.salescontrolservice.exception.BusinessException;

public interface UsuarioService {

	void cadastrarUsuario(@Valid UsuarioDto usuario) throws BusinessException;
	
	void atualizarUsuario(@Valid UsuarioDto usuario, @Valid Long id) throws BusinessException;
	
	void deleteUsuario(@Valid Long id) throws BusinessException;
	
	Usuario findById(final Long id) throws BusinessException;
	
	Iterable<Usuario> findAll();
}
