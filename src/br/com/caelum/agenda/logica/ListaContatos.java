package br.com.caelum.agenda.logica;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.agenda.modelo.Logica;

public class ListaContatos implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		List<Contato> contatos = new ContatoDao(connection).getLista();
		request.setAttribute("contatos", contatos);
		
		return "/WEB-INF/views/lista-contatos.jsp";
	}

}
