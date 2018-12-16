package com.acsendo.cajeroautomaticows.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Min;

public class RetirarBilletesSolicitudDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Min(value = 1, message = "El valor a retirar debe ser mayor o igual a 1")
	private BigDecimal valorRetirar;

	public BigDecimal getValorRetirar() {
		return valorRetirar;
	}

	public void setValorRetirar(BigDecimal valorRetirar) {
		this.valorRetirar = valorRetirar;
	}


}
