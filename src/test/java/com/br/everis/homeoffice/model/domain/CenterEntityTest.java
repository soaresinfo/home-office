//package com.br.everis.homeoffice.model.domain;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//import com.br.everis.homeoffice.model.entity.Center;
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.br.everis.homeoffice.model.repository.CenterRepository;
//
///**
// * @author Marcelo
// *
// */
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/scriptCenterEntity.sql")
//public class CenterEntityTest {
//
//	@Autowired
//	private CenterRepository repository;
//
//	@Test
//	public void testFindAllSucesso() {
//		List<Center> list = repository.findAll();
//
//		Assertions.assertThat(list).isNotNull();
//		Assertions.assertThat(list).isNotEmpty();
//		Assertions.assertThat(list).hasSize(2);
//	}
//
//	@Test
//	public void testFindByIdSucesso() {
//		Center center = repository.findById(1L).get();
//
//		Assertions.assertThat(center.getIdCenter()).isEqualTo(1L);
//		Assertions.assertThat(center.getCity()).isEqualTo("Uberlandia");
//		Assertions.assertThat(center.getRegistrationDate()).isEqualTo(LocalDateTime.of(2019, 9, 20, 0, 0));
//		Assertions.assertThat(center.getCountry()).isEqualTo("BR");
//		Assertions.assertThat(center.getState()).isEqualTo("MG");
//		Assertions.assertThat(center.getStatus()).isEqualTo(Status.ATIVO);
//	}
//
//	@Test
//	public void testFindByIdNotFound() {
//		Optional<Center> opt = repository.findById(3L);
//
//		Assertions.assertThat(opt.isPresent()).isFalse();
//	}
//}
