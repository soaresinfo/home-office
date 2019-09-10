package com.br.everis.homeoffice.model.service;                                                              
                                                                                                                       
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.everis.homeoffice.model.domain.Country;
import com.br.everis.homeoffice.model.repository.CountryRepository;
import com.br.everis.homeoffice.model.service.fachada.ICountryServiceFachada;                                                                                           
                                                                                                                       
/**                                                                                                                    
 * @author alan.franco                                                                                                 
 *                                                                                                                     
 */                                                                                                                    
@Service                                                                                                               
public class CountryService extends BaseService implements ICountryServiceFachada {                                           
                                                                                                                       
	/**                                                                                                                   
	 * Injetando as dependências da interface de abstração do spring data                                                 
	 * responsável pelo acesso aos dados deste objeto                                                                     
	 */                                                                                                                   
	@Autowired                                                                                                            
	private CountryRepository geradorRepository;
	
	public CountryService() {                                                                                                
		super();
		
	}                                                                                                                     
                                                                                                                       
	@Override                                                                                                             
	public List<Country> listarTodos() throws Exception {                                                                    
		List<Country> retorno = new ArrayList<Country>();                                                                       
		try {                                                                                                             
			retorno = this.geradorRepository.findAll();                                                                   
		} catch (Exception e) {                                                                                           
			super.LOGGER.error("Ocorreu um erro na classe: EvandroService >> listarTodos(): " + e.getMessage());            
			
		}                                                                                                                 
		return retorno;                                                                                                   
	}                                                                                                                     
                                                                                                                       
	@Override                                                                                                             
	public Country buscarPorId(Long id) throws Exception {                                                                   
		Optional<Country> retorno = null;                                                                                    
		try {                                                                                                             
			retorno = this.geradorRepository.findById(id);                                                                
		} catch (Exception e) {                                                                                           
			super.LOGGER.error("Ocorreu um erro na classe: EvandroService >> buscarPorId(Long id): " + e.getMessage());     
			                                                           
		}                                                                                                                 
		return retorno.get();                                                                                             
	}                                                                                                                     
                                                                                                                       
	@Transactional                                                                                                        
	@Override                                                                                                             
	public Country salvar(Country evandro) throws Exception {                                                                      
		Country retorno = new Country();                                                                                        
		try {                                                                                                             
			validarCamposObrigatorioSalvar(evandro);                                                                         
			retorno = this.geradorRepository.save(evandro);                                                                  
		} catch (Exception e) {                                                                                           
			super.LOGGER.error(                                                                                           
					"Ocorreu um erro na classe: EvandroService >> salvar(ObjetoDominio objetoDominio): " + e.getMessage()); 
			                                                           
		}                                                                                                                 
		return retorno;                                                                                                   
	}                                                                                                                     
                                                                                                                       
	/**                                                                                                                   
	 * @param evandro                                                                                                        
	 *                                                                                                                    
	 *             Método responsável por validar se todos os campos obrigatórios                                         
	 *             foram informados antes da operação de salva                                                            
	 * @throws Exception                                                                                                  
	 */                                                                                                                   
	private void validarCamposObrigatorioSalvar(Country evandro) throws Exception {                                             
		StringBuilder camposNaoInformados = new StringBuilder();                                                          
                                                                                                                       
		camposNaoInformados.append("[ ");                                                                                 
		if (evandro.getPreco() <= 0) {                                                                         
			camposNaoInformados.append("preco");                                                                            
         camposNaoInformados.append(",");                                                                                                                       
		}                                                                                                                 
		camposNaoInformados.append(" ]");                                                                                 
                                                                                                                       
		if (camposNaoInformados.toString().trim().length() > 4) {                                                         
//			RetornoException retorno = new RetornoException(201, "201", MessageFormat.format("Campos obrigatórios não informados: {0}.", camposNaoInformados.toString()));    
//			throw new Exception(gson.toJson(retorno));
		}                                                                                                                 
	}                                                                                                                     
                                                                                                                       
	@Transactional                                                                                                        
	@Modifying                                                                                                            
	@Override                                                                                                             
	public Country editar(Country evandro) throws Exception {                                                                      
		Country retorno = new Country();                                                                                        
		try {                                                                                                             
			retorno = this.geradorRepository.save(evandro);                                                                  
		} catch (Exception e) {                                                                                           
			super.LOGGER.error(                                                                                           
					"Ocorreu um erro na classe: EvandroService >> editar(ObjetoDominio objetoDominio): " + e.getMessage());  
//			throw new Exception(gson.toJson(retornoException));                                                           
		}                                                                                                                 
		return retorno;                                                                                                   
	}                                                                                                                     
                                                                                                                       
	@Transactional                                                                                                        
	@Override                                                                                                             
	public void deletar(Long id) throws Exception {                                                                       
		try {                                                                                                             
			this.geradorRepository.deleteById(id);                                                                        
		} catch (Exception e) {                                                                                           
			super.LOGGER.error("Ocorreu um erro na classe: EvandroService >> (Long id): " + e.getMessage());               
//			throw new Exception(gson.toJson(retornoException));                                                           
		}                                                                                                                 
	}                                                                                                                     
                                                                                                                       
}                                                                                                                      
