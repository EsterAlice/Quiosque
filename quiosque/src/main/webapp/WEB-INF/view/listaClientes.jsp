<%@page import="java.time.LocalDateTime"%>
<%@page import="org.springframework.format.annotation.DateTimeFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Lista de Clientes</h1>
	<table border="1">
		<tr>
			<th>Id:</th>
			<th>Nome:</th>
			<th>Endereço:</th>
			<th>Número para Contato:</th>
			<th>Gênero:</th>
			<th>Produto:</th>
			<th>Data Nascimento:</th>
			<th>Alterar</th>
			<th>Excluir</th>
			
			
		</tr>
		
		 <c:forEach items="${cliente }" var="j">
		<tr>
		<td>${j.id }</td>
		<td>${j.nome }</td>
		<td>${j.endereco}</td>
		<td>${j.numero }</td>
		<td>${j.genero }</td>
		<td>${j.produto }</td>
		<td><fmt:formatDate value="${j.nascimento.time}" pattern="yyyy-MM-dd"/></td>
			<td><a href="alterarCliente?idCliente= ${j.id }">Alterar</a></td>
			<td><a href="excluirCliente?idCliente= ${j.id }" onclick="return confirm('Confirmar exclusão do Cliente ${j.nome }?')">Excluir</a></td>
			
					
	</tr>
		  </c:forEach>
		
		
		
	</table>

</body>
</html>