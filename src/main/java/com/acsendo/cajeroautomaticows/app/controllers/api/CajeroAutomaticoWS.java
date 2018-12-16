package com.acsendo.cajeroautomaticows.app.controllers.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acsendo.cajeroautomaticows.app.dto.DenominacionDTO;
import com.acsendo.cajeroautomaticows.app.dto.RegistrarDenominacionRespuestaDTO;
import com.acsendo.cajeroautomaticows.app.dto.RetirarBilletesRespuestaDTO;
import com.acsendo.cajeroautomaticows.app.dto.RetirarBilletesSolicitudDTO;
import com.acsendo.cajeroautomaticows.app.model.service.IDenominacionService;


@RestController
@RequestMapping(
	path = "api/cajero",
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE
)
public class CajeroAutomaticoWS {

	@Autowired
	private IDenominacionService denominacionService;
	
	@PostMapping(path = "billetes")
	public ResponseEntity<RegistrarDenominacionRespuestaDTO> registrarBilletes(@Valid @RequestBody DenominacionDTO solicitud, BindingResult result){
		
		try {
			if(result.hasErrors()) {
				String error = result.getFieldErrors()
						.stream()
						.map(err -> err.getDefaultMessage())
						.findFirst()
						.orElse("Error registrando la denominacion.");
				
				RegistrarDenominacionRespuestaDTO respuesta = new RegistrarDenominacionRespuestaDTO();
				respuesta.setExito(false);				
				respuesta.setMensaje(error);
				
				return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
			}	
			RegistrarDenominacionRespuestaDTO respuesta = denominacionService.registrarDenominacion(solicitud);

			return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
		}catch(Exception e) {
			RegistrarDenominacionRespuestaDTO respuesta = new RegistrarDenominacionRespuestaDTO();
			respuesta.setExito(false);
			respuesta.setMensaje("Error registrando la denominacion.");
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path = "billetes")
	public ResponseEntity<RegistrarDenominacionRespuestaDTO> consultarBilletes(){
		
		try {
			RegistrarDenominacionRespuestaDTO respuesta = denominacionService.findAll();

			return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
		}catch(Exception e) {
			RegistrarDenominacionRespuestaDTO respuesta = new RegistrarDenominacionRespuestaDTO();
			respuesta.setExito(false);
			respuesta.setMensaje("Error consultando las denominacion.");
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping(path = "billetes")
	public ResponseEntity<?> retirarBilletes(@Valid @RequestBody RetirarBilletesSolicitudDTO solicitud, BindingResult result){
		try {
			if(result.hasErrors()) {
				String error = result.getFieldErrors()
						.stream()
						.map(err -> err.getDefaultMessage())
						.findFirst()
						.orElse("Error registrando la denominacion.");
				
				RetirarBilletesRespuestaDTO respuesta = new RetirarBilletesRespuestaDTO();
				respuesta.setExito(false);				
				respuesta.setMensaje(error);
				
				return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
			}	
			RetirarBilletesRespuestaDTO respuesta = denominacionService.retirar(solicitud);

			return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
		}catch(Exception e) {
			RetirarBilletesRespuestaDTO respuesta = new RetirarBilletesRespuestaDTO();
			respuesta.setExito(false);
			respuesta.setMensaje("Error registrando la denominacion.");
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
