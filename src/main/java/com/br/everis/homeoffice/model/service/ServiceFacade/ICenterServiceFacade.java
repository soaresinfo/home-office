package com.br.everis.homeoffice.model.service.ServiceFacade;

import java.util.List;

import com.br.everis.homeoffice.model.entity.Center;

/**
 * @author Marcelo
 *
 */
public interface ICenterServiceFacade {

	List<Center> findAll();
	
	Center save(Center center);
}
