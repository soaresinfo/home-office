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

	@Override
	public List<Country> listarTodos() throws Exception {
		List<Country> retorno = new ArrayList<Country>();
		try {
			retorno = this.geradorRepository.findAll();
		} catch (Exception e) {
			super.LOGGER.error("Ocorreu um erro na classe: CountryService >> listarTodos(): " + e.getMessage());
			throw new Exception(e.getMessage());
		}
		return retorno;
	}

	@Override
	public Country buscarPorId(Long id) {
		Optional<Country> result = this.geradorRepository.findById(id);
		if (result.equals(null) || !result.isPresent()) {
			return new Country();
		}
		return result.get();
	}

	@Transactional
	@Override
	public Country salvar(Country country) throws Exception {
		Country retorno = new Country();
		try {
			retorno = this.geradorRepository.save(country);
		} catch (Exception e) {
			super.LOGGER.error("Ocorreu um erro na classe: CountryService >> salvar(ObjetoDominio objetoDominio): "
					+ e.getMessage());
			throw new Exception(e.getMessage());
		}
		return retorno;
	}

	@Transactional
	@Modifying
	@Override
	public Country editar(Country country) throws Exception {
		Country retorno = new Country();
		try {
			retorno = this.geradorRepository.save(country);
		} catch (Exception e) {
			super.LOGGER.error("Ocorreu um erro na classe: CountryService >> editar(ObjetoDominio objetoDominio): "
					+ e.getMessage());
			throw new Exception(e.getMessage());

		}
		return retorno;
	}

	@Transactional
	@Override
	public void deletar(Long id) throws Exception {
		try {
			this.geradorRepository.deleteById(id);
		} catch (Exception e) {
			super.LOGGER.error("Ocorreu um erro na classe: CountryService >> (Long id): " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

}
