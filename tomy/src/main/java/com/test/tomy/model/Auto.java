package com.test.tomy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "auto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Auto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dominio;
	private String marca;
	private String modelo;
	@Column(name="nombre_del_propietario")//se pone column cuando es diferente en la bd
	private String nombreDelPropietario;
}
