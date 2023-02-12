package controller.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import controller.impl.SaudeCT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Constraints;

public class FormSaude implements Initializable {

	private SaudeCT controller;

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
	private TextField tfCPFClienteS;

	@FXML
	private TextField tfDtCadastroS;

	@FXML
	private Label tfNomeCliente;

	@FXML
	private TextField tfS1;

	@FXML
	private TextField tfS10;

	@FXML
	private TextField tfS11;

	@FXML
	private TextField tfS12;

	@FXML
	private TextField tfS13;

	@FXML
	private TextField tfS14;

	@FXML
	private TextField tfS15;

	@FXML
	private TextField tfS16;

	@FXML
	private TextField tfS17;

	@FXML
	private TextField tfS18;

	@FXML
	private TextField tfS19;

	@FXML
	private TextField tfS2;

	@FXML
	private TextField tfS20;

	@FXML
	private TextField tfS21;

	@FXML
	private TextField tfS22;

	@FXML
	private TextField tfS23;

	@FXML
	private TextField tfS24;

	@FXML
	private TextField tfS25;

	@FXML
	private TextField tfS26;

	@FXML
	private TextField tfS27;

	@FXML
	private TextField tfS28;

	@FXML
	private TextField tfS29;

	@FXML
	private TextField tfS3;

	@FXML
	private TextField tfS30;

	@FXML
	private TextField tfS31;

	@FXML
	private TextField tfS4;

	@FXML
	private TextField tfS5;

	@FXML
	private TextField tfS6;

	@FXML
	private TextField tfS7;

	@FXML
	private TextField tfS8;

	@FXML
	private TextField tfS9;

	public TextField getTfCPFClienteS() {
		return tfCPFClienteS;
	}

	public TextField getTfDtCadastroS() {
		return tfDtCadastroS;
	}

	public Label getTfNomeCliente() {
		return tfNomeCliente;
	}

	public TextField getTfS1() {
		return tfS1;
	}

	public TextField getTfS10() {
		return tfS10;
	}

	public TextField getTfS11() {
		return tfS11;
	}

	public TextField getTfS12() {
		return tfS12;
	}

	public TextField getTfS13() {
		return tfS13;
	}

	public TextField getTfS14() {
		return tfS14;
	}

	public TextField getTfS15() {
		return tfS15;
	}

	public TextField getTfS16() {
		return tfS16;
	}

	public TextField getTfS17() {
		return tfS17;
	}

	public TextField getTfS18() {
		return tfS18;
	}

	public TextField getTfS19() {
		return tfS19;
	}

	public TextField getTfS2() {
		return tfS2;
	}

	public TextField getTfS20() {
		return tfS20;
	}

	public TextField getTfS21() {
		return tfS21;
	}

	public TextField getTfS22() {
		return tfS22;
	}

	public TextField getTfS23() {
		return tfS23;
	}

	public TextField getTfS24() {
		return tfS24;
	}

	public TextField getTfS25() {
		return tfS25;
	}

	public TextField getTfS26() {
		return tfS26;
	}

	public TextField getTfS27() {
		return tfS27;
	}

	public TextField getTfS28() {
		return tfS28;
	}

	public TextField getTfS29() {
		return tfS29;
	}

	public TextField getTfS3() {
		return tfS3;
	}

	public TextField getTfS30() {
		return tfS30;
	}

	public TextField getTfS31() {
		return tfS31;
	}

	public TextField getTfS4() {
		return tfS4;
	}

	public TextField getTfS5() {
		return tfS5;
	}

	public TextField getTfS6() {
		return tfS6;
	}

	public TextField getTfS7() {
		return tfS7;
	}

	public TextField getTfS8() {
		return tfS8;
	}

	public TextField getTfS9() {
		return tfS9;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.controller = new SaudeCT();
		Constraints.mskCPF(tfCPFClienteS);
		Constraints.mskSN(tfS1);
		Constraints.mskSN(tfS2);
		Constraints.mskSN(tfS3);
		Constraints.mskSN(tfS4);
		Constraints.mskSN(tfS5);
		Constraints.mskSN(tfS6);
		Constraints.mskSN(tfS7);
		Constraints.mskSN(tfS8);
		Constraints.mskSN(tfS9);
		Constraints.mskSN(tfS10);
		Constraints.mskSN(tfS11);
		Constraints.mskSN(tfS12);
		Constraints.mskSN(tfS13);
		Constraints.mskSN(tfS14);
		Constraints.mskSN(tfS15);
		Constraints.mskSN(tfS16);
		Constraints.mskSN(tfS17);
		Constraints.mskSN(tfS18);
		Constraints.mskSN(tfS19);
		Constraints.mskSN(tfS20);
		Constraints.mskSN(tfS21);
		Constraints.mskSN(tfS22);
		Constraints.mskSN(tfS23);
		Constraints.mskSN(tfS24);
		Constraints.mskSN(tfS25);
		Constraints.mskSN(tfS26);
		Constraints.mskSN(tfS27);
		Constraints.mskLetras(tfS28, 50);
		Constraints.mskLetras(tfS29, 50);
		Constraints.mskSN(tfS30);
		Constraints.mskSN(tfS31);
		Constraints.mskDt(tfDtCadastroS);

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
