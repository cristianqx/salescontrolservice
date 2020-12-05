package br.com.salescontrolservice.constant;

public final class WhereStatusConstants {

	public static final String EQUALS_STATUS = "status = ";
	public static final String NOT_EQUALS_STATUS = "status != ";

	public static final String EQUALS_ATIVO = EQUALS_STATUS + StatusConstants.ATIVO;
	public static final String EQUALS_EXCLUIDO = EQUALS_STATUS + StatusConstants.EXCLUIDO;

	public static final String NOT_EQUALS_ATIVO = NOT_EQUALS_STATUS + StatusConstants.ATIVO;
	public static final String NOT_EQUALS_EXCLUIDO = NOT_EQUALS_STATUS + StatusConstants.EXCLUIDO;
}
