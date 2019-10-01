package com.br.everis.homeoffice.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.br.everis.homeoffice.model.domain.Center;
import com.br.everis.homeoffice.model.domain.Status;
import com.br.everis.homeoffice.model.service.fachada.ICenterServiceFachada;

/**
 * @author Marcelo
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CenterControllerTest {

	@InjectMocks
	private CenterController controller;
	
	@Mock
	private ICenterServiceFachada service;
	 
	
	@Test
	public void testSalvaCenter400BadRequest() {
		Center center = getCenter();
		center.setIdCenter(0L);
		
		Mockito.when(service.save(ArgumentMatchers.eq(center))).thenReturn(center);
		ResponseEntity<Void> ret = controller.save(center);
		
		Assertions.assertThat(ret).isNotNull();
		Assertions.assertThat(ret.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void testSalvaCenter200Ok() {
		Center center = getCenter();
		center.setIdCenter(1L);
		
		Mockito.when(service.save(ArgumentMatchers.eq(center))).thenReturn(center);
		ResponseEntity<Void> ret = controller.save(center);
		
		Assertions.assertThat(ret).isNotNull();
		Assertions.assertThat(ret.getStatusCode()).isEqualTo(HttpStatus.OK);
		Mockito.verify(service, Mockito.times(1)).save(ArgumentMatchers.eq(center));
	}
	
	@Test
	public void testBuscaCenter200Ok() {
		Center center = getCenter();
		List<Center> list = new ArrayList<Center>();
		list.add(center);
		
		Mockito.when(service.findAll()).thenReturn(list);
		ResponseEntity<List<Center>> ret = controller.buscaTodos();
		
		Assertions.assertThat(ret).isNotNull();
		Assertions.assertThat(ret.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(ret.getBody().size()).isEqualTo(1);
	}
	
	private Center getCenter() {
		return Center.builder()
				.city("Uberlândia")
				.country("BR")
				.state("MG")
				.registrationDate(LocalDateTime.now())
				.status(Status.ATIVO)
				.build();
	}
}
