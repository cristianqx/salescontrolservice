package br.com.salescontrolservice.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salescontrolservice.config.security.JwtTokenUtil;
import br.com.salescontrolservice.config.security.JwtUserDetailsService;
import br.com.salescontrolservice.domain.dto.LoginRequestDto;
import br.com.salescontrolservice.domain.dto.LoginResponseDto;
import br.com.salescontrolservice.domain.dto.UsuarioDto;
import br.com.salescontrolservice.domain.entity.Usuario;
import br.com.salescontrolservice.exception.UsuarioNotFoundException;
import br.com.salescontrolservice.repository.UsuarioRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController extends AbstractController{
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private UsuarioRepository repository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequestDto authenticationRequest) throws Exception {
		
		UsuarioDto usuario = convertToDTO(repository.findByEmail(authenticationRequest.getEmail()), UsuarioDto.class);
		Map<Object, Object> model = new HashMap<>();
		
		if(Objects.nonNull(usuario)) {
			authenticate(authenticationRequest.getEmail(), authenticationRequest.getSenha());
			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(authenticationRequest.getEmail());

			final String token = jwtTokenUtil.generateToken(userDetails);
			model.put("token", token);
			model.put("id", usuario.getId());
			model.put("nome", usuario.getNome());
			model.put("email", usuario.getEmail());
			
			if(Objects.nonNull(usuario.getEstabelecimento())) {
				model.put("estabelecimento", usuario.getEstabelecimento().getId());
			}
			
			model.put("tipoUsuario", usuario.getPerfil().getId());
		} else {
			throw new UsuarioNotFoundException();
		}
		
		return ResponseEntity.ok(model);
	}

	private void authenticate(String email, String senha) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, senha));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new UsuarioNotFoundException();
		}
		
	}
}