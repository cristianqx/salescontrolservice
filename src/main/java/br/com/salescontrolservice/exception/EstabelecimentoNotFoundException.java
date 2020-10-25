package br.com.salescontrolservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.salescontrolservice.constant.MensagemConstants;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = MensagemConstants.ESTABELECIMENTO_NAO_ENCONTRADO)
public class EstabelecimentoNotFoundException extends BusinessException{

	private static final long serialVersionUID = 1L;
	
	public EstabelecimentoNotFoundException() {
		super(MensagemConstants.ESTABELECIMENTO_NAO_ENCONTRADO);
	}

}
