package controller.fxml;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import controller.impl.ClienteCT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Alertas;
import util.Constraints;

public class FormCliente implements Initializable {

	private ClienteCT controller;

	@FXML
	private Button btAtualiza;

	@FXML
	private Button btCancel;

	@FXML
	private Button btExclui;

	@FXML
	private Button btLoc;

	@FXML
	private Button btSaveUser;

	@FXML
	private TextField tfBairro;

	@FXML
	private TextField tfCEP;

	@FXML
	private TextField tfCPFCliente;

	@FXML
	private TextField tfCel;

	@FXML
	private TextField tfCidade;

	@FXML
	private TextField tfComplemento;

	@FXML
	private TextField tfDtCadastro;

	@FXML
	private TextField tfDtNasc;

	@FXML
	private TextField tfEmail;

	@FXML
	private TextField tfEndNum;

	@FXML
	private TextField tfEndereco;

	@FXML
	private TextField tfEscolaridade;

	@FXML
	private TextField tfIdade;

	@FXML
	private TextField tfMae;

	@FXML
	private TextField tfNacionalidade;

	@FXML
	private TextField tfNaturalidade;

	@FXML
	private TextField tfNomeCompleto;

	@FXML
	private TextField tfRG;

	@FXML
	private TextField tfReligiao;

	@FXML
	private TextField tfUF;

	@FXML
	private TextField txtCartaoSUS;

	@FXML
	private TextField txtGenero;

	@FXML
	private TextField txtRaca;

	public TextField getTfBairro() {
		return tfBairro;
	}

	public TextField getTfCEP() {
		return tfCEP;
	}

	public TextField getTfCPFCliente() {
		return tfCPFCliente;
	}

	public TextField getTfCel() {
		return tfCel;
	}

	public TextField getTfCidade() {
		return tfCidade;
	}

	public TextField getTfComplemento() {
		return tfComplemento;
	}

	public TextField getTfDtCadastro() {
		return tfDtCadastro;
	}

	public TextField getTfDtNasc() {
		return tfDtNasc;
	}

	public TextField getTfEmail() {
		return tfEmail;
	}

	public TextField getTfEndNum() {
		return tfEndNum;
	}

	public TextField getTfEndereco() {
		return tfEndereco;
	}

	public TextField getTfEscolaridade() {
		return tfEscolaridade;
	}

	public TextField getTfIdade() {
		return tfIdade;
	}

	public TextField getTfMae() {
		return tfMae;
	}

	public TextField getTfNacionalidade() {
		return tfNacionalidade;
	}

	public TextField getTfNaturalidade() {
		return tfNaturalidade;
	}

	public TextField getTfNomeCompleto() {
		return tfNomeCompleto;
	}

	public TextField getTfRG() {
		return tfRG;
	}

	public TextField getTfReligiao() {
		return tfReligiao;
	}

	public TextField getTfUF() {
		return tfUF;
	}

	public TextField getTxtCartaoSUS() {
		return txtCartaoSUS;
	}

	public TextField getTxtGenero() {
		return txtGenero;
	}

	public TextField getTxtRaca() {
		return txtRaca;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.controller = new ClienteCT();
		Constraints.mskLetras(tfNomeCompleto, 50);
		Constraints.mskCPF(tfCPFCliente);

		Constraints.mskDt(tfDtNasc);

		try {
			Constraints.mskIdade(tfDtNasc, tfIdade);
		} catch (ParseException e) {
			Alertas.showAlert(null, "Date Error!: ", e.getMessage(), AlertType.ERROR);
		}

		Constraints.mskCEL(tfCel);
		Constraints.mskNum(tfEndNum, 6);
		Constraints.mskUF(tfUF);
		Constraints.mskNum(txtCartaoSUS, 15);
		Constraints.mskCEP(tfCEP);
		Constraints.mskDt(tfDtCadastro);
	}

	@FXML
	void cnc() {
		handleSai();
	}

	public void handleSai() {

	}

	@FXML
	void onClickPesq(ActionEvent event) {
		try {
			controller.pesquisaCpf(this);
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

	@FXML
	void onClickBusca(ActionEvent event) {
		try {
			controller.buscaObj(this);
		} catch (Exception e) {

		}
	}

}
