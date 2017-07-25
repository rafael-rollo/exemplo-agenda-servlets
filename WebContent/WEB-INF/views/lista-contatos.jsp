<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meus Contatos</title>
</head>
<body>
	<h1>Contatos</h1>
	<hr/>
	<a href="mvc?logica=AdicionaContato">Novo Contato</a>
	<table>
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereco</td>
			<td>Data de Nascimento</td>
			<td>Ações</td>
		</tr>
		<c:forEach var="contato" items="${contatos}">
			<tr>
				<td>${contato.id }</td>
				<td>${contato.nome }</td>
				<td>${contato.email }</td>
				<td>${contato.endereco }</td>
				<td>
					<fmt:formatDate pattern="dd/MM/yyyy" value="${contato.dataNascimento.time }"/>
				</td>
				<td><a href="mvc?logica=DetalhesContato&id=${contato.id}">Atualizar Contato</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>