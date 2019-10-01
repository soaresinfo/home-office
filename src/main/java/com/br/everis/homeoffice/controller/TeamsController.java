package com.br.everis.homeoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.everis.homeoffice.model.domain.Team;
import com.br.everis.homeoffice.model.service.fachada.ITeamServiceFacade;

@RestController
@RequestMapping("/teams")
public class TeamsController extends BaseController {

	@Autowired
	private ITeamServiceFacade service;
	
	@GetMapping
	public ResponseEntity<List<Team>> getAll() throws Exception {
		return ResponseEntity.ok(service.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Team obj) throws Exception {
		Team ret = service.create(obj);
		if (ret.getIdTeam() > 0) {
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
