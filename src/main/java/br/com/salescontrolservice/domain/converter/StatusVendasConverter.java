package br.com.salescontrolservice.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.salescontrolservice.enumeration.StatusEnum;
import br.com.salescontrolservice.enumeration.StatusVendasEnum;

@Converter(autoApply = true)
public class StatusVendasConverter implements AttributeConverter<StatusVendasEnum, Short>{

	@Override
	public Short convertToDatabaseColumn(final StatusVendasEnum value) {
		return value != null ? value.getId() : null;
	}

	@Override
	public StatusVendasEnum convertToEntityAttribute(final Short value) {
		return StatusVendasEnum.valueOfId(value);
	}
}
