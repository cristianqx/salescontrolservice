package br.com.salescontrolservice.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.salescontrolservice.enumeration.StatusEnum;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<StatusEnum, Short>{

	@Override
	public Short convertToDatabaseColumn(final StatusEnum value) {
		return value != null ? value.getId() : null;
	}

	@Override
	public StatusEnum convertToEntityAttribute(final Short value) {
		return StatusEnum.valueOfId(value);
	}
}
