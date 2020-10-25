package br.com.salescontrolservice.constant;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MensagemConstants {

	/* 
	 * Usuário
	 */
	public static final String USUARIO_NAO_ENCONTRADO = "O usuário informado não foi encontrado.";
	public static final String USUARIO_JA_CADASTRADO = "O usuário já está cadastrado no sistema.";

	/*
	 * Produto
	 */
	public static final String PRODUTO_NAO_ENCONTRADO = "O produto informado não foi encontrado.";
	public static final String PRODUTO_JA_CADASTRADO = "Já existe um cadastro de produto para o estabelecimento informado.";
	
	/*
	 * Estabelecimento
	 */
	public static final String ESTABELECIMENTO_NAO_ENCONTRADO = "O estabelecimento informado não foi encontrado.";
	public static final String ESTABELECIMENTO_JA_CADASTRADO = "O estabelecimento já está cadastrado no sistema.";
	/*
	 * Record Exception
	 */
	public static final String RECORD_NOT_FOUND = "Record not found";

}
