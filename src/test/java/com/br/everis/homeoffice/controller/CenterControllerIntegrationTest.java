//package com.br.everis.homeoffice.controller;
//
//import com.br.everis.homeoffice.model.domain.Status;
//import com.br.everis.homeoffice.model.entity.Center;
//import com.br.everis.homeoffice.model.service.ServiceFacade.ICenterServiceFachada;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Marcelo
// */
//@RunWith(MockitoJUnitRunner.class)
//public class CenterControllerIntegrationTest {
//
//    @InjectMocks
//    private CenterController controller;
//
//    @Mock
//    private ICenterServiceFachada service;
//
//    private MockMvc mockMvc;
//
//    private ObjectMapper mapper = new ObjectMapper().registerModules(new Jdk8Module(), new JavaTimeModule());
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//    }
//
//    @Test
//    public void testSalvaCenter400BadRequest() throws Exception {
//        Center center = getCenter();
//        center.setIdCenter(0L);
//        String json = mapper.writeValueAsString(center);
//
//        Mockito.when(service.save(ArgumentMatchers.eq(center))).thenReturn(center);
//        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/center").contentType(MediaType.APPLICATION_JSON).content(json));
//        result.andExpect(MockMvcResultMatchers.status().isBadRequest());
//    }
//
//    @Test
//    public void testSalvaCenter200Ok() throws Exception {
//        Center center = getCenter();
//        center.setIdCenter(1L);
//        String json = mapper.writeValueAsString(center);
//
//        Mockito.when(service.save(ArgumentMatchers.eq(center))).thenReturn(center);
//        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/center").contentType(MediaType.APPLICATION_JSON).content(json));
//        result.andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void testBuscaCenter200Ok() throws Exception {
//        Center center = getCenter();
//        center.setIdCenter(Long.MAX_VALUE);
//        List<Center> list = new ArrayList<Center>();
//        list.add(center);
//
//        Mockito.when(service.findAll()).thenReturn(list);
//        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/center").contentType(MediaType.APPLICATION_JSON));
//        result.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status", Matchers.is(center.getStatus().toString())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].country", Matchers.is(center.getCountry())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].state", Matchers.is(center.getState())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].city", Matchers.is(center.getCity())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idCenter", Matchers.is(center.getIdCenter().longValue())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].registrationDate", Matchers.is(center.getRegistrationDate().toString())))
//                .andDo(MockMvcResultHandlers.print());
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
