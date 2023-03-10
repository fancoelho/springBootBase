package com.app.domain;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	private MockMvc mockmvc;
	
	@Test
	void insertTvlTestOK() throws Exception {
		mockmvc.perform(post("/tvl/records").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	
	@Test
	@SqlGroup({
		@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD,scripts = "/test-data.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD,statements = "delete from tabela;")
	})
	void insertTvlTestNotOK_BDUnavailable() throws Exception {
		mockmvc.perform(post("/tvl/records").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is5xxServerError());
	}

}
