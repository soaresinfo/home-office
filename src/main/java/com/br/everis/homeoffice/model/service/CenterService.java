package com.br.everis.homeoffice.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.br.everis.homeoffice.model.domain.Center;
import com.br.everis.homeoffice.model.repository.CenterRepository;
import com.br.everis.homeoffice.model.service.fachada.ICenterServiceFachada;

/**
 * @author Marcelo
 *
 */
@Service
public class CenterService extends BaseService implements ICenterServiceFachada{

	@Autowired
	private CenterRepository repository;
	
	@Override
	public List<Center> findAll() {
		List<Center> list = new ArrayList<Center>();
		try {
			list = repository.findAll();
		} catch (Exception e) {
			LOGGER.error("Falha ao buscar center", e);
		}
		return list;
	}

	@Override
	public Center save(Center center) {
		if(StringUtils.isEmpty(center.getState())) {
			LOGGER.warn("Atenção, atributo state não preenchido");
			center.setState("N/A");
		}
		return repository.save(center);
		
	}

}
