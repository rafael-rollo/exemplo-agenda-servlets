package br.com.caelum.agenda.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.modelo.Logica;

public class AdicionaContato implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		return "/WEB-INF/views/form-contato.jsp";
	}

}
