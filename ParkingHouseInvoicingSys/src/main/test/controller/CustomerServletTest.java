package controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class CustomerServletTest {
	private CustomerServlet servlet;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void setUp() throws Exception {
		servlet = new CustomerServlet();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();

	}

	@Test
	public void testCustomerServlet() throws ServletException, IOException {
		servlet.doGet(request, response);
		assertEquals("application/json", response.getContentType());
	}

}
