package model.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.Alert.AlertType;
import model.dao.impl.AntropometriaDaoJDBC;
import model.entities.Antropometria;
import util.Alertas;

public class AntropometriaService {

	private AntropometriaDaoJDBC dao;
	private Antropometria objAntro;

	public AntropometriaService() {
		this.dao = new AntropometriaDaoJDBC();
	}

	public void findByCpf(String cpf) {
		dao.findByCPF(cpf);
	}

	public void insert(Antropometria objAntro) {
		dao.insert(objAntro);
	}

	public void update(Antropometria objAntro) {
		dao.update(objAntro);
	}

	public void deleteByCpf(String cpf) {
		dao.deleteByCpf(cpf);
	}

	// método que recebe uma string e retorna um objeto carregado além de formatar
	// os campos de data
	public Antropometria pesquisaView(String cpf) {
		objAntro = dao.findByCPF(cpf);
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		String strDt = formato.format(objAntro.getDtCadastroA());
		Date dtUtil;
		try {
			dtUtil = formato.parse(strDt);
			objAntro.setDtCadastroA(dtUtil);
		} catch (ParseException e) {
			Alertas.showAlert(null, "Date Error!: ", e.getMessage(), AlertType.ERROR);
		}
		return objAntro;
	}

	// método responsável por realizar os calculos referente as medidas
	// antropométricas
	public Antropometria calcular(Antropometria objAntro) {

		int idade = objAntro.getIdade();
		String sexo = objAntro.getSexo();
		double pes = objAntro.getPeso();
		double alt = objAntro.getAltura();
		double alt2 = alt * alt;
		double cint = objAntro.getcCintura();
		double quad = objAntro.getcQuadril();
		double cintQuad = cint / quad;
		objAntro.setRazaoCQ(cintQuad);
		double torax = objAntro.getPregaCutaneaTorax();
		double tric = objAntro.getPregaCutaneaTriciptal();
		double coxa = objAntro.getPregaCutaneaCoxa();
		double abd = objAntro.getPregaCutaneaAbdomem();
		double supra = objAntro.getPregaCutaneaSuprailiaca();
		int pedo1 = objAntro.getPedometro1();
		int pedo2 = objAntro.getPedometro2();
		int pedo3 = objAntro.getPedometro3();
		double mediaPedo = (pedo1 + pedo2 + pedo3) / 3;
		objAntro.setPedometroMedia(mediaPedo);

		String medPed;
		if (mediaPedo < 5000) {
			medPed = "Sedentário";
		} else if (mediaPedo >= 5000 && mediaPedo <= 10000) {
			medPed = "Ativo Leve";
		} else if (mediaPedo > 10000 && mediaPedo <= 20000) {
			medPed = "Ativo";
		} else if (mediaPedo > 20000) {
			medPed = "Atleta";
		} else
			medPed = "Erro!";

		objAntro.setPedometroClass(medPed);
		double imc = pes / alt2;
		objAntro.setImc(imc);

		String cImc;
		if (imc < 16) {
			cImc = "Magreza Grau III";
		} else if (imc >= 16 && imc <= 16.9) {
			cImc = "Magreza Grau II";
		} else if (imc > 16.9 && imc <= 18.4) {
			cImc = "Magreza Grau I";
		} else if (imc > 18.4 && imc <= 24.9) {
			cImc = "Eutrofia";
		} else if (imc > 24.9 && imc <= 29.9) {
			cImc = "Sobrepeso";
		} else if (imc > 29.9 && imc <= 34.9) {
			cImc = "Obesidade Grau I";
		} else if (imc > 34.9 && imc <= 39.9) {
			cImc = "Obesidade Grau II";
		} else if (imc > 40) {
			cImc = "Obesidade Grau III";
		} else
			cImc = "Erro!";
		objAntro.setcImc(cImc);

		// CC = (altura(mt)/punho(cm))*100
		double punho = objAntro.getcPunho();
		double compleicao = (alt * 100) / punho;
		objAntro.setCompleicao(compleicao);
		String tpCompl;
		if (compleicao < 9.6) {
			tpCompl = "Grande";
		} else if (compleicao >= 9.6 && compleicao <= 10.4) {
			tpCompl = "Média";
		} else if (compleicao > 10.4) {
			tpCompl = "Pequena";
		} else
			tpCompl = "Erro!";
		objAntro.setTipoComp(tpCompl);
		double setAlc = objAntro.getSentarAlcanca();
		String flexibilidade;
		if (setAlc >= 22) {
			flexibilidade = "Excelente";
		} else if (setAlc < 22 && setAlc > 18) {
			flexibilidade = "Bom";
		} else if (setAlc <= 18 && setAlc > 13) {
			flexibilidade = "Médio";
		} else if (setAlc <= 13 && setAlc > 11) {
			flexibilidade = "Regular";
		} else if (setAlc <= 11) {
			flexibilidade = "Fraco";
		} else
			flexibilidade = "Erro!";
		objAntro.setNivelFlexibilidade(flexibilidade);
		String clsImcRisco;
		double imcDesejado = 0;
		double somaDC = 0;
		double dens = 0;
		double percGord = 0;
		double mcg = 0;
		double mcm = 0;

		if (sexo.equals("M")) {
			somaDC = torax + abd + coxa;
			// Dens = 1,1093800 â€“ 0,0008267 (X1) + 0,0000016 (X1) 2 â€“ 0,0002574 (X3)
			dens = 1.1093800 - ((0.0008267 * somaDC) + (0.0000016 * somaDC * 2) - (0.0002574 * idade));
			// G % = [(4.95 / Dens) - 4.50] * x 100
			percGord = (495 / dens) - 450;
			objAntro.setSomaDobrasCutaneas(somaDC);
			if (compleicao < 9.6) {
				imcDesejado = 25.0;
			} else if (compleicao >= 9.6 && compleicao <= 10.4) {
				imcDesejado = 22.5;
			} else if (compleicao > 10.4) {
				imcDesejado = 25.0;
			}
			objAntro.setImcDesejavel(imcDesejado);
			objAntro.setDensidade(dens);
			// MCG = (%G / 100) * MC
			mcg = (percGord / 100) * pes;
			// MCM = MC - MCG
			mcm = (pes - mcg);
			objAntro.setMassaCPercentual(percGord);
			objAntro.setMassaCGorda(mcg);
			objAntro.setMassaCMagra(mcm);
			if (imc >= 27.8) {
				clsImcRisco = "RISCO ELEVADO";
			} else if (imc < 27.8 && imc > 25) {
				clsImcRisco = "RISCO MODERADO";
			} else if (imc <= 25 && imc > 19) {
				clsImcRisco = "CLASS. IDEAL";
			} else if (imc <= 19 && imc > 18) {
				clsImcRisco = "BAIXO RISCO";
			} else
				clsImcRisco = "Erro!";
			objAntro.setcRiscoSaude(clsImcRisco);
		}

		if (sexo.equals("F")) {
			somaDC = tric + supra + coxa;
			// Dens = 1,0994921 â€“ 0,0009929 (X2) + 0,0000023 (X2) 2 â€“ 0,0001392 (X3)
			dens = 1.0994921 - ((0.0009929 * somaDC) + (0.0000023 * somaDC * 2) - (0.0001392 * idade));
			// G % = [(4.95 / Dens) - 4.50] * x 100
			percGord = (495 / dens) - 450;
			objAntro.setSomaDobrasCutaneas(somaDC);
			if (compleicao < 9.4) {
				imcDesejado = 24.0;
			} else if (compleicao >= 9.4 && compleicao <= 10.9) {
				imcDesejado = 21.5;
			} else if (compleicao > 10.9) {
				imcDesejado = 24.0;
			}
			objAntro.setImcDesejavel(imcDesejado);
			objAntro.setDensidade(dens);
			// MCG = (%G / 100) * MC
			mcg = (percGord / 100) * pes;
			// MCM = MC - MCG
			mcm = (pes - mcg);
			objAntro.setMassaCPercentual(percGord);
			objAntro.setMassaCGorda(mcg);
			objAntro.setMassaCMagra(mcm);
			if (imc >= 27.3) {
				clsImcRisco = "RISCO ELEVADO";
			} else if (imc < 27.2 && imc > 24.5) {
				clsImcRisco = "RISCO MODERADO";
			} else if (imc <= 24.5 && imc > 18) {
				clsImcRisco = "RISCO IDEAL";
			} else if (imc <= 18 && imc > 15) {
				clsImcRisco = "BAIXO RISCO";
			} else
				clsImcRisco = "Erro!";
			objAntro.setcRiscoSaude(clsImcRisco);
		}

		// PD = (altura)Â² x IMC desejavel
		double pd = alt2 * imcDesejado;
		objAntro.setPesoDesejavel(pd);
		// AP(%) = (peso/PD)*100
		double adq2 = (pes / pd) * 100;
		objAntro.setAdequacaoPeso(adq2);
		// PA = (PD - peso) x 0,25 +/- peso;
		double pa = 0;
		double adq = (pes / pd);
		if (adq >= 1.15) {
			pa = (pes + ((pd - pes) * 0.25));
		} else if (adq <= 0.95) {
			pa = (pes - ((pes - pd) * 0.25));
		} else if (adq < 1.15 && adq > 0.95) {
			pa = pes;
		}
		objAntro.setPesoAjustado(pa);
		return objAntro;
	}

}
