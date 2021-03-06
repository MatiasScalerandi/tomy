package com.test.tomy.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.tomy.constant.ErrorConstants;
import com.test.tomy.dto.AutoDTO;
import com.test.tomy.dto.ErrorDTO;
import com.test.tomy.exception.AutoException;
import com.test.tomy.service.AutoService;

@RestController
@RequestMapping("api")
public class ReporteAutosController {
	
	@Autowired
	private AutoService autoService;
	

	@GetMapping("/autos")
	public ResponseEntity<?> mostrarListaDeAutos() throws AutoException {

		List<AutoDTO> response = autoService.obtenerAutos();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/autos/{orden}")
	public ResponseEntity<?> mostrarListaDeAutosPorOrden(@PathVariable Integer orden) throws AutoException {//0: Dominio, 1: Marca, 2: Modelo.

		List<AutoDTO> response = autoService.ordenamiento(orden);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/crearRegistro")
	public ResponseEntity<?> crearRegistro(@RequestBody @Nullable AutoDTO request) throws ParseException, AutoException {
		
		Optional<AutoDTO> response = Optional.ofNullable(autoService.guardarAuto(request));
		return ResponseEntity.ok(response.get());
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody @Nullable AutoDTO request) throws ParseException, AutoException {

		AutoDTO response = autoService.guardarAuto(request);

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/borrado/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		autoService.borrarAuto(id);
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(AutoException.class)
	public ResponseEntity<?> productHandler(AutoException e) {
		ErrorDTO error = new ErrorDTO();
		error.setNombre(ErrorConstants.ERROR_HANDLER);
		error.setDescripcion(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
