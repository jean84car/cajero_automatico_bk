package com.acsendo.cajeroautomaticows.app.dto;

import java.util.List;

public class RegistrarDenominacionRespuestaDTO extends RespuestaDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<DenominacionDTO> denominaciones;

	
	public List<DenominacionDTO> getDenominaciones() {
		return denominaciones;
	}

	public void setDenominaciones(List<DenominacionDTO> denominaciones) {
		this.denominaciones = denominaciones;
	}
	
	
}
