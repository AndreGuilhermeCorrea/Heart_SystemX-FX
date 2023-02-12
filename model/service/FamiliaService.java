package model.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.Alert.AlertType;
import model.dao.impl.FamiliaDaoJDBC;
import model.entities.Familia;
import util.Alertas;

public class FamiliaService {

	private FamiliaDaoJDBC dao;
	private Familia objFam;

	public FamiliaService() {
		this.dao = new FamiliaDaoJDBC();
	}

	public void findByCPF(String cpf) {
		dao.findByCPF(cpf);
	}

	public void insert(Familia objFam) {
		dao.insert(objFam);
	}

	public void update(Familia objFam) {
		dao.update(objFam);
	}

	public void deleteByCpf(String cpf) {
		dao.deleteByCpf(cpf);
	}

	// método que recebe uma string e retorna um objeto carregado além de formatar
	// os campos de data
	public Familia pesquisaView(String cpf) {
		objFam = dao.findByCPF(cpf);
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		String strDt = formato.format(objFam.getdtCadastroHF());
		Date dtUtil;
		try {
			dtUtil = formato.parse(strDt);
			objFam.setdtCadastroHF(dtUtil);
		} catch (ParseException e) {
			Alertas.showAlert(null, "Date Error!: ", e.getMessage(), AlertType.ERROR);
		}
		return objFam;
	}

}
