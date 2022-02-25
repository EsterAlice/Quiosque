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
<style>
	*{
margin:0;
	padding:0;
}
form{
	width:20%;
	margin:auto;
	font-family:arial;
	
}
table{
	background-color:Lavender;	
}

input:focus,select:focus, textarea:focus{
	
	border:2px solid pink;
	outline:none;
}
 input[type="email"],input[type="text"], select, textarea{
		display:block;
		width:100%;
		box-sizing:border-box;
		padding:10px;
		background-color:GhostWhite;
		border-radius:5px;
	border:none;
}
p{
	margin-bottom:2;
}
label{
	margin-top:20px;
	display:inline-block;
	
}
button[type="submit"]{
	background-color:LightCoral;
	padding:15px;
	color:white;
	border-radius:5px;
	border:none;
}

	
	</style>
					
<body>
<form action="salvar" method="post">
		<input type="hidden" name="id" value="${cliente.id }">
		<h1>Cadastro de Cliente</h1>
		
		<table>
			<tr>
				<td><label>Nome:</label></td>
				<td><input type="text" name="nome"  value="${cliente.nome }" required /></td>
			</tr>

			<tr>
				<td><label>Endereço:</label></td>
				<td><input type="text" name="endereco" value="${cliente.endereco }"required /></td>
			</tr>
			
			<tr>
				<td><label>Nascimento:</label></td>
				<td><input type="date" name="nascimento" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${cliente.nascimento.time }"/>' required /></td>
			</tr>

			<tr>
				<td><label>Número para Contato:</label></td>
				<td><input type="tel" name="numero" value="${cliente.numero }" minlength="3" maxlength="11" required /></td>
			</tr>
			
			<tr>
			
			<td><label>Genêro</label></td>
			<td><select name="genero" required>
					<option name="masc" value="masculino" ${cliente.genero.equals("masculino") ? "selected" : "" } required >Masculino</option>
					<option name="fem" value="feminino" ${cliente.genero.equals("feminino") ? "selected" : "" } required>Feminino</option>
					<option name="outro" value="outros" ${cliente.genero.equals("outros") ? "selected" : "" } required>Outros</option>
					
			</select>
			</tr>

			<tr>
				<td><label>Email:</label></td>
				<td><input type="email" name="email" value ="${cliente.email }"required /></td>
			</tr>

			<tr>
				<td><label>Produto:</label></td>
				<td><input type="text" name="produto" value="${cliente.produto }" required /></td>
			</tr>
			
			<tr>
				<td><button type="submit">Salvar</button></td>
			</tr>
		</table>
	</form>

</body>
</html>