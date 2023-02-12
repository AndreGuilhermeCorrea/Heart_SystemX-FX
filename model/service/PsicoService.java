package model.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.Alert.AlertType;
import model.dao.impl.PsicoDaoJDBC;
import model.entities.Psico;
import util.Alertas;

public class PsicoService {
	private PsicoDaoJDBC dao;
	private Psico objPsico;

	public PsicoService() {
		this.dao = new PsicoDaoJDBC();
	}

	public void findByCpf(String cpf) {
		dao.findByCPF(cpf);
	}

	public void insert(Psico objPsico) {
		dao.insert(objPsico);
	}

	public void update(Psico objPsico) {
		dao.update(objPsico);
	}

	public void deleteByCpf(String cpf) {
		dao.deleteByCpf(cpf);
	}

	// método que recebe uma string e retorna um objeto carregado além de formatar
	// os campos de data
	public Psico pesquisaView(String cpf) {
		objPsico = dao.findByCPF(cpf);
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String strDt = formato.format(objPsico.getDtCadastroHP());
		Date dtUtil;
		try {
			dtUtil = formato.parse(strDt);
			objPsico.setDtCadastroHP(dtUtil);
		} catch (ParseException e) {
			Alertas.showAlert(null, "Date Error!: ", e.getMessage(), AlertType.ERROR);
		}
		return objPsico;
	}

}
