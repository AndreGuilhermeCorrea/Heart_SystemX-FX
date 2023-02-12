package controller.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import controller.impl.FamiliaCT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Constraints;

public class FormFamilia implements Initializable {

	private FamiliaCT controller;

	@FXML
	private Button btLocaliza;

	@FXML
	private Button btAtualiza;

	@FXML
	private Button btCancel;

	@FXML
	private Button btExclui;

	@FXML
	private Button btSaveUser;

	@FXML
	private TextField tfCpfFam;

	@FXML
	private TextField tfDtCadFam;

	@FXML
	private TextField tfFam1;

	@FXML
	private TextField tfFam10;

	@FXML
	private TextField tfFam11;

	@FXML
	private TextField tfFam2;

	@FXML
	private TextField tfFam3;

	@FXML
	private TextField tfFam4;

	@FXML
	private TextField tfFam5;

	@FXML
	private TextField tfFam6;

	@FXML
	private TextField tfFam7;

	@FXML
	private TextField tfFam8;

	@FXML
	private TextField tfFam9;

	@FXML
	private Label tfNomeFam;

	public TextField getTfCpfFam() {
		return tfCpfFam;
	}

	public TextField getTfDtCadFam() {
		return tfDtCadFam;
	}

	public TextField getTfFam1() {
		return tfFam1;
	}

	public TextField getTfFam10() {
		return tfFam10;
	}

	public TextField getTfFam11() {
		return tfFam11;
	}

	public TextField getTfFam2() {
		return tfFam2;
	}

	public TextField getTfFam3() {
		return tfFam3;
	}

	public TextField getTfFam4() {
		return tfFam4;
	}

	public TextField getTfFam5() {
		return tfFam5;
	}

	public TextField getTfFam6() {
		return tfFam6;
	}

	public TextField getTfFam7() {
		return tfFam7;
	}

	public TextField getTfFam8() {
		return tfFam8;
	}

	public TextField getTfFam9() {
		return tfFam9;
	}

	public Label getTfNomeFam() {
		return tfNomeFam;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.controller = new FamiliaCT();
		Constraints.mskCPF(tfCpfFam);
		Constraints.mskSN(tfFam1);
		Constraints.mskSN(tfFam2);
		Constraints.mskSN(tfFam3);
		Constraints.mskSN(tfFam4);
		Constraints.mskSN(tfFam5);
		Constraints.mskSN(tfFam6);
		Constraints.mskSN(tfFam7);
		Constraints.mskSN(tfFam8);
		Constraints.mskSN(tfFam9);
		Constraints.mskSN(tfFam10);
		Constraints.mskSN(tfFam11);
		Constraints.mskDt(tfDtCadFam);

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
