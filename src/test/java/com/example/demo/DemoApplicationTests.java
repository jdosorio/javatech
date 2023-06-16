package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.models.RequestModel;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

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

}
