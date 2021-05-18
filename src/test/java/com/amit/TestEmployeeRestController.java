package com.amit;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class TestEmployeeRestController {

	@Autowired
	private MockMvc mocMvc;

	@Test
	//@Disabled
	public void testSaveEmployee() throws Exception {
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/employee/save")
				.contentType(MediaType.APPLICATION_JSON).content("{\"empName\":\"Sam\",\"empSal\":3300}");

		MvcResult result = mocMvc.perform(req).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		if (!response.getContentAsString().contains("Employee Saved")) {
			fail("Save Employee Not Working");
		}

	}

	@Test
	//@Disabled
	public void testGetAllEmployee() throws Exception {

		// 1.create dummy request
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/employee/all");

		// 2.execute request and get respopnse

		MvcResult result = mocMvc.perform(req).andReturn();

		// 3.Read Response
		MockHttpServletResponse response = result.getResponse();
		// 4.is status is 200
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
		if (response.getContentAsString().length() <= 0) {
			fail(" No Data Ptovided ");
		}

	}

	@Test
	//@Disabled
	public void testGetOneEmployeeExist() throws Exception {

		// 1.create dummy request
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/employee/one/2");

		// 2.execute request and get respopnse

		MvcResult result = mocMvc.perform(req).andReturn();

		// 3.Read Response
		MockHttpServletResponse response = result.getResponse();
		// 4.is status is 200
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
		if (response.getContentAsString().isEmpty()) {
			fail("Employee Data Not Provided");
		}

	}

	@Test
	public void testGetOneEmployeeNotExist() throws Exception {

		// 1.create dummy request
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/employee/one/30");

		// 2.execute request and get respopnse

		MvcResult result = mocMvc.perform(req).andReturn();

		// 3.Read Response
		MockHttpServletResponse response = result.getResponse();
		// 4.is status is 200
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
		// assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
		if (!response.getContentAsString().equals("Employee Not Exist")) {
			fail("May be data exist,please check again");
		}

	}

}
