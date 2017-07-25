package br.com.caelum.agenda.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.modelo.Logica;

@WebServlet("/mvc")
@SuppressWarnings("serial")
public class ControllerServlet extends HttpServlet {

	private static final String BASE_PACKAGE = "br.com.caelum.agenda.logica.";
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String operation = request.getParameter("logica");
		Logica logica = null;
		
		try {
			Class<?> clazz = Class.forName(BASE_PACKAGE + operation);
			logica = (Logica) clazz.newInstance();			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao instanciar a logica", e);
		}
		
		String nextStep = logica.executa(request, response);
		request.getRequestDispatcher(nextStep).forward(request, response);
		
	}
}
