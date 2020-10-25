package br.com.salescontrolservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import br.com.salescontrolservice.enumeration.StatusEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class Usuario extends AbstractEntity<Long>{

	@NotNull
	@NotBlank(message = "O nome do usuário deve ser preenchido")
	@Column(name = "nome")
	private String nome;
	
	@NotNull
	@NotBlank(message = "O email do usuário deve ser preenchido")
	@Column(name = "email")
	private String email;
	
	@NotNull
	@NotBlank(message = "A senha do usuário deve ser preenchida")
	@Column(name = "senha")
	private String senha;

	@NotNull
	@NotBlank(message = "O ddd do telefone do usuário deve ser preenchido")
	@Column(name = "ddd", length = 2)
	private String ddd;
	
	@NotNull
	@NotBlank(message = "O telefone do usuário deve ser preenchido")
	@Column(name = "telefone")
	@Size(min = 8, max = 9)
	private String telefone;
	
	@NotNull(message = "O perfil do usuário deve ser preenchido")
	@ManyToOne
	private TipoUsuario perfil;
	
	@Column(name = "status")
	@NotNull
	private StatusEnum status;

	@OneToOne
	private Estabelecimento estabelecimento;
	
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
