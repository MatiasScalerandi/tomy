package com.test.tomy.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InspeccionDTO {
	private Long nroDeInspeccion;
	private Date fechaDeInspeccion;
	private String estadoDeInspeccion;
	private boolean exento;
	private String inspectorResponsable;
	private String automovilInspeccionado;
}
