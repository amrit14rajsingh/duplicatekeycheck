package com.tarento.duplicatekeycheck;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tarento.duplicatekeycheck.controller.DuplicatekeycheckController;
import com.tarento.duplicatekeycheck.domain.ApplicationResponse;
import com.tarento.duplicatekeycheck.domain.Employee;
import com.tarento.duplicatekeycheck.service.KeyCheckService;



@RunWith(SpringRunner.class)
@WebMvcTest(DuplicatekeycheckController.class)
public class DuplicatekeycheckControllerTest {

	@MockBean
	private KeyCheckService keyCheckService;

	@Autowired
	private MockMvc mvc;
	// This object will be magically initialized by the initFields method below.
	private JacksonTester<ApplicationResponse> json;

	@Before
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void testDuplicatekeycheckController() throws Exception{
		fail("Not yet implemented");
	}

	@Test
	public void testCreateEmployeeTrue() throws Exception{
		fail("Not yet implemented");
	}

	@Test
	public void testCreateEmployeeFalse() throws Exception{
		//given
		Employee e1 = new Employee("A1001","Amrit","Raj","Computer",1000);
		ApplicationResponse applicationResponse = new ApplicationResponse();
		applicationResponse.setData(e1);
		applicationResponse.setResponseMessage("duplicate-false");
		applicationResponse.setStatusCode(201);

		//when
		 mvc.perform(post("/duplicatecheck")
				.content(asJsonString(e1))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
