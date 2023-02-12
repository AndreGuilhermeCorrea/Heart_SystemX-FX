package controller.fxml;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.dao.impl.UsuarioDaoJDBC;
import model.entities.Usuario;
import util.Alertas;

public class FormLogin implements Initializable {

	private UsuarioDaoJDBC objUsuarioDaoJDBC;
	
	private BotherStage botherStage;

	@FXML
	private Button btCancel;

	@FXML
	private Button btLogin;

	@FXML
	private PasswordField txtSenha;

	@FXML
	public TextField txtUsuario;

	public TextField getTxtUsuario() {
		return txtUsuario;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public String setarTxtUsuario() {
		return getTxtUsuario().getText();
	}

	public void logar() throws IOException {

		try {
			String Usuario = txtUsuario.getText();
			String Senha = txtSenha.getText();
			Usuario objUser = new Usuario();
			objUser.setUsuario(Usuario);
			objUser.setSenha(Senha);

			objUsuarioDaoJDBC = new UsuarioDaoJDBC(null);

			ResultSet rs = objUsuarioDaoJDBC.logar(objUser);

			if (rs.next()) {
				btLogin.getScene().getWindow().hide();
				Stage primaryStage = new Stage();
				this.botherStage = BotherStage.instance(primaryStage);
		        
				Parent fxmlPrincipal = FXMLLoader.load(getClass().getResource("/view/FormPrincipal.fxml"));
		    
		        Scene scene = new Scene(fxmlPrincipal);
		        Image systemIcon = new Image(getClass().getResourceAsStream("/icons/health-64.png"));
		        botherStage.getStage().getIcons().add(systemIcon);
		        botherStage.getStage().setTitle("HEART_SYSTEM_X-FX");
		        botherStage.getStage().setResizable(false);
		        botherStage.getStage().setMaximized(false);     
		        botherStage.getStage().setScene(scene);
		        botherStage.getStage().show();
			} else {
				Alertas.showAlert("Login ERRO!", "Login invalido", null, AlertType.ERROR);
			}
			txtUsuario.setText("");
			txtSenha.setText("");

		} catch (SQLException e) {
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", e.getMessage(), AlertType.ERROR);
		}
	}

	public void loginCancel() {
		Platform.exit();
	}
	
}
