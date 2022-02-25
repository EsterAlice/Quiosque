<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Realizado por Dia</title>
</head>
<body>
<h1>Cadastro Realizado por Dia</h1>
	<table border="1">
		<tr>
			<th>Segunda-Feira</th>
			<th>Terça-Feira</th>
			<th>Quarta-Feira</th>
			<th>Quinta-Feira</th>
			<th>Sexta-Feira</th>
			<th>Sábado</th>
			<th>Domingo</th>
		</tr>
		
		<tr>
		
		<td>${domingo }</td>
		<td>${segunda }</td>
		<td>${terca }</td>
		<td>${quarta }</td>
		<td>${quinta }</td>	
		<td>${sexta }</td>
		<td>${sabado }</td>				
		
					
	</tr>	
	</table>
	
	<table border="1">
		<tr>
			<th>Masculino</th>
			<th>Feminino</th>
			<th>Outros</th>
		</tr>
		
		
		<tr>
		
		<td>${masculino }</td>
		<td>${feminino }</td>
		<td>${outros }</td>	
					
	</tr>
		  
	</table>
	
	<table border="1">
		<tr>
			<th>Jovem</th>
			<th>Adulto</th>
			<th>Idoso</th>
			
		</tr>
		
		
		<tr>
		
		<td>${jovem }</td>
		<td>${adulto }</td>
		<td>${idoso }</td>	
					
	</tr>
		 
	</table>
	
	<table border="1">
		<tr>
			<th>Manha</th>
			<th>Tarde</th>
			<th>Noite</th>
			
		</tr>
		
		
		<tr>
		
		<td>${manha }</td>
		<td>${tarde }</td>
		<td>${noite }</td>	
					
	</tr>
		 
	</table>
		
</body>
</html>