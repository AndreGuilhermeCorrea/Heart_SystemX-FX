package controller.fxml;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class BotherStage {

	private static BotherStage haveStage = null;
    private Stage stage;
    

    private BotherStage(Stage stage) {
        this.stage = stage;
    }

    // navegação entre telas é baseada no stage(janela) com titulo e uma cena
 	// renderizada,
 	// dentro da scene o parametro fxml
 	// scene e stage armazenadas com statics
    public static BotherStage instance(Stage stage) {
        if (haveStage == null) {
            haveStage = new BotherStage(stage);
        }
        return haveStage;
    }

    public Stage getStage() {
        return this.stage;
    }


    public void loadNewStage(Parent fxmlLoad) {
        if (stage != null) {
            Parent root = fxmlLoad;
            Scene scene = new Scene(root);
            Image systemIcon = new Image(getClass().getResourceAsStream("/icons/health-64.png"));
            stage.getIcons().add(systemIcon);
            stage.setTitle("HEART_SYSTEM_X-FX");
            stage.setResizable(false);
            stage.setMaximized(false);
            stage.setScene(scene);
            stage.show();
        }
    }
}
