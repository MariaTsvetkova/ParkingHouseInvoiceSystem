package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import requestsdev.InvoiceGenerate;
import temp.TempDatas;

public class InvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InvoiceServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("it is server invoicing creation and data is " + request.getParameter("isic"));
		InvoiceGenerate invoice = new InvoiceGenerate(request.getParameter("isic"),
				Integer.valueOf(request.getParameter("month")));
		String json = new Gson().toJson(invoice.getInvoice());
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
