package controller.fxml;

import java.net.URL;
import java.util.ResourceBundle;

import controller.impl.UsuarioCT;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Constraints;

public class FormUsuario implements Initializable {

	private UsuarioCT controller;

	@FXML
	private Button btProcuraUsuario;

	@FXML
	private Button btAtualiza;

	@FXML
	private Button btCancel;

	@FXML
	private Button btExclui;

	@FXML
	private Button btSaveUser;

	@FXML
	private TextField tfNewSenhaUser;

	@FXML
	private TextField tfNomeUsuario;

	@FXML
	private TextField tfUsuario;

	@FXML
	private TextField tfUsuarioCPF;

	public TextField getTfNewSenhaUser() {
		return tfNewSenhaUser;
	}

	public TextField getTfNomeUsuario() {
		return tfNomeUsuario;
	}

	public TextField getTfUsuario() {
		return tfUsuario;
	}

	public TextField getTfUsuarioCPF() {
		return tfUsuarioCPF;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.controller = new UsuarioCT();
		Constraints.mskCPF(tfUsuarioCPF);
		Constraints.mskLetras(tfNomeUsuario, 50);
		Constraints.mskLetras(tfUsuario, 50);

	}

	@FXML
	void cnc() {
		handleSai();
	}

	public void handleSai() {

	}

	@FXML
	void onClickInsert() {
		try {
			controller.inserir(this);
		} catch (Exception e) {

		}
	}

	@FXML
	void onClickDelete() {
		try {
			controller.deletar(this);
		} catch (Exception e) {

		}
	}

	@FXML
	void onClickAtualiza() {
		try {
			controller.atualizar(this);
		} catch (Exception e) {

		}
	}

	@FXML
	void onClickBusca() {
		try {
			controller.buscaObj(this);
		} catch (Exception e) {

		}
	}
}
