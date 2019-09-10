package com.br.everis.homeoffice.model.service.fachada;                 
                                                                                  
import java.util.List;

import com.br.everis.homeoffice.model.domain.Country;                       
                                                                                  
/**                                                                               
 * @author alan.franco                                                            
 *                                                                                
 */                                                                               
public interface ICountryServiceFachada {                                             
                                                                                  
	/**                                                                              
	 * @return                                                                       
	 */                                                                              
	List<Country> listarTodos() throws Exception;                                       
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	Country buscarPorId(Long id) throws Exception;                                      
                                                                                  
	/**                                                                              
	 * @param gerador                                                                
	 * @return                                                                       
	 */                                                                              
	Country salvar(Country evandro) throws Exception;                                         
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	Country editar(Country evandro) throws Exception;                                         
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	void deletar(Long id) throws Exception;                                          
                                                                                  
}                                                                                 
