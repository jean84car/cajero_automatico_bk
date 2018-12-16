package com.acsendo.cajeroautomaticows.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Min;

public class DenominacionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idDenominacion;
	
	@Min(value = 1, message = "Para el campo denominacion el minimo valor es 1")
    private BigDecimal denominacion;
	
	@Min(value = 1, message = "Para el campo cantidad el minimo valor es 1")
    private Integer cantidad;

    
    public Long getIdDenominacion() {
        return idDenominacion;
    }

    public void setIdDenominacion(Long idDenominacion) {
        this.idDenominacion = idDenominacion;
    }
    
    public BigDecimal getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(BigDecimal denominacion) {
        this.denominacion = denominacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
	
}
