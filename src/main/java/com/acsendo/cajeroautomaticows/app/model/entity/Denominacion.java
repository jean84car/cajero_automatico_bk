package com.acsendo.cajeroautomaticows.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "cj_denominacion", schema = "cajero_db" )
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "cajero_db.fn_registrar_denominacion", procedureName = "cajero_db.fn_registrar_denominacion", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_solicitud", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_respuesta", type = String.class) }),
		@NamedStoredProcedureQuery(name = "cajero_db.fn_retirar", procedureName = "cajero_db.fn_retirar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_solicitud", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_respuesta", type = String.class) }) })
public class Denominacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_denominacion")
	private BigDecimal idDenominacion;

	private BigDecimal denominacion;

	private BigDecimal cantidad;

	public BigDecimal getIdDenominacion() {
		return idDenominacion;
	}

	public void setIdDenominacion(BigDecimal idDenominacion) {
		this.idDenominacion = idDenominacion;
	}

	public BigDecimal getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(BigDecimal denominacion) {
		this.denominacion = denominacion;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

}
