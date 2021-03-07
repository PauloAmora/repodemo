import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VoltaController implements Initializable{
	private Principal application;

	public void setApp(Principal application) {
		this.application = application;
	}
    @FXML
    private Button botao2;

    @FXML
    private Button botao1;
    

    @FXML
    private TableColumn<Pessoa, String> tbcNome;

    @FXML
    private TableView<Pessoa> tableView;

    @FXML
    private TableColumn<Pessoa, String> tbcOutros;

    @FXML
    private TableColumn<Pessoa, Integer> tbcIdade;

    @FXML
    private TableColumn<Pessoa, String> tbcSobrenome;


    @FXML
    void volta(ActionEvent event) {
    	application.goToPrincipal();
    }

	@Override
	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		tbcNome.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("nome"));
		tbcSobrenome.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("sobrenome"));
		tbcIdade.setCellValueFactory(new PropertyValueFactory<Pessoa, Integer>("idade"));
		tbcOutros.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("outros"));
		tableView.setItems(FXCollections.observableArrayList(Pessoa.pessoas()));
	}
	

    @FXML
    void removeElemento(ActionEvent event) {
    	tableView.getItems().remove(tableView.getSelectionModel().getSelectedIndex());
    }



}
