package br.com.caelum.agenda.logica;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.agenda.modelo.Logica;

public class SalvaContato implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String data = request.getParameter("dataNascimento");

		Calendar dataNascimento = null;
		Date date = null;
		
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			throw new RuntimeException("Não foi possível converter a data", e);
		}
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		Connection connection = (Connection) request.getAttribute("conexao");
		ContatoDao contatoDao = new ContatoDao(connection);
		
		if(id == null || id.isEmpty()) {
			contatoDao.adiciona(contato);			
		} else {
			contato.setId(Long.parseLong(id));
			contatoDao.atualiza(contato);
		}
		
		return "mvc?logica=ListaContatos";
	}

	
}
