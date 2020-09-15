package br.com.salescontrolservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.salescontrolservice.constant.MensagemConstants;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = MensagemConstants.PRODUTO_NAO_ENCONTRADO)
public class ProdutoNotFoundException extends BusinessException{

	private static final long serialVersionUID = 1L;
	
	public ProdutoNotFoundException() {
		super(MensagemConstants.PRODUTO_NAO_ENCONTRADO);
	}

}
