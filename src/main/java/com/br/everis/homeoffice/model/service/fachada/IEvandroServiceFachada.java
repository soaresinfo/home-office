package com.br.everis.homeoffice.model.service.fachada;                 
                                                                                  
import java.util.List;

import com.br.everis.homeoffice.model.domain.Evandro;                       
                                                                                  
/**                                                                               
 * @author alan.franco                                                            
 *                                                                                
 */                                                                               
public interface IEvandroServiceFachada {                                             
                                                                                  
	/**                                                                              
	 * @return                                                                       
	 */                                                                              
	List<Evandro> listarTodos() throws Exception;                                       
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	Evandro buscarPorId(Long id) throws Exception;                                      
                                                                                  
	/**                                                                              
	 * @param gerador                                                                
	 * @return                                                                       
	 */                                                                              
	Evandro salvar(Evandro evandro) throws Exception;                                         
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	Evandro editar(Evandro evandro) throws Exception;                                         
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	void deletar(Long id) throws Exception;                                          
                                                                                  
}                                                                                 
