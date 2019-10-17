package com.br.everis.homeoffice.model.service.fachada;

import java.util.List;

import com.br.everis.homeoffice.model.domain.Profile;

public interface IProfileServiceFachada {
	/**                                                                              
	 * @return                                                                       
	 */                                                                              
	List<Profile> listarTodos() throws Exception;                                       
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	Profile buscarPorId(Long id) throws Exception;                                      
                                                                                  
	/**                                                                              
	 * @param gerador                                                                
	 * @return                                                                       
	 */                                                                              
	Profile salvar(Profile profile) throws Exception;                                         
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	Profile editar(Profile profile) throws Exception;                                         
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	void deletar(Long id) throws Exception;  
}
