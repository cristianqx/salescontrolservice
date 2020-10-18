package br.com.salescontrolservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.salescontrolservice.constant.MensagemConstants;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = MensagemConstants.PRODUTO_JA_CADASTRADO)
public class ProdutoExistsException extends BusinessException{

	private static final long serialVersionUID = 1L;
	
	public ProdutoExistsException() {
		super(MensagemConstants.PRODUTO_JA_CADASTRADO);
	}

}
