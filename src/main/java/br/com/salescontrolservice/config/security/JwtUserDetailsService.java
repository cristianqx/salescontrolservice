package br.com.salescontrolservice.config.security;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.salescontrolservice.controller.AbstractController;
import br.com.salescontrolservice.domain.dto.UsuarioDto;
import br.com.salescontrolservice.repository.UsuarioRepository;

@Service
public class JwtUserDetailsService extends AbstractController implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UsuarioDto user = convertToDTO(usuarioRepository.findByEmail(email), UsuarioDto.class);
		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException("Usuário não encontrado: " + email);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getSenha(),
				new ArrayList<>());
	}
}
