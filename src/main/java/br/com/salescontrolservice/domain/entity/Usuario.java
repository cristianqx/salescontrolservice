package br.com.salescontrolservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

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

	@Column(name = "name")
	private String nome;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "password")
	private String password;

	@Column(name = "ddd", length = 2)
	@NotNull
	private String ddd;
	
	@Column(name = "telefone")
	@NotNull
	@Size(min = 8, max = 9)
	private String telefone;
	
	@ManyToOne
	private TipoUsuario perfil;
	
	@Column(name = "active")
	private boolean ativo;
}
