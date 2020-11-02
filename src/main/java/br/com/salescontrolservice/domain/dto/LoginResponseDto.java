package br.com.salescontrolservice.domain.dto;

import java.io.Serializable;

public class LoginResponseDto implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public LoginResponseDto(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}