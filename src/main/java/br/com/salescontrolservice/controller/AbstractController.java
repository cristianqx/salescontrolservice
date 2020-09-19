package br.com.salescontrolservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {

    @Autowired
    private ModelMapper modelMapper;
        	
	protected <D, T> D convertToDTO(final T model, final Class<D> dtoClass) {
		return model != null ? modelMapper.map(model, dtoClass) : null;
	}

}
