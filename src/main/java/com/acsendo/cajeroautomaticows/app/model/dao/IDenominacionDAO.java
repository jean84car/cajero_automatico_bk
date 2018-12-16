package com.acsendo.cajeroautomaticows.app.model.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.acsendo.cajeroautomaticows.app.model.entity.Denominacion;

public interface IDenominacionDAO extends CrudRepository<Denominacion, BigDecimal> {

	@Procedure(value = "cajero_db.fn_registrar_denominacion")
	public String registrarDenominacion(@Param("p_solicitud") String solicituda);
	
	@Procedure(value = "cajero_db.fn_retirar")
	public String retirar(@Param("p_solicitud") String solicituda);
	
}
