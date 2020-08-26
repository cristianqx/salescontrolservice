package br.com.salescontrolservice.exception;

import br.com.salescontrolservice.constant.MensagemConstants;

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException() {
		super(MensagemConstants.RECORD_NOT_FOUND);
	}

	public RecordNotFoundException(final Exception exception) {
		super(exception);
	}

	public RecordNotFoundException(final String message) {
		super(message);
	}

	public RecordNotFoundException(final String message, final Exception exception) {
		super(message, exception);
	}
}
