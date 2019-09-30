package com.br.everis.homeoffice.model.service.fachada;

import java.util.List;

import com.br.everis.homeoffice.model.domain.User;


public interface IUserServiceFachada {

	/**                                                                              
	 * @return                                                                       
	 */                                                                              
	List<User> listarTodos() throws Exception;                                       
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	User buscarPorId(Long id) throws Exception;                                      
                                                                                  
	/**                                                                              
	 * @param gerador                                                                
	 * @return                                                                       
	 */                                                                              
	User salvar(User country) throws Exception;                                         
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	User editar(User country) throws Exception;                                         
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	void deletar(Long id) throws Exception;       
	
}
