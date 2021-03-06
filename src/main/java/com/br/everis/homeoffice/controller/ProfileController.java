package com.br.everis.homeoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.everis.homeoffice.model.domain.Country;
import com.br.everis.homeoffice.model.domain.Profile;
import com.br.everis.homeoffice.model.service.fachada.IProfileServiceFachada;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/profile")
public class ProfileController extends BaseController{
	
	@Autowired
	private IProfileServiceFachada profileServiceFachada;
	
	public ProfileController() {
		super();
	}
	

	@ApiOperation(value = "Recuperar e listar todos os registos.")
	@RequestMapping(value = "/listar-todos", method = RequestMethod.GET)
	public ResponseEntity<Object> listarTodos() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(profileServiceFachada.listarTodos());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@ApiOperation(value = "Recuperar um registro de acordo com id passado como parâmetro.")
	@RequestMapping(value = "/buscar-por-id", method = RequestMethod.GET)
	public ResponseEntity<Object> buscarPorId(Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(profileServiceFachada.buscarPorId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@ApiOperation(value = "Salvar um novo registro no banco.")
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ResponseEntity<Object> salvar(Profile profile) {
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(profileServiceFachada.salvar(profile));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@ApiOperation(value = "Editar um registro de acordo com o id informado na requisição.")
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> editar(@PathVariable("id") Long id, @RequestBody Profile profile) {
		try {
			profile.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(profileServiceFachada.editar(profile));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@ApiOperation(value = "Deletar um registro de acordo com o id informado na requisição.")
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletar(@PathVariable("id") Long id) {
		try {
			profileServiceFachada.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Registro excluído com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
