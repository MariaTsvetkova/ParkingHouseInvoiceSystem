package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class InvoiceServletTest {

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
	public void testInvoiceServlet() throws ServletException, IOException {
		request.setParameter("isic", "33302100225");
		request.setParameter("month", "2");

		servlet.doGet(request, response);
		assertEquals("application/json", response.getContentType());
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() {

	}

}
