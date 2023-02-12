package controller.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import controller.impl.AntropometriaCT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Alertas;
import util.Constraints;

public class FormAntropometria implements Initializable {

	private AntropometriaCT controller;

	@FXML
	private Button btAtualiza;

	@FXML
	private Button btExclui;

	@FXML
	private Button btCalc;

	@FXML
	private Button btCancel;

	@FXML
	private Button btLoc;

	@FXML
	private Button btSaveUser;

	@FXML
	private TextField tfAdequacaoPeso;

	@FXML
	private TextField tfAltura;

	@FXML
	private TextField tfCIMC;

	@FXML
	private TextField tfCompleicao;

	@FXML
	private TextField tfCpfA;

	@FXML
	private TextField tfDensidade;

	@FXML
	private TextField tfDtCadastroA;

	@FXML
	private TextField tfIMC;

	@FXML
	private TextField tfIMCDesejavel;

	@FXML
	private TextField tfIdade;

	@FXML
	private TextField tfMassaCGorda;

	@FXML
	private TextField tfMassaCMagra;

	@FXML
	private TextField tfMassaCPercentual;

	@FXML
	private TextField tfNivelFlexib;

	@FXML
	private TextField tfNomeClienteA;

	@FXML
	private TextField tfPcAbdomem;

	@FXML
	private TextField tfPcCoxa;

	@FXML
	private TextField tfPcSuprailiaca;

	@FXML
	private TextField tfPcTorax;

	@FXML
	private TextField tfPcTricip;

	@FXML
	private TextField tfPedometro1;

	@FXML
	private TextField tfPedometro2;

	@FXML
	private TextField tfPedometro3;

	@FXML
	private TextField tfPedometroClass;

	@FXML
	private TextField tfPedometroMedia;

	@FXML
	private TextField tfPeso;

	@FXML
	private TextField tfPesoAjustado;

	@FXML
	private TextField tfPesoDesejavel;

	@FXML
	private TextField tfRazaoCintQuad;

	@FXML
	private TextField tfRiscoSaude;

	@FXML
	private TextField tfSentarAlcanca;

	@FXML
	private TextField tfSexo;

	@FXML
	private TextField tfSomaDobras;

	@FXML
	private TextField tfTipoComp;

	@FXML
	private TextField tfcCintura;

	@FXML
	private TextField tfcPunho;

	@FXML
	private TextField tfcQuadril;

	public TextField getTfAdequacaoPeso() {
		return tfAdequacaoPeso;
	}

	public TextField getTfAltura() {
		return tfAltura;
	}

	public TextField getTfCIMC() {
		return tfCIMC;
	}

	public TextField getTfCompleicao() {
		return tfCompleicao;
	}

	public TextField getTfCpfA() {
		return tfCpfA;
	}

	public TextField getTfDensidade() {
		return tfDensidade;
	}

	public TextField getTfDtCadastroA() {
		return tfDtCadastroA;
	}

	public TextField getTfIMC() {
		return tfIMC;
	}

	public TextField getTfIMCDesejavel() {
		return tfIMCDesejavel;
	}

	public TextField getTfIdade() {
		return tfIdade;
	}

	public TextField getTfMassaCGorda() {
		return tfMassaCGorda;
	}

	public TextField getTfMassaCMagra() {
		return tfMassaCMagra;
	}

	public TextField getTfMassaCPercentual() {
		return tfMassaCPercentual;
	}

	public TextField getTfNivelFlexib() {
		return tfNivelFlexib;
	}

	public TextField getTfRiscoSaude() {
		return tfRiscoSaude;
	}

	public TextField getTfNomeClienteA() {
		return tfNomeClienteA;
	}

	public TextField getTfPcAbdomem() {
		return tfPcAbdomem;
	}

	public TextField getTfPcCoxa() {
		return tfPcCoxa;
	}

	public TextField getTfPcSuprailiaca() {
		return tfPcSuprailiaca;
	}

	public TextField getTfPcTorax() {
		return tfPcTorax;
	}

	public TextField getTfPcTricip() {
		return tfPcTricip;
	}

	public TextField getTfPedometro1() {
		return tfPedometro1;
	}

	public TextField getTfPedometro2() {
		return tfPedometro2;
	}

	public TextField getTfPedometro3() {
		return tfPedometro3;
	}

	public TextField getTfPedometroClass() {
		return tfPedometroClass;
	}

	public TextField getTfPedometroMedia() {
		return tfPedometroMedia;
	}

	public TextField getTfPeso() {
		return tfPeso;
	}

	public TextField getTfPesoAjustado() {
		return tfPesoAjustado;
	}

	public TextField getTfPesoDesejavel() {
		return tfPesoDesejavel;
	}

	public TextField getTfRazaoCintQuad() {
		return tfRazaoCintQuad;
	}

	public TextField getTfSentarAlcanca() {
		return tfSentarAlcanca;
	}

	public TextField getTfSexo() {
		return tfSexo;
	}

	public TextField getTfSomaDobras() {
		return tfSomaDobras;
	}

	public TextField getTfTipoComp() {
		return tfTipoComp;
	}

	public TextField getTfcCintura() {
		return tfcCintura;
	}

	public TextField getTfcPunho() {
		return tfcPunho;
	}

	public TextField getTfcQuadril() {
		return tfcQuadril;
	}

	@FXML
	void cnc() {
		handleSai();
	}

	public void handleSai() {
		FormPrincipal formPrincipal = new FormPrincipal();
		formPrincipal.pricipal();
	}

	@FXML
	void onClickCalc(ActionEvent event) {
		try {
			controller.calc(this);
		} catch (Exception e) {
			Alertas.showAlert(null, "Erro ao realizar o calculo!", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void onClickPesq(ActionEvent event) {
		try {
			controller.pesquisaCpf(this);
			controller.buscaObj(this);
		} catch (Exception e) {

		}
	}

	@FXML
	void onClickInsert(ActionEvent event) {
		try {
			controller.inserir(this);
		} catch (Exception e) {

		}
	}

	@FXML
	void onClickDelete(ActionEvent event) {
		try {
			controller.deletar(this);
		} catch (Exception e) {

		}
	}

	@FXML
	void onClickAtualiza(ActionEvent event) {
		try {
			controller.atualizar(this);
		} catch (Exception e) {
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.controller = new AntropometriaCT();
		Constraints.mskCPF(tfCpfA);
		Constraints.mskDt(tfDtCadastroA);
		Constraints.mskDouble(tfAltura);

	}
}
