package controller.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import controller.impl.PsicoCT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Constraints;

public class FormPsico implements Initializable {
	private PsicoCT controller;

	@FXML
	private Button btLoc;

	@FXML
	private Button btAtualiza;

	@FXML
	private Button btCancel;

	@FXML
	private Button btExclui;

	@FXML
	private Button btSaveUser;
	@FXML
	private TextField tfCPFPsico;

	@FXML
	private TextField tfDtCadPsico;

	@FXML
	private Label tfNomePsico;

	@FXML
	private TextField tfPsico1;

	@FXML
	private TextField tfPsico2;

	@FXML
	private TextField tfPsico3;

	@FXML
	private TextField tfPsico4;

	@FXML
	private TextField tfPsico5;

	@FXML
	private TextField tfPsico6;

	@FXML
	private TextField tfPsico7;

	@FXML
	private TextField tfPsico8;

	@FXML
	private TextField tfPsico9;

	@FXML
	private TextField tfPsico10;

	@FXML
	private TextField tfPsico11;

	@FXML
	private TextField tfPsico12;

	@FXML
	private TextField tfPsico13;

	@FXML
	private TextField tfPsico14;

	@FXML
	private TextField tfPsico15;

	@FXML
	private TextField tfPsico16;

	@FXML
	private TextField tfPsico17;

	@FXML
	private TextField tfPsico18;

	@FXML
	private TextField tfPsico19;

	@FXML
	private TextField tfPsico20;

	@FXML
	private TextField tfPsico21;

	@FXML
	private TextField tfPsico22;

	@FXML
	private TextField tfPsico23;

	@FXML
	private TextField tfPsico24;

	public TextField getTfCPFPsico() {
		return tfCPFPsico;
	}

	public TextField getTfDtCadPsico() {
		return tfDtCadPsico;
	}

	public Label getTfNomePsico() {
		return tfNomePsico;
	}

	public TextField getTfPsico1() {
		return tfPsico1;
	}

	public TextField getTfPsico2() {
		return tfPsico2;
	}

	public TextField getTfPsico3() {
		return tfPsico3;
	}

	public TextField getTfPsico4() {
		return tfPsico4;
	}

	public TextField getTfPsico5() {
		return tfPsico5;
	}

	public TextField getTfPsico6() {
		return tfPsico6;
	}

	public TextField getTfPsico7() {
		return tfPsico7;
	}

	public TextField getTfPsico8() {
		return tfPsico8;
	}

	public TextField getTfPsico9() {
		return tfPsico9;
	}

	public TextField getTfPsico10() {
		return tfPsico10;
	}

	public TextField getTfPsico11() {
		return tfPsico11;
	}

	public TextField getTfPsico12() {
		return tfPsico12;
	}

	public TextField getTfPsico13() {
		return tfPsico13;
	}

	public TextField getTfPsico14() {
		return tfPsico14;
	}

	public TextField getTfPsico15() {
		return tfPsico15;
	}

	public TextField getTfPsico16() {
		return tfPsico16;
	}

	public TextField getTfPsico17() {
		return tfPsico17;
	}

	public TextField getTfPsico18() {
		return tfPsico18;
	}

	public TextField getTfPsico19() {
		return tfPsico19;
	}

	public TextField getTfPsico20() {
		return tfPsico20;
	}

	public TextField getTfPsico21() {
		return tfPsico21;
	}

	public TextField getTfPsico22() {
		return tfPsico22;
	}

	public TextField getTfPsico23() {
		return tfPsico23;
	}

	public TextField getTfPsico24() {
		return tfPsico24;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.controller = new PsicoCT();
		Constraints.mskCPF(tfCPFPsico);

		Constraints.mskSN(tfPsico1);
		Constraints.mskSN(tfPsico2);
		Constraints.mskSN(tfPsico3);
		Constraints.mskSN(tfPsico4);
		Constraints.mskSN(tfPsico5);
		Constraints.mskSN(tfPsico6);
		Constraints.mskSN(tfPsico7);
		Constraints.mskSN(tfPsico8);
		Constraints.mskSN(tfPsico9);
		Constraints.mskSN(tfPsico10);
		Constraints.mskSN(tfPsico11);
		Constraints.mskSN(tfPsico12);
		Constraints.mskSN(tfPsico13);
		Constraints.mskSN(tfPsico14);
		Constraints.mskSN(tfPsico15);
		Constraints.mskSN(tfPsico16);
		Constraints.mskSN(tfPsico17);
		Constraints.mskSN(tfPsico18);
		Constraints.mskSN(tfPsico19);
		Constraints.mskSN(tfPsico20);
		Constraints.mskSN(tfPsico21);
		Constraints.mskSN(tfPsico22);
		Constraints.mskSN(tfPsico23);
		Constraints.mskSN(tfPsico24);
		Constraints.mskDt(tfDtCadPsico);

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

}
