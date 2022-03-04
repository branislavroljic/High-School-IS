package application.forms;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import dto.Adresa;
import dto.Skola;
import dto.Telefon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SkoleInputDialogForm implements Initializable {

	private Stage stage;
	private Skola skola;
	private boolean forcedExit = false;

	@FXML
	private TextField jibText;
	@FXML
	private TextField nazivText;
	@FXML
	private TextField adresaText;
	@FXML
	private TextField vrstaText;
	@FXML
	private TextField emailText;
	@FXML
	private TextField telefonText;
	@FXML
	private TextField osnivacText;

	@FXML
	private Button okButton;

	public SkoleInputDialogForm(Skola skola) {
		this.skola = skola;

		stage = new Stage();

		// Load the FXML file
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/SkoleInputDialog.fxml"));

			// Set this class as controller
			loader.setController(this);

			// Load the scene
			stage.setScene(new Scene(loader.load()));
			stage.setResizable(false);

			stage.setOnCloseRequest(e -> forcedExit = true);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		okButton.setOnAction(e -> {
			if (allFieldsValid()) {

				String adresaParam[] = adresaText.getText().split(",");
				Adresa adresa = new Adresa(Integer.parseInt(adresaParam[0].trim()), adresaParam[1].trim(),
						adresaParam[2].trim(), adresaParam[3].trim());
				String jib = jibText.getText();
				List<String> telefoniString = Arrays.asList(telefonText.getText().split(","));
				List<Telefon> telefoniList = new ArrayList<>();
				telefoniString.forEach(t -> telefoniList.add(new Telefon(t.trim(), jib)));
				if (skola != null) {
					skola.setNaziv(nazivText.getText());
					skola.setAdresa(adresa);
					skola.setBrojeviTelefona(telefoniList);
					skola.setVrsta(vrstaText.getText());
					skola.setEmail(emailText.getText());
					skola.setOsnivac(osnivacText.getText());
				} else {
					skola = new Skola(jibText.getText(), nazivText.getText(), adresa, telefoniList, vrstaText.getText(),
							emailText.getText(), osnivacText.getText());
				}
				Stage stage = (Stage) okButton.getScene().getWindow();
				stage.close();

			}
		});
	}

	public void showScene() {
		if (skola != null) {
			jibText.setText(skola.getJIB());
			jibText.setEditable(false);
		}
		stage.showAndWait();
	}

	private boolean allFieldsValid() {
		if (jibText.getText() == "" || nazivText.getText() == "" || adresaText.getText() == ""
				|| vrstaText.getText() == "" || telefonText.getText() == "" || osnivacText.getText() == "") {
			Utilities.showAlert(AlertType.ERROR, "ERROR", "Sva polja nisu validna ili nisu popunjena!", null);
			return false;
		}
		return true;
	}

	public Skola getSkola() {
		return skola;
	}

	public boolean isForcedExit() {
		return forcedExit;
	}
}
