package br.com.salescontrolservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.salescontrolservice.constant.MensagemConstants;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = MensagemConstants.USUARIO_NAO_ENCONTRADO)
public class UsuarioNotFoundException extends BusinessException{

	private static final long serialVersionUID = 1L;
	
	public UsuarioNotFoundException() {
		super(MensagemConstants.USUARIO_NAO_ENCONTRADO);
	}

}
