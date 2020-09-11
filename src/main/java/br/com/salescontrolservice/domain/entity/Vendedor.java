package br.com.salescontrolservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name="salesman")
public class Vendedor extends AbstractEntity<Long> {
	
	@NotNull
	@NotBlank(message = "O nome do vendedor deve ser preenchido")
	@Column(name = "name_salesman")
	private String nome;
	
	@NotNull
	@Column(name = "active")
	private boolean ativo;
}
