package com.test.tomy.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import com.test.tomy.dto.AutoDTO;
import com.test.tomy.exception.AutoException;
import com.test.tomy.model.Auto;

public interface AutoService {

	public List<AutoDTO> obtenerAutos() throws AutoException;
	public AutoDTO guardarAuto(AutoDTO auto) throws ParseException, AutoException;
	public void borrarAuto(Long id);
	public List<AutoDTO> ordenamiento(Integer ordenar) throws AutoException;
	//public List<AutoDTO> filtroDeBusqueda(String )
}
