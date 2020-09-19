package br.com.salescontrolservice.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {

	ATIVO((short) 1, "Ativo"),
	EXCLUIDO((short) 2, "Excluído"),
	INATIVO((short) 3, "Inativo");

	private final Short id;
	private final String descricao;
	
	private static final Map<Short, StatusEnum> LOOKUP = new HashMap<>();
	private static final Map<String, StatusEnum> LOOKUP_BY_DESCRICAO = new HashMap<>();


	static {
		for (StatusEnum e : StatusEnum.values()) {
			LOOKUP.put(e.getId(), e);
			LOOKUP_BY_DESCRICAO.put(e.getDescricao(), e);
		}
	}

	StatusEnum(short id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Short getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusEnum valueOfId(Short id) {
		return id != null ? LOOKUP.get(id) : null;
	}

	public static StatusEnum valueOfDescricao(String descricao) {
		return LOOKUP_BY_DESCRICAO.get(descricao);
	}

}
