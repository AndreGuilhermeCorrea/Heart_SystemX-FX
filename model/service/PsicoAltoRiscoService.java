package model.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.Alert.AlertType;
import model.dao.impl.PsicoAltoRiscoDaoJDBC;
import model.entities.PsicoAltoRisco;
import util.Alertas;

public class PsicoAltoRiscoService {

	private PsicoAltoRiscoDaoJDBC dao;
	private PsicoAltoRisco objPAR;

	public PsicoAltoRiscoService() {
		this.dao = new PsicoAltoRiscoDaoJDBC();
	}

	public void findByCpf(String cpf) {
		dao.findByCPF(cpf);
	}

	public void insert(PsicoAltoRisco objPAR) {
		dao.insert(objPAR);
	}

	public void update(PsicoAltoRisco objPAR) {
		dao.update(objPAR);
	}

	public void deleteByCpf(String cpf) {
		dao.deleteByCpf(cpf);
	}

	// método que recebe uma string e retorna um objeto carregado além de formatar
	// os campos de data
	public PsicoAltoRisco pesquisaView(String cpf) {
		objPAR = dao.findByCPF(cpf);

		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		String strDt = formato.format(objPAR.getDtCadastroHPAR());
		Date dtUtil;
		try {
			dtUtil = formato.parse(strDt);
			objPAR.setDtCadastroHPAR(dtUtil);
		} catch (ParseException e) {
			Alertas.showAlert(null, "Date Error!: ", e.getMessage(), AlertType.ERROR);
		}
		return objPAR;
	}

}
