<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="heading" value="${contato.id != null ? 'Atualizar Contato' : 'Adicionar Contato' }"/>
<title>${heading }</title>
</head>
<body>
	<h1>${heading }</h1>
	<hr/>
	
	<form action="mvc?logica=SalvaContato" method="post">
	
		<c:if test="${contato.id != null}">
			<input type="hidden" name="id" value="${contato.id }">
		</c:if>
	
		<div>
			<label for="nome">Nome:</label>
			<input type="text" id="nome" name="nome" value="${contato.nome }"/>
		</div>
		
		<div>
			<label for="email">Email:</label>
			<input type="text" id="email" name="email" value="${contato.email }"/>
		</div>
		
		<div>
			<label for="endereco">Endereco:</label>
			<input type="text" name="endereco" value="${contato.endereco }"/>
		</div>
		
		<div>
			<label for="dataNascimento">Data de Nascimento:</label>
			<input type="text" id="dataNascimento" name="dataNascimento" 
				value="<fmt:formatDate pattern="dd/MM/yyyy" value="${contato.dataNascimento.time}"/>"/>
		</div>
	
		<div>
			<input type="submit" value="Salvar" />
		</div>
	
	</form>

</body>
</html>