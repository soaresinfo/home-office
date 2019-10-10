package com.br.everis.homeoffice.model.service.ServiceFacade;
                                                                                  
import java.util.List;

import com.br.everis.homeoffice.model.entity.Country;
                                                                                  
/**                                                                               
 * @author alan.franco                                                            
 *                                                                                
 */                                                                               
public interface ICountryServiceFacade {
                                                                                  
	/**                                                                              
	 * @return                                                                       
	 */                                                                              
	List<Country> listAll() throws Exception;
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	Country findById(long id) throws Exception;
                                                                                  
	/**                                                                              
	 * @param gerador                                                                
	 * @return                                                                       
	 */                                                                              
	Country save(Country country) throws Exception;
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	Country update(Country country) throws Exception;
                                                                                  
	/**                                                                              
	 * @param id                                                                     
	 * @return                                                                       
	 */                                                                              
	void delete(long id) throws Exception;
                                                                                  
}                                                                                 
