//package com.br.everis.homeoffice.model.service;
//
//import com.br.everis.homeoffice.model.domain.Status;
//import com.br.everis.homeoffice.model.entity.Center;
//import com.br.everis.homeoffice.model.repository.CenterRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Marcelo
// */
//@RunWith(MockitoJUnitRunner.class)
//public class CenterServiceTest {
//
//    @InjectMocks
//    private CenterService service;
//
//    @Mock
//    private CenterRepository repository;
//
//    @Test
//    public void testCenterServiceFindAll() {
//        List<Center> list = new ArrayList<Center>();
//        list.add(getCenter());
//
//        Mockito.when(repository.findAll()).thenReturn(list);
//        List<Center> ret = service.findAll();
//
//        Mockito.verify(repository, Mockito.times(1)).findAll();
//        Assertions.assertThat(ret).isNotNull();
//        Assertions.assertThat(ret).isNotEmpty();
//        Assertions.assertThat(ret).hasSize(1);
//    }
//
//    @Test
//    public void testCenterServiceFindAllException() {
//        List<Center> list = new ArrayList<Center>();
//        list.add(getCenter());
//
//        Mockito.when(repository.findAll()).thenThrow(RuntimeException.class);
//        List<Center> ret = service.findAll();
//
//        Mockito.verify(repository, Mockito.times(1)).findAll();
//        Assertions.assertThat(ret).isEmpty();
//    }
//
//    @Test
//    public void testCenterServiceSave() {
//        Center center = Mockito.spy(getCenter());
//
//        Mockito.when(repository.save(ArgumentMatchers.eq(center))).thenReturn(center);
//        Center ret = service.save(center);
//
//        Mockito.verify(center, Mockito.never()).setState(ArgumentMatchers.anyString());
//        Assertions.assertThat(ret).isNotNull();
//    }
//
//    @Test
//    public void testCenterServiceSaveNoState() {
//        Center center = Mockito.spy(getCenter());
//        center.setState(null);
//
//        Mockito.when(repository.save(ArgumentMatchers.eq(center))).thenReturn(center);
//        Center ret = service.save(center);
//
//        Mockito.verify(center, Mockito.times(1)).setState(ArgumentMatchers.anyString());
//        Assertions.assertThat(ret).isNotNull();
//        Assertions.assertThat(ret.getState()).isEqualTo("N/A");
//    }
//
//    private Center getCenter() {
//        return Center.builder()
//                .city("Uberlândia")
//                .country("BR")
//                .state("MG")
//                .registrationDate(LocalDateTime.now())
//                .status(Status.ATIVO)
//                .build();
//    }
//}
