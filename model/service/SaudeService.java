package model.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.Alert.AlertType;
import model.dao.impl.SaudeDaoJDBC;
import model.entities.Saude;
import util.Alertas;

public class SaudeService {

	private SaudeDaoJDBC dao;
	private Saude objSaude;

	public SaudeService() {
		this.dao = new SaudeDaoJDBC();
	}

	public void findByCpf(String cpf) {
		dao.findByCPF(cpf);
	}

	public void insert(Saude objSaude) {
		dao.insert(objSaude);
	}

	public void update(Saude objSaude) {
		dao.update(objSaude);
	}

	public void deleteByCpf(String cpf) {
		dao.deleteByCpf(cpf);
	}

	public Saude pesquisaView(String cpf) {
		objSaude = dao.findByCPF(cpf);
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		String strDt = formato.format(objSaude.getDtCadastroS());
		Date dtUtil;
		try {
			dtUtil = formato.parse(strDt);
			objSaude.setDtCadastroS(dtUtil);
		} catch (ParseException e) {
			Alertas.showAlert(null, "Date Error!: ", e.getMessage(), AlertType.ERROR);
		}

		return objSaude;
	}

}
