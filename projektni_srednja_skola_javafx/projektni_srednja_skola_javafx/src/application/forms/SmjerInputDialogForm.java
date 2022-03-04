package application.forms;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import dao.DAOFactory;
import dao.DAOFactoryType;
import dto.Skola;
import dto.Smjer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class SmjerInputDialogForm implements Initializable {

	private Stage stage;
	private Smjer smjer;
	private boolean forcedExit = false;

	@FXML
	private TextField idSmjeraText;
	@FXML
	private TextField nazivSmjeraText;
	@FXML
	private TextField zvanjeText;
	@FXML
	private RadioButton rbTri, rbCetiri;
	@FXML
	private ComboBox<Skola> skoleComboBox;

	private ObservableList<Skola> skoleList;
	@FXML
	private Button okButton;

	private List<Skola> skole;

	public SmjerInputDialogForm(Smjer smjer) {
		this.smjer = smjer;

		stage = new Stage();

		// Load the FXML file
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/SmjerInputDialog.fxml"));

			// Set this class as controller
			loader.setController(this);

			// Load the scene
			stage.setScene(new Scene(loader.load()));
			stage.setResizable(false);

			stage.setOnCloseRequest(e -> forcedExit = true);

			skoleList = FXCollections
					.observableArrayList(DAOFactory.getFactory(DAOFactoryType.MySQL).getSkolaDAO().skole("*"));
			skoleList.forEach(a -> System.out.println(a.getNaziv()));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		skoleComboBox.setItems(skoleList);
		skoleComboBox.getSelectionModel().selectFirst();
		skoleComboBox.setConverter(new StringConverter<Skola>() {
			@Override
			public String toString(Skola object) {
				return object.getJIB() + " - " + object.getNaziv();
			}

			@Override
			public Skola fromString(String string) {
				return skole.stream().filter(s -> s.getJIB().equals(string.split("-")[0].trim())
						&& s.getNaziv().equals(string.split("-")[1].trim())).findFirst().orElse(null);
			}
		});

		okButton.setOnAction(e -> {
			if (allFieldsValid()) {
				int trajanje = rbTri.isSelected() ? 3 : 4;
				if (smjer != null) {
					smjer.setNaziv(nazivSmjeraText.getText());
					smjer.setZvanje(zvanjeText.getText());
					smjer.setTrajanjeGodina(trajanje);
					smjer.setSkola(skoleComboBox.getSelectionModel().getSelectedItem());
				} else {
					smjer = new Smjer(Integer.parseInt(idSmjeraText.getText()), trajanje, nazivSmjeraText.getText(),
							zvanjeText.getText(), skoleComboBox.getSelectionModel().getSelectedItem());
				}
				Stage stage = (Stage) okButton.getScene().getWindow();

				stage.close();
			}
		});
	}

	public void showScene() {
		if (smjer != null) {
			idSmjeraText.setText(smjer.getIdSmjera().toString());
			idSmjeraText.setEditable(false);
		}
		initialize(null, null);
		stage.showAndWait();
	}

	private boolean allFieldsValid() {
		if (idSmjeraText.getText() == "" || nazivSmjeraText.getText() == "" || zvanjeText.getText() == "") {
			Utilities.showAlert(AlertType.ERROR, "ERROR", "Sva polja nisu validna ili nisu popunjena!", null);
			return false;
		}
		return true;
	}

	public Smjer getSmjer() {
		return smjer;
	}

	public boolean isForcedExit() {
		return forcedExit;
	}
}
