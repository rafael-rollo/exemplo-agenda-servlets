package br.com.caelum.agenda.logica;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.agenda.modelo.Logica;

public class DetalhesContato implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Connection connection = (Connection) request.getAttribute("conexao");
		Contato contato = new ContatoDao(connection).buscaPorId(id);
		request.setAttribute("contato", contato);
		
		return "/WEB-INF/views/form-contato.jsp";
	}

}
