package br.com.salescontrolservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name="product")
public class Produto extends AbstractEntity<Long>{

	@Column(name = "desc_product")
	private String descricao;
	
	@NotNull(message = "O valor da peca deve ser preenchido")
	@Column(name = "value_unitary")
	private Double valorUnitario;
		
	@Column(name = "active")
	private boolean ativo;
	
}
