package br.com.salescontrolservice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user_type")
public class TipoUsuario extends AbstractEntity<Long>{

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
