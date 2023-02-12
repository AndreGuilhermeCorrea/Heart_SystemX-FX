package controller.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import controller.impl.PsicoAltoRiscoCT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Constraints;

public class FormPsicoAltoRisco implements Initializable {

	private PsicoAltoRiscoCT controller;

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
	private TextField tfCPFPsicoAr;

	@FXML
	private TextField tfDtCadPsicoAr;

	@FXML
	private Label tfNomePsicoAr;

	@FXML
	private TextField tfPsicoAr1;

	@FXML
	private TextField tfPsicoAr2;

	@FXML
	private TextField tfPsicoAr3;

	@FXML
	private TextField tfPsicoAr4;

	@FXML
	private TextField tfPsicoAr5;

	@FXML
	private TextField tfPsicoAr6;

	@FXML
	private TextField tfPsicoAr7;

	@FXML
	private TextField tfPsicoAr8;

	@FXML
	private TextField tfPsicoAr9;

	@FXML
	private TextField tfPsicoAr10;

	@FXML
	private TextField tfPsicoAr11;

	public Button getBtLoc() {
		return btLoc;
	}

	public TextField getTfCPFPsicoAr() {
		return tfCPFPsicoAr;
	}

	public TextField getTfDtCadPsicoAr() {
		return tfDtCadPsicoAr;
	}

	public Label getTfNomePsicoAr() {
		return tfNomePsicoAr;
	}

	public TextField getTfPsicoAr1() {
		return tfPsicoAr1;
	}

	public TextField getTfPsicoAr2() {
		return tfPsicoAr2;
	}

	public TextField getTfPsicoAr3() {
		return tfPsicoAr3;
	}

	public TextField getTfPsicoAr4() {
		return tfPsicoAr4;
	}

	public TextField getTfPsicoAr5() {
		return tfPsicoAr5;
	}

	public TextField getTfPsicoAr6() {
		return tfPsicoAr6;
	}

	public TextField getTfPsicoAr7() {
		return tfPsicoAr7;
	}

	public TextField getTfPsicoAr8() {
		return tfPsicoAr8;
	}

	public TextField getTfPsicoAr9() {
		return tfPsicoAr9;
	}

	public TextField getTfPsicoAr10() {
		return tfPsicoAr10;
	}

	public TextField getTfPsicoAr11() {
		return tfPsicoAr11;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.controller = new PsicoAltoRiscoCT();
		Constraints.mskCPF(tfCPFPsicoAr);
		Constraints.mskSN(tfPsicoAr1);
		Constraints.mskSN(tfPsicoAr2);
		Constraints.mskSN(tfPsicoAr3);
		Constraints.mskSN(tfPsicoAr4);
		Constraints.mskSN(tfPsicoAr5);
		Constraints.mskSN(tfPsicoAr6);
		Constraints.mskSN(tfPsicoAr7);
		Constraints.mskSN(tfPsicoAr8);
		Constraints.mskSN(tfPsicoAr9);
		Constraints.mskSN(tfPsicoAr10);
		Constraints.mskSN(tfPsicoAr11);
		Constraints.mskDt(tfDtCadPsicoAr);

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
