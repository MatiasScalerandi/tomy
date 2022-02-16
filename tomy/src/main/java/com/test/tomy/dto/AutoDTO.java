package com.test.tomy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoDTO {
	private Long id;
	private String dominio;
	private String marca;
	private String modelo;
	private String nombreDelPropietario;
}
