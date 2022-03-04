package application.forms;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import dao.DAOFactory;
import dao.DAOFactoryType;
import dto.Predmet;
import dto.PredmetNaSmjeru;
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

public class PredmetNaSmjeruDialogForm implements Initializable {

	private Stage stage;
	private PredmetNaSmjeru predmetNaSmjeru;
	private boolean forcedExit = false;

	@FXML
	private TextField idPredmeta;
	@FXML
	private TextField nazivPredmetaText;
	@FXML
	private TextField razredText;
	@FXML
	private TextField minUsmenihText;
	@FXML
	private TextField minPismenihText;
	@FXML
	private RadioButton rbIzborni, rbObavezni;
	@FXML
	private ComboBox<Smjer> smjeroviComboBox;

	private ObservableList<Smjer> smjeroviList;
	@FXML
	private Button okButton;

	private List<Skola> skole;

	public PredmetNaSmjeruDialogForm(PredmetNaSmjeru predmetNaSmjeru) {
		this.predmetNaSmjeru = predmetNaSmjeru;

		stage = new Stage();

		// Load the FXML file
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/PredmetNaSmjeruDialog.fxml"));

			// Set this class as controller
			loader.setController(this);

			// Load the scene
			stage.setScene(new Scene(loader.load()));
			stage.setResizable(false);

			stage.setOnCloseRequest(e -> forcedExit = true);

			smjeroviList = FXCollections
					.observableArrayList(DAOFactory.getFactory(DAOFactoryType.MySQL).getSmjerDAO().smjerovi("*"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		smjeroviComboBox.setItems(smjeroviList);
		smjeroviComboBox.getSelectionModel().selectFirst();
		smjeroviComboBox.setConverter(new StringConverter<Smjer>() {
			@Override
			public String toString(Smjer object) {
				return object.getIdSmjera() + " - " + object.getNaziv();
			}

			@Override
			public Smjer fromString(String string) {
				return smjeroviList.stream().filter(s -> s.getIdSmjera().equals(string.split("-")[0].trim())
						&& s.getNaziv().equals(string.split("-")[1].trim())).findFirst().orElse(null);
			}
		});

		okButton.setOnAction(e -> {
			if (allFieldsValid()) {
				String tip = rbIzborni.isSelected() ? "I" : "O";
				if (predmetNaSmjeru != null) {
					predmetNaSmjeru.setPredmet(
							new Predmet(predmetNaSmjeru.getPredmet().getIdPredmeta(), nazivPredmetaText.getText()));
					predmetNaSmjeru.setTip(tip);
					predmetNaSmjeru.setRazred(Integer.parseInt(razredText.getText()));
					predmetNaSmjeru.setMinimalniBrojUsmenihProvjera(Integer.parseInt(minUsmenihText.getText()));
					predmetNaSmjeru.setMinimalniBrojUsmenihProvjera(Integer.parseInt(minPismenihText.getText()));
				} else {
					predmetNaSmjeru = new PredmetNaSmjeru(
							new Predmet(Integer.parseInt(idPredmeta.getText()), nazivPredmetaText.getText()),
							smjeroviComboBox.getSelectionModel().getSelectedItem(), tip,
							Integer.parseInt(razredText.getText()), Integer.parseInt(minUsmenihText.getText()),
							Integer.parseInt(minPismenihText.getText()));
				}
				Stage stage = (Stage) okButton.getScene().getWindow();

				stage.close();
			}
		});
	}

	public void showScene() {
		if (predmetNaSmjeru != null) {
			idPredmeta.setText(predmetNaSmjeru.getPredmet().getIdPredmeta().toString());
			idPredmeta.setEditable(false);
			smjeroviComboBox.setEditable(false);
		}
		initialize(null, null);
		stage.showAndWait();
	}

	private boolean allFieldsValid() {
		if (idPredmeta.getText() == "" || nazivPredmetaText.getText() == "" || razredText.getText() == ""
				|| minUsmenihText.getText() == "" || minPismenihText.getText() == "") {
			Utilities.showAlert(AlertType.ERROR, "ERROR", "Sva polja nisu validna ili nisu popunjena!", null);
			return false;
		}
		return true;
	}

	public PredmetNaSmjeru getPredmetNaSmjeru() {
		return predmetNaSmjeru;
	}

	public boolean isForcedExit() {
		return forcedExit;
	}
}
