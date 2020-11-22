package br.com.salescontrolservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.salescontrolservice.constant.MensagemConstants;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = MensagemConstants.PRODUTO_NAO_INFORMADO)
public class ProdutoNaoInformadoException extends BusinessException{

	private static final long serialVersionUID = 1L;
	
	public ProdutoNaoInformadoException() {
		super(MensagemConstants.PRODUTO_NAO_INFORMADO);
	}

}
