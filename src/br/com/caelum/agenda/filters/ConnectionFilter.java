package br.com.caelum.agenda.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.agenda.ConnectionFactory;

@WebFilter("/mvc")
public class ConnectionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			
			Connection conn = new ConnectionFactory().getConnection();
			
			request.setAttribute("conexao", conn);
			chain.doFilter(request, response);
			
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao abrir/fechar connection", e);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {
		
	}
}
