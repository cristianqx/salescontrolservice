package br.com.salescontrolservice.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum StatusVendasEnum {

	FINALIZADA((short) 1, "Finalizada"),
	CANCELADA((short) 2, "Cancelada");

	private final Short id;
	private final String descricao;
	
	private static final Map<Short, StatusVendasEnum> LOOKUP = new HashMap<>();
	private static final Map<String, StatusVendasEnum> LOOKUP_BY_DESCRICAO = new HashMap<>();


	static {
		for (StatusVendasEnum e : StatusVendasEnum.values()) {
			LOOKUP.put(e.getId(), e);
			LOOKUP_BY_DESCRICAO.put(e.getDescricao(), e);
		}
	}

	StatusVendasEnum(short id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Short getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusVendasEnum valueOfId(Short id) {
		return id != null ? LOOKUP.get(id) : null;
	}

	public static StatusVendasEnum valueOfDescricao(String descricao) {
		return LOOKUP_BY_DESCRICAO.get(descricao);
	}

}
