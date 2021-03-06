package com.br.everis.homeoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.everis.homeoffice.model.entity.Center;
import com.br.everis.homeoffice.model.service.ServiceFacade.ICenterServiceFacade;

/**
 * @author Marcelo
 *
 */
@RestController
@RequestMapping(value = "/center")
public class CenterController extends BaseController{

	@Autowired
	private ICenterServiceFacade centerService;
	
	@GetMapping
	public ResponseEntity<List<Center>> buscaTodos(){
		return ResponseEntity.ok(centerService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Center center){
		Center ret = centerService.save(center);
		if (ret.getIdCenter() > 0) {
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
}
