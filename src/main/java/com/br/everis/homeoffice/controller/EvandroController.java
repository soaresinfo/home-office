package com.br.everis.homeoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.everis.homeoffice.model.domain.Evandro;
import com.br.everis.homeoffice.model.service.fachada.IEvandroServiceFachada;

import io.swagger.annotations.ApiOperation;

/**
 * @author alan.franco
 * 
 */
@RestController
@RequestMapping("/evandro")
public class EvandroController extends BaseController {

	@Autowired
	private IEvandroServiceFachada evandroServiceFachada;

	public EvandroController() {
		super();
	}

	@ApiOperation(value = "Recuperar e listar todos os registos.")
	@RequestMapping(value = "/listar-todos", method = RequestMethod.GET)
	public ResponseEntity<Object> listarTodos() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(evandroServiceFachada.listarTodos());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@ApiOperation(value = "Recuperar um registro de acordo com id passado como parâmetro.")
	@RequestMapping(value = "/buscar-por-id", method = RequestMethod.GET)
	public ResponseEntity<Object> buscarPorId(Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(evandroServiceFachada.buscarPorId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@ApiOperation(value = "Salvar um novo registro no banco.")
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ResponseEntity<Object> salvar(Evandro evandro) {
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(evandroServiceFachada.salvar(evandro));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@ApiOperation(value = "Editar um registro de acordo com o id informado na requisição.")
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> editar(@PathVariable("id") Long id, @RequestBody Evandro evandro) {
		try {
			evandro.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(evandroServiceFachada.editar(evandro));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@ApiOperation(value = "Deletar um registro de acordo com o id informado na requisição.")
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> deletar(@PathVariable("id") Long id) {
		try {
			evandroServiceFachada.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Registro excluído com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
