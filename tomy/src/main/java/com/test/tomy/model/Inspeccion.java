package com.test.tomy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inspeccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inspeccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="nro_de_inspeccion")
	private Long nroDeInspeccion;
	@Column(name="fecha_de_inspeccion")
	@Temporal(TemporalType.DATE)
	private Date fechaDeInspeccion;
	@Column(name="estado_de_inspeccion")
	private String estadoDeInspeccion;
	private boolean exento;
	@Column(name="inspector_responsable")
	private String inspectorResponsable;
	@Column(name="automovil_inspeccionado")
	private String automovilInspeccionado;
}
