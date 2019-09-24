package com.br.everis.homeoffice.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.br.everis.homeoffice.model.domain.Country;
import com.br.everis.homeoffice.model.domain.Profile;
import com.br.everis.homeoffice.model.repository.CountryRepository;
import com.br.everis.homeoffice.model.repository.ProfileRepository;
import com.br.everis.homeoffice.model.service.fachada.IProfileServiceFachada;

public class ProfileService extends BaseService implements IProfileServiceFachada {
	
	/**
	 * Injetando as dependências da interface de abstração do spring data
	 * responsável pelo acesso aos dados deste objeto
	 */
	@Autowired
	private ProfileRepository geradorRepository;
	
	@Override
	public List<Profile> listarTodos() throws Exception {
		List<Profile> retorno = new ArrayList<Profile>();
		try {
			retorno = this.geradorRepository.findAll();
		} catch (Exception e) {
			super.LOGGER.error("Ocorreu um erro na classe: ProfileService >> listarTodos(): " + e.getMessage());
			throw new Exception(e.getMessage());
		}
		return retorno;
	}
	
	@Override
	public Profile buscarPorId(Long id) {
		Optional<Profile> result = this.geradorRepository.findById(id);
		if (result.equals(null) || !result.isPresent()) {
			return new Profile();
		}
		return result.get();
	}

	@Transactional
	@Override
	public Profile salvar(Profile profile) throws Exception {
		Profile retorno = new Profile();
		try {
			retorno = this.geradorRepository.save(profile);
		} catch (Exception e) {
			super.LOGGER.error("Ocorreu um erro na classe: ProfileService >> salvar(ObjetoDominio objetoDominio): "
					+ e.getMessage());
			throw new Exception(e.getMessage());
		}
		return retorno;
	}

	@Transactional
	@Modifying
	@Override
	public Profile editar(Profile profile) throws Exception {
		Profile retorno = new Profile();
		try {
			retorno = this.geradorRepository.save(profile);
		} catch (Exception e) {
			super.LOGGER.error("Ocorreu um erro na classe: ProfileService >> editar(ObjetoDominio objetoDominio): "
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
			super.LOGGER.error("Ocorreu um erro na classe: ProfileService >> (Long id): " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

}
