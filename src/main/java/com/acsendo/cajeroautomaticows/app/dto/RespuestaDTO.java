package com.acsendo.cajeroautomaticows.app.dto;

import java.io.Serializable;

public class RespuestaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean exito;
	private String mensaje;
	
	public boolean isExito() {
		return exito;
	}
	
	public void setExito(boolean exito) {
		this.exito = exito;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
