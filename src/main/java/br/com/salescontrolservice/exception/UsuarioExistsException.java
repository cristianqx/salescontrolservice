package br.com.salescontrolservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.salescontrolservice.constant.MensagemConstants;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = MensagemConstants.USUARIO_JA_CADASTRADO)
public class UsuarioExistsException extends BusinessException{

	private static final long serialVersionUID = 1L;
	
	public UsuarioExistsException() {
		super(MensagemConstants.USUARIO_JA_CADASTRADO);
	}

}
