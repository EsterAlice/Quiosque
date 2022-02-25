package br.ester.sp.quiosque.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String User = "root";
	private static final String Senha = "";
	
	public static Connection conectar() {
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiosque", User, Senha);
		return conexao;
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
}
}

