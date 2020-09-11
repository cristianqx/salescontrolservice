package br.com.salescontrolservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name="user")
public class Usuario extends AbstractEntity<Long>{

	@NotNull
	@NotBlank(message = "O nome do usuário deve ser preenchido")
	@Column(name = "name")
	private String nome;
	
	@NotNull
	@NotBlank(message = "O email do usuário deve ser preenchido")
	@Column(name = "email")
	private String email;
	
	@NotNull
	@NotBlank(message = "A senha do usuário deve ser preenchida")
	@Column(name = "password")
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
	
	@NotNull
	@NotBlank(message = "O perfil do usuário deve ser preenchido")
	@ManyToOne
	private TipoUsuario perfil;
	
	@Column(name = "active")
	@NotNull
	private boolean ativo;
}
