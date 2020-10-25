package br.com.salescontrolservice.domain.dto;

import br.com.salescontrolservice.domain.entity.Estabelecimento;
import br.com.salescontrolservice.domain.entity.TipoUsuario;
import br.com.salescontrolservice.enumeration.StatusEnum;

public class UsuarioDto {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String ddd;
	private String telefone;
	private TipoUsuario perfil;
	private StatusEnum status;
	private Estabelecimento estabelecimento;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getDdd() {
		return ddd;
	}
	
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public TipoUsuario getPerfil() {
		return perfil;
	}
	public void setPerfil(TipoUsuario perfil) {
		this.perfil = perfil;
	}
	
	public StatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}	
}
