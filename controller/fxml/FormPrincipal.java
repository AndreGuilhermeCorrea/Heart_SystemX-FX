package controller.fxml;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import util.Alertas;

public class FormPrincipal implements Initializable {

	@FXML
	private BorderPane border;

	@FXML
	private AnchorPane pane;

	@FXML
	private MenuBar mnBar;

	@FXML
	private Menu mnCliente;

	@FXML
	private Menu mnHelp;

	@FXML
	private Menu mnHistorico;

	@FXML
	private MenuItem mnItemSobre;

	@FXML
	private MenuItem mnItemAntro;

	@FXML
	private MenuItem mnItemPrograma;

	@FXML
	private MenuItem mnItemAutor;

	@FXML
	private MenuItem mnItemQuest;

	@FXML
	private MenuItem mnItemAbout;

	@FXML
	private MenuItem mnItemAntropometria;

	@FXML
	private MenuItem mnItemCliente;

	@FXML
	private MenuItem mnItemFamilia;

	@FXML
	private MenuItem mnItemPsicologia;

	@FXML
	private MenuItem mnItemPsicologiaAltoRisco;

	@FXML
	private MenuItem mnItemSair;

	@FXML
	private MenuItem mnItemSaude;

	@FXML
	private MenuItem mnItemUsuario;

	@FXML
	private Menu mnOpcoes;

	@FXML
	private Menu mnUsuario;

	@FXML
	private Label dtLabel;

	@FXML
	private Label lbUsuario;

	@FXML
	void saiSistema(ActionEvent event) {
		handleSai();
	}

	@FXML
	void initializeAntropometria(ActionEvent event) {

		try {
			Parent fxmlInitializeAntropometria = FXMLLoader
					.load(getClass().getResource("/view/FormAntropometria.fxml"));
			changeScreen(fxmlInitializeAntropometria);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void initializeFamilia(ActionEvent event) {
		try {
			Parent fxmlInitializeFamilia = FXMLLoader.load(getClass().getResource("/view/FormFamilia.fxml"));
			changeScreen(fxmlInitializeFamilia);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void initializePsico(ActionEvent event) {
		try {
			Parent fxmlInitializePsico = FXMLLoader.load(getClass().getResource("/view/FormPsico.fxml"));
			changeScreen(fxmlInitializePsico);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void initializePsicoAR(ActionEvent event) {
		try {
			Parent fxmlInitializePsicoAR = FXMLLoader.load(getClass().getResource("/view/FormPsicoAltoRisco.fxml"));

			changeScreen(fxmlInitializePsicoAR);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void initializeSaude(ActionEvent event) {
		try {
			Parent fxmlInitializeSaude = FXMLLoader.load(getClass().getResource("/view/FormSaude.fxml"));

			changeScreen(fxmlInitializeSaude);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void initializeUsuario(ActionEvent event) {
		try {
			Parent fxmlInitializeUsuario = FXMLLoader.load(getClass().getResource("/view/FormUsuario.fxml"));

			changeScreen(fxmlInitializeUsuario);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void initializeCliente(ActionEvent event) {
		try {
			Parent fxmlInitializeCliente = FXMLLoader.load(getClass().getResource("/view/FormCliente.fxml"));
			changeScreen(fxmlInitializeCliente);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void aboutAntro(ActionEvent event) {
		try {
			Parent fxmlAboutAntro = FXMLLoader.load(getClass().getResource("/view/FormInfAntropometria.fxml"));
			changeScreen(fxmlAboutAntro);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void aboutAutor(ActionEvent event) {
		try {
			Parent fxmlAboutAutor = FXMLLoader.load(getClass().getResource("/view/FormInfAutor.fxml"));
			changeScreen(fxmlAboutAutor);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void aboutProgram(ActionEvent event) {
		try {
			Parent fxmlAboutProgram = FXMLLoader.load(getClass().getResource("/view/FormInfPrograma.fxml"));

			changeScreen(fxmlAboutProgram);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void aboutQuest(ActionEvent event) {
		try {
			Parent fxmlAboutQuest = FXMLLoader.load(getClass().getResource("/view/FormInfQuestionario.fxml"));
			changeScreen(fxmlAboutQuest);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void aboutSobre(ActionEvent event) {
		try {
			Parent fxmlAboutSobre = FXMLLoader.load(getClass().getResource("/view/FormInfSobre.fxml"));
			changeScreen(fxmlAboutSobre);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("E dd/MM/yyyy");
		LocalDateTime timePoint = LocalDateTime.now();
		String dataHoje = timePoint.format(fmt);
		dtLabel.setText("Data: " + dataHoje);

	}

	public void handleSai() {
		Platform.exit();
	}

	public void pricipal() {
		try {
			Parent fxmlReturn = FXMLLoader.load(getClass().getResource("/view/FormPrincipal.fxml"));
			changeScreen(fxmlReturn);
		} catch (IOException ex) {
			ex.getCause().printStackTrace();
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", ex.getMessage(), AlertType.ERROR);
		}
	}
	
	private void changeScreen(Parent fxmlLoad) {
		BotherStage.instance(null).loadNewStage(fxmlLoad);
	}

}
