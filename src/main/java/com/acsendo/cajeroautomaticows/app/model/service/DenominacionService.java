package com.acsendo.cajeroautomaticows.app.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acsendo.cajeroautomaticows.app.dto.DenominacionDTO;
import com.acsendo.cajeroautomaticows.app.dto.RegistrarDenominacionRespuestaDTO;
import com.acsendo.cajeroautomaticows.app.dto.RetirarBilletesRespuestaDTO;
import com.acsendo.cajeroautomaticows.app.dto.RetirarBilletesSolicitudDTO;
import com.acsendo.cajeroautomaticows.app.model.dao.IDenominacionDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class DenominacionService implements IDenominacionService {

	@Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
	private IDenominacionDAO denominacionDAO;

	
	@Override
	public RegistrarDenominacionRespuestaDTO registrarDenominacion(DenominacionDTO solicitud) throws Exception {
		RegistrarDenominacionRespuestaDTO respuesta = null;
		
		String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(solicitud);
		String respuestaSP = denominacionDAO.registrarDenominacion(json);
		respuesta = objectMapper.readValue(respuestaSP, RegistrarDenominacionRespuestaDTO.class);
		respuesta.setDenominaciones(findAll().getDenominaciones());
		
		return respuesta;
	}


	@Override
	public RetirarBilletesRespuestaDTO retirar(RetirarBilletesSolicitudDTO solicitud) throws Exception {
		RetirarBilletesRespuestaDTO respuesta = null;
		
		String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(solicitud);
		String respuestaSP = denominacionDAO.retirar(json);
		respuesta = objectMapper.readValue(respuestaSP, RetirarBilletesRespuestaDTO.class);
		
		return respuesta;
	}


	@Override
	public RegistrarDenominacionRespuestaDTO findAll() throws Exception {
		RegistrarDenominacionRespuestaDTO respuesta = new RegistrarDenominacionRespuestaDTO();
		respuesta.setExito(true);
		ModelMapper model = new ModelMapper();		
		List<DenominacionDTO> denominaciones = new ArrayList<>(); 
		denominacionDAO.findAll().forEach(denominacion -> {
			denominaciones.add(model.map(denominacion, DenominacionDTO.class));
		});
		respuesta.setDenominaciones(denominaciones.stream()
				.sorted((o1, o2)->o1.getDenominacion().compareTo(o2.getDenominacion())).collect(Collectors.toList()));
		
		return respuesta;
	}

}
