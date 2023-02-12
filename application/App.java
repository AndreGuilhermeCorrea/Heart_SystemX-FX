package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Alertas;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane fxmlLogin = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/FormLogin.fxml"));

			Scene scene = new Scene(fxmlLogin, 300, 200);

			Image systemIcon = new Image(getClass().getResourceAsStream("/icons/health-64.png"));

			primaryStage.setScene(scene);

			primaryStage.setTitle("HEART_SYSTEM_X-FX");

			primaryStage.getIcons().add(systemIcon);

			primaryStage.setResizable(false);
			primaryStage.setMaximized(false);

			primaryStage.show();

		} catch (IOException e) {
			Alertas.showAlert("IO ", "Erro para carregar a classe! ", e.getMessage(), AlertType.ERROR);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
