package br.ester.sp.quiosque.controller;

import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ester.sp.quiosque.dao.ClienteDao;
import br.ester.sp.quiosque.model.Cliente;

@Controller
public class ClienteController {
	@RequestMapping("cadCliente")
	public String cad_cliente() {

		return "cad_cliente";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(Cliente cliente) {
		System.out.println(cliente.getNome());
		System.out.println(cliente.getEndereco());
		System.out.println(cliente.getNumero());
		System.out.println(cliente.getNascimento());
		System.out.println(cliente.getEmail());
		System.out.println(cliente.getProduto());
		System.out.println(cliente.getGenero());

		ClienteDao dao = new ClienteDao();
		if (cliente.getId() == null) {
			dao.inserir(cliente);
		} else {
			dao.atualizar(cliente);
		}

		return "redirect:listaCliente";

	}

	@RequestMapping("listaCliente")
	public String listar(Model model) {
		ClienteDao dao = new ClienteDao();
		model.addAttribute("cliente", dao.listar());
		return "listaClientes";
	}

	@RequestMapping("excluirCliente")
	public String excluir(long idCliente) {
		ClienteDao dao = new ClienteDao();
		dao.excluir(idCliente);
		return "forward:listaCliente";
	}

	@RequestMapping("alterarCliente")
	public String alterar(long idCliente, Model model) {
		ClienteDao dao = new ClienteDao();
		model.addAttribute("cliente", dao.buscar(idCliente));

		return "forward:cadCliente";
	}

	public Calendar data() {
		Calendar data = Calendar.getInstance();
		return data;
	}

	@RequestMapping("filtroCliente")
	public String estatistica(Model model) {
		// String sql = "select COUNT(genero) from tb_cliente where genero = ?";

		List<Cliente> cliente = new ClienteDao().listar();

		int countM = 0;
		int countF = 0;
		int countO = 0;
		int countManha = 0;
		int countTarde = 0;
		int countNoite = 0;
		int periodo = 0;
		int countJ = 0;
		int countA = 0;
		int countI = 0;
		int countSegunda = 0;
		int countTerca = 0;
		int countQuarta = 0;
		int countQuinta = 0;
		int countSexta = 0;
		int countSabado = 0;
		int countDomingo = 0;
		int semana = 0;
		
		for (Cliente c : cliente) {
			if (c.getGenero().equals("masculino")) {
				countM++;
			} else if (c.getGenero().equals("feminino")) {
				countF++;
			} else {
				countO++;
			}

			if (c.getIdade() >= 60) {
				countI++;
			} else if (c.getIdade() >= 18) {
				countA++;
			} else {
				countJ++;
			}

			semana = c.getDataCadastro().get(Calendar.DAY_OF_WEEK);
			
			

			if (semana == 2) {
				countDomingo++;
			} else if (semana == 3) {
				countSegunda++;
			} else if (semana == 4) {
				countTerca++;
			} else if (semana == 5) {
				countQuarta++;
			} else if (semana == 6) {
				countQuinta++;
			} else if (semana == 7) {
				countSexta++;
			} else {
				countSabado++;
			}

			periodo = c.getDataCadastro().get(Calendar.HOUR_OF_DAY);

			if (periodo <= 12) {
				countManha++;
			} else if (periodo <= 18) {
				countTarde++;
			} else {
				countNoite++;
			}
		}
		model.addAttribute("masculino", countM);
		model.addAttribute("feminino", countF);
		model.addAttribute("outros", countO);
		model.addAttribute("idoso", countI);
		model.addAttribute("adulto", countA);
		model.addAttribute("jovem", countJ);
		model.addAttribute("domingo", countDomingo);
		model.addAttribute("segunda", countSegunda);
		model.addAttribute("terca", countTerca);
		model.addAttribute("quarta", countQuarta);
		model.addAttribute("quinta", countQuinta);
		model.addAttribute("sexta", countSexta);
		model.addAttribute("sabado", countSabado);
		model.addAttribute("domingo", countDomingo);
		model.addAttribute("manha", countManha);
		model.addAttribute("tarde", countTarde);
		model.addAttribute("noite", countNoite);

		return "filtro";
	}

}
