package model.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.Alert.AlertType;
import model.dao.impl.ClienteDaoJDBC;
import model.entities.Cliente;
import model.entities.ClienteView;
import util.Alertas;
import util.Masks;

public class ClienteService {
	private ClienteDaoJDBC dao;
	private Cliente objClient;
	private ClienteView c2;

	public ClienteService() {
		this.dao = new ClienteDaoJDBC();
		this.objClient = new Cliente();
		this.c2 = new ClienteView();
	}

	public void findByCpf(String cpf) {
		dao.findByCPF(cpf);
	}

	public void insert(Cliente objClient) {
		dao.insert(objClient);
	}

	public void update(Cliente objClient) {
		dao.update(objClient);
	}

	public void deleteByCpf(String cpf) {
		dao.deleteByCpf(cpf);
	}

	// m�todo que recebe uma string e retorna um objeto carregado al�m de formatar
	// os campos de data e data de Nascimento
	public ClienteView pespesquisaCPFeNome(String cpf) {
		c2 = dao.pespesquisaCPFeNome(cpf);
		// formatador para dd/mm/aaaa
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// conversao da data java.util para string com o formato
		String strDt = formato.format(c2.getNascimento());
		// variável data java.util
		Date dtUtil;
		try {
			// conversão da string novamente em data java.util
			dtUtil = formato.parse(strDt);
			// setando o nascimento no formato
			c2.setNascimento(dtUtil);
			// variável tipo int idade com a comversao de string vinda do método de
			// calculo(masksSwing)
			int idade = Integer.parseInt(Masks.calcIdade(strDt));
			// setando a idade
			c2.setIdade(idade);
		} catch (ParseException e) {
			Alertas.showAlert(null, "Date Error!: ", e.getMessage(), AlertType.ERROR);
		}
		return c2;
	}

	// m�todo que recebe uma string e retorna um objeto carregado al�m de formatar
	// os campos de data
	public Cliente pesquisaView(String cpf) {
		objClient = dao.findByCPF(cpf);
		// formatador para dd/mm/aaaa
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// conversao da data java.util para string com o formato
		String strDt = formato.format(objClient.getNascimento());
		// variável data java.util
		Date dtUtil;
		try {
			// conversão da string novamente em data java.util
			dtUtil = formato.parse(strDt);
			// setando o nascimento no formato
			objClient.setNascimento(dtUtil);
			// variável tipo int idade com a comversao de string vinda do método de
			// calculo(masksSwing)
			int idade = Integer.parseInt(Masks.calcIdade(strDt));
			// setando a idade
			objClient.setIdade(idade);
		} catch (ParseException e) {
			Alertas.showAlert(null, "Date Error!: ", e.getMessage(), AlertType.ERROR);
		}
		return objClient;
	}

}
