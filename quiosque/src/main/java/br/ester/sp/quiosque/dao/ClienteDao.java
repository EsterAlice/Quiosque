package br.ester.sp.quiosque.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.ui.Model;

import br.ester.sp.quiosque.model.Cliente;

public class ClienteDao {
	private Connection conexao;

	public ClienteDao() {
		conexao = ConnectionFactory.conectar();
	}
	public void inserir( Cliente cliente) {
		String sql = "Insert into tb_cliente (nome, endereco, nascimento, numero, genero, email, produto) values(?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setDate(3, new Date(cliente.getNascimento().getTimeInMillis()));
			// stmt.setDate(4, new Date (cliente.getData().getTimeInMillis()));
			stmt.setString(4, cliente.getNumero());
			stmt.setString(5, cliente.getGenero());
			stmt.setString(6, cliente.getEmail());
			stmt.setString(7, cliente.getProduto());
			stmt.execute();
			stmt.close();
			conexao.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public List<Cliente> listar() {
		String sql = "select * from tb_cliente order by nome asc";
		PreparedStatement stmt;
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente j = new Cliente();
				j.setId(rs.getLong("id"));
				j.setNome(rs.getString("nome"));
				j.setEndereco(rs.getString("endereco"));
				j.setNumero(rs.getString("numero"));
				j.setGenero(rs.getString("genero"));
				j.setEmail(rs.getString("email"));
				j.setProduto(rs.getString("produto"));
				
				// criar um calendar com a data atual
				Calendar nasc = Calendar.getInstance();
				Calendar cad = Calendar.getInstance();
				// extrair o java.sql.Date do BD
				Date nascDB = rs.getDate("nascimento");
				Timestamp cadDB = rs.getTimestamp("data_do_cadastro");
				// passar o long do java.sql.Date para o Calendar
				nasc.setTimeInMillis(nascDB.getTime());
				cad.setTimeInMillis(cadDB.getTime());
				// "setar" o nascimento no jogador
				j.setNascimento(nasc);
				j.setDataCadastro(cad);;
				// c.setData(cad);
				lista.add(j);
				
			}
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(long idCliente) {
		String sql = "delete from tb_cliente where id = ?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idCliente);
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
	
	public void atualizar(Cliente cliente) {
		String sql = "update tb_cliente set nome = ?, endereco = ?, nascimento = ?,numero = ?, genero = ?, email = ?, produto = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setDate(3, new Date(cliente.getNascimento().getTimeInMillis()));
			stmt.setString(4, cliente.getNumero());
			stmt.setString(5, cliente.getGenero());
			stmt.setString(6, cliente.getEmail());
			stmt.setString(7, cliente.getProduto());
			stmt.setLong(8, cliente.getId());
			
			
			stmt.execute();
			stmt.close();
			conexao.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cliente buscar(long idCliente) {
		String sql = "select * from tb_cliente where id = ?";
		PreparedStatement stmt;
		Cliente j = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idCliente);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
			j = new Cliente();
				j.setId(rs.getLong("id"));
				j.setNome(rs.getString("nome"));
				j.setEndereco(rs.getString("endereco"));
				j.setNumero(rs.getString("numero"));
				j.setEmail(rs.getString("email"));
				j.setProduto(rs.getString("produto"));				
				j.setGenero(rs.getString("genero"));
				Calendar nasc = Calendar.getInstance();
				Date nascDB = rs.getDate("nascimento");
				nasc.setTimeInMillis(nascDB.getTime());
				j.setNascimento(nasc);
				
			}
			rs.close();
			stmt.close();
			conexao.close();
			return j;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
	
	


