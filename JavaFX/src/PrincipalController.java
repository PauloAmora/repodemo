import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PrincipalController implements Initializable {

	private Principal application;

	public void setApp(Principal application) {
		this.application = application;
	}

	@FXML
	private AnchorPane AnchorPane;

	@FXML
	private TextArea textArea1;

	@FXML
	private TextField textField1;

	@FXML
	private Button buttonVermelho;

	@FXML
	private Button buttonVerde;

	@FXML
	private Button buttonAzul;

	@FXML
	void textoAzul(ActionEvent event) {
		if (application == null) {
		} else {
			application.goToVolta();
		}
	}

	@FXML
	void textoVerde(ActionEvent event) {
		if (application == null) {
		} else {
			if (!textField1.getText().isEmpty()) {
				textArea1.setText(textField1.getText());
				textArea1.setStyle("-fx-text-fill: green ;");

			}
		}
	}

	@FXML
	void textoVermelho(ActionEvent event) {
		if (application == null) {
		} else {
			if (!textField1.getText().isEmpty()) {
				textArea1.setText(textField1.getText());
				textArea1.setStyle("-fx-text-fill: red ;");

			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
