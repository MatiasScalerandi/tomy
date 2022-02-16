package com.test.tomy.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.tomy.dto.AutoDTO;
import com.test.tomy.exception.AutoException;
import com.test.tomy.model.Auto;
import com.test.tomy.repository.AutoRepository;

public class TestService {
	@Mock
	private AutoRepository autoRepoMock;

	@Autowired
	@InjectMocks
	private AutoServiceImpl service;
	List<Auto> mockList = new ArrayList<>();
	List<AutoDTO> mockListDto = new ArrayList<>();
	Auto a = new Auto();
	AutoDTO aDto = new AutoDTO();
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		a.setDominio("TET-123");
		a.setMarca("Peugeot");
		a.setModelo("208");
		a.setNombreDelPropietario("Tomy");
		
		mockList.add(a);
		
	}
	
	@Test
	public void OrderByDominioListaVacia() throws AutoException {
		List<Auto> la = new ArrayList<>();

		Mockito.when(autoRepoMock.findAll()).thenReturn(la);
		service.ordenamiento(0);

	}
	
	@Test
	public void OrderByDominioOK() throws AutoException {

		Mockito.when(autoRepoMock.findAll()).thenReturn(mockList);
		service.ordenamiento(0);

	}
	
	@Test
	public void OrderByMarcaOK() throws AutoException {

		Mockito.when(autoRepoMock.findAll()).thenReturn(mockList);
		service.ordenamiento(1);

	}
	
	@Test
	public void OrderByModeloOK() throws AutoException {

		Mockito.when(autoRepoMock.findAll()).thenReturn(mockList);
		service.ordenamiento(2);

	}
	
	@Test
	public void OrderByModeloNull() throws AutoException {

		Mockito.when(autoRepoMock.findAll()).thenReturn(mockList);
		service.ordenamiento(null);

	}
	
	@Test
	public void OrderDefault() throws AutoException {

		Mockito.when(autoRepoMock.findAll()).thenReturn(mockList);
		service.ordenamiento(5);

	}
	
}
