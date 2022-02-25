package br.ester.sp.quiosque.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Cliente {
	
	private Long id;
	private String nome;
	private String endereco;
	private String numero;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar nascimento;
	private String email;
	private String produto;
	private String genero;
	private Calendar dataCadastro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
		
	public int getIdade() {
		int dia = nascimento.get(Calendar.DAY_OF_MONTH);
		int mes = nascimento.get(Calendar.MONTH);
		int ano = nascimento.get(Calendar.YEAR);
		LocalDate dataNasc = LocalDate.of(ano, mes+1, dia);
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		return periodo.getYears();
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	 
	
}
