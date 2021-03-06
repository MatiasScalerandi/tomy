package com.test.tomy.util;

import java.text.ParseException;

import org.modelmapper.ModelMapper;

import com.test.tomy.dto.AutoDTO;
import com.test.tomy.model.Auto;

public class ModelMapperProductUtil {
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static AutoDTO convertToDTO(Auto autoEntidad) throws ParseException {
		AutoDTO autoDTO = modelMapper.map(autoEntidad, AutoDTO.class);
		return autoDTO;
	}
	
	public static Auto convertToEntity(AutoDTO autoDTO) throws ParseException {
		Auto auto = modelMapper.map(autoDTO, Auto.class);
		return auto;
	}
}
