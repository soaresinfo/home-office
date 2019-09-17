package com.br.everis.homeoffice.model.service.fachada;

import java.util.List;

import com.br.everis.homeoffice.model.domain.Center;

/**
 * @author Marcelo
 *
 */
public interface ICenterServiceFachada {

	List<Center> findAll();
	
	void save(Center center);
}
