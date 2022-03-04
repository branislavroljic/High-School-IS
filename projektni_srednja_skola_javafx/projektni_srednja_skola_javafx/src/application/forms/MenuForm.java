package application.forms;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuForm implements Initializable {

	private Stage stage;
	private static String TITLE = "Dobrodosli";

	private MenuItem skole, smjerovi;

	@FXML
	private MenuButton sifarniciButton;

	@FXML
	private Button predmetNaSmjeruButton;
	@FXML
	private Button zakaziProvjeruButton;
	@FXML
	private Button ocijeniUcenikeButton;
	@FXML
	private Button pregledInfoButton;

	public MenuForm() {

		stage = new Stage();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Menu.fxml"));

			// Set this class as controller
			loader.setController(this);

			// Load the scene
			stage.setScene(new Scene(loader.load()));
			stage.setResizable(false);

			// Setup the window/stage
			stage.setTitle(TITLE);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void showStage() {
		stage.showAndWait();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		skole = new MenuItem("Pregled skola");
		smjerovi = new MenuItem("Pregled smjerova po skolama");

		sifarniciButton.getItems().clear();
		sifarniciButton.getItems().addAll(skole, smjerovi);

		skole.setOnAction(e -> new SkoleForm().showScene());
		smjerovi.setOnAction(e -> new SmjerForm().showScene());
		predmetNaSmjeruButton.setOnAction(e -> new PredmetNaSmjeruForm().showScene());
		zakaziProvjeruButton.setOnAction(e -> new ProvjeraForm(true).showScene());
		ocijeniUcenikeButton.setOnAction(e -> new ProvjeraForm(false).showScene());
		pregledInfoButton.setOnAction(e -> new UcenikDetaljnoForm(null).showScene());

	}
}
