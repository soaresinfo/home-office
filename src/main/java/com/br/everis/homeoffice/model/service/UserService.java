package com.br.everis.homeoffice.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.br.everis.homeoffice.model.domain.User;
import com.br.everis.homeoffice.model.repository.UserRepository;
import com.br.everis.homeoffice.model.service.fachada.IUserServiceFachada;

public class UserService extends BaseService implements IUserServiceFachada {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> listarTodos() throws Exception {
		List<User> retorno = new ArrayList<User>();
		try {
			retorno = this.userRepository.findAll();
		} catch (Exception e) {
			super.LOGGER.error("Ocorreu um erro na classe: UserService >> listarTodos(): " + e.getMessage());
			throw new Exception(e.getMessage());
		}
		return retorno;
	}
	
	@Override
	public User buscarPorId(Long id) {
		Optional<User> result = this.userRepository.findById(id);
		if (result.equals(null) || !result.isPresent()) {
			return new User();
		}
		return result.get();
	}

	@Transactional
	@Override
	public User salvar(User user) throws Exception {
		User retorno = new User();
		try {
			retorno = this.userRepository.save(user);
		} catch (Exception e) {
			super.LOGGER.error("Ocorreu um erro na classe: UserService >> salvar(ObjetoDominio objetoDominio): "
					+ e.getMessage());
			throw new Exception(e.getMessage());
		}
		return retorno;
	}
	
	@Transactional
	@Modifying
	@Override
	public User editar(User user) throws Exception {
		User retorno = new User();
		try {
			retorno = this.userRepository.save(user);
		} catch (Exception e) {
			super.LOGGER.error("Ocorreu um erro na classe: UserService >> editar(ObjetoDominio objetoDominio): "
					+ e.getMessage());
			throw new Exception(e.getMessage());

		}
		return retorno;
	}
	
	@Transactional
	@Override
	public void deletar(Long id) throws Exception {
		try {
			this.userRepository.deleteById(id);
		} catch (Exception e) {
			super.LOGGER.error("Ocorreu um erro na classe: UserService >> (Long id): " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
}
