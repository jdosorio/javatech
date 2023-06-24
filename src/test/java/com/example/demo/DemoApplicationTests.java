package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.controllers.CalculoController;
import com.example.demo.models.RequestModel;
import com.example.demo.models.ResponseModel;
import com.example.demo.services.CalculoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

// Clase que implementa test en la aplicacion, tanto de integracion como unitarios
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	// Se usa mockMvc con el fin de simular la peticion
	@Autowired
	private MockMvc mockMvc;
	// Se usa para mapear al objeto que se necesite
	@Autowired
	private ObjectMapper objectMapper;

	private CalculoService calculoService;

	@InjectMocks
	BindingResult bindingResultMock = mock(BindingResult.class);

	@BeforeEach
	public void setUp() {
		calculoService = new CalculoService();
	}

	// INICIO PRUEBAS INTEGRACION
	// Test para verificar n:187, x:10, y:5 que el resultado sea 184, el cual
	// proviene del atributo data del ResponseModel
	@Test
	void shouldTestOne() throws Exception {
		RequestModel requestModel = new RequestModel();
		requestModel.setParamN(187);
		requestModel.setParamX(10);
		requestModel.setParamY(5);

		mockMvc.perform(post("/api/calculo").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(requestModel)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data").value(185))
				.andDo(print());
	}

	// Test para verificar n:15, x:10, y:5 que el resultado sea 15, el cual
	// proviene del atributo data del ResponseModel
	@Test
	void shouldTestTwo() throws Exception {
		RequestModel requestModel = new RequestModel();
		requestModel.setParamN(15);
		requestModel.setParamX(10);
		requestModel.setParamY(5);

		mockMvc.perform(post("/api/calculo").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(requestModel)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data").value(15))
				.andDo(print());
	}

	@Test
	void shouldHealthCheck() throws Exception {
		// Realiza la solicitud GET al endpoint "/"
		ResultActions resultActions = mockMvc.perform(get("/"));

		// Verifica que se haya devuelto el código de estado 200 OK
		resultActions.andExpect(status().isOk());

		// Verifica que el cuerpo de la respuesta contenga el mensaje esperado
		resultActions.andExpect(content().string("HEALTH CHECK OK! Bienvenido a la prueba tecnica"));
	}

	// FIN PRUEBAS INTEGRACION

	// INICIO PRUEBAS UNITARIAS
	@Test
	// Caso de prueba : Expresion mayor que N
	public void shouldExpressionGreaterThanN() {
		int n = 10;
		int x = 3;
		int y = 2;
		int expected = n - n % x - (x - y);
		int result = calculoService.getCalculo(n, x, y);
		Assertions.assertEquals(expected, result);
	}

	@Test
	// Caso de prueba : Expresion menor que N
	public void shouldExpressionLessThanN() {
		int n = 15;
		int x = 4;
		int y = 3;
		int expected = n - n % x + y;
		int result = calculoService.getCalculo(n, x, y);
		Assertions.assertEquals(expected, result);
	}

	@Test
	// Caso de prueba : cálculo fuera del rango válido
	public void shouldOutOfRange() {
		int n = 5;
		int x = 2;
		int y = 4;
		int expected = -1;

		int result = calculoService.getCalculo(n, x, y);

		Assertions.assertEquals(expected, result);
	}

	@Test
	// Caso de prueba : Cuando "x" es cero, escenario que de no controlarse
	// romperia nuestra logica
	public void shouldXIsZero() {
		int n = 5;
		int x = 0;
		int y = 4;
		int expected = -1;

		int result = calculoService.getCalculo(n, x, y);

		Assertions.assertEquals(expected, result);
	}

	// FIN PRUEBAS UNITARIAS
}
