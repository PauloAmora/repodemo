import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Principal extends Application {
	private Stage stage;

	public static void main(String[] args) {
		Application.launch(Principal.class, (java.lang.String[]) null);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			stage = primaryStage;
			stage.setTitle("Tela principal");
			goToPrincipal();
			primaryStage.show();
		} catch (Exception ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void goToPrincipal() {
		try {
			PrincipalController pController = (PrincipalController) replaceSceneContent("Principal.fxml");
			pController.setApp(this);

		} catch (Exception ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void goToVolta() {
		try {
			VoltaController pController = (VoltaController) replaceSceneContent("Volta.fxml");
			pController.setApp(this);
		} catch (Exception ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private Initializable replaceSceneContent(String fxml) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = Principal.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(Principal.class.getResource(fxml));
		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}
		Scene scene = new Scene(page, 800, 600);
		stage.setScene(scene);
		stage.sizeToScene();
		return (Initializable) loader.getController();
	}

}
