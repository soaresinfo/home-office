package com.br.everis.homeoffice.model.service.fachada;

import java.util.List;

public interface IGenericFacade<T> {

	List<T> getAll() throws Exception;                                       
    
	T getById(Long id) throws Exception;                                      
                                                                                  
	T create(T entity) throws Exception;                                         
                                                                                  
	T edit(T entity) throws Exception;                                         
                                                                                  
	void delete(Long id) throws Exception;
}
