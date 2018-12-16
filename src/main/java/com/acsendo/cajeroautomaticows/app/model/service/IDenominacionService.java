package com.acsendo.cajeroautomaticows.app.model.service;

import com.acsendo.cajeroautomaticows.app.dto.DenominacionDTO;
import com.acsendo.cajeroautomaticows.app.dto.RegistrarDenominacionRespuestaDTO;
import com.acsendo.cajeroautomaticows.app.dto.RetirarBilletesRespuestaDTO;
import com.acsendo.cajeroautomaticows.app.dto.RetirarBilletesSolicitudDTO;

public interface IDenominacionService {

	public RegistrarDenominacionRespuestaDTO registrarDenominacion(DenominacionDTO solicitud)  throws Exception;
	
	public RetirarBilletesRespuestaDTO retirar(RetirarBilletesSolicitudDTO solicitud)  throws Exception;
	
	public RegistrarDenominacionRespuestaDTO findAll()  throws Exception;
	
}
