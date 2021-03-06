package com.br.everis.homeoffice.model.repository;                             
                                                                                        
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.everis.homeoffice.model.entity.Country;
                                                                                        
/**                                                                                     
 * @author alan.franco                                                                  
 *                                                                                      
 *         Classe de acesso aos dados de faixas de registro.                            
 *                                                                                      
 */                                                                                     
@Repository                                                                             
public interface CountryRepository extends JpaRepository<Country, Long>, Serializable {       
                                                                                        
}                                                                                       
