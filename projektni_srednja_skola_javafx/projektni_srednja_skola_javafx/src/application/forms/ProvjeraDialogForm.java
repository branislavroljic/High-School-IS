package application.forms;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import dao.DAOFactory;
import dao.DAOFactoryType;
import dto.PredmetNaSmjeru;
import dto.Provjera;
import dto.Skola;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ProvjeraDialogForm implements Initializable {

	private Stage stage;
	private Provjera provjera;
	private boolean forcedExit = false;

	@FXML
	private DatePicker datum;
	@FXML
	private TextField odjeljenjeText;
	@FXML
	private TextField trajanjeText;
	@FXML
	private TextField brPrisutnihText;
	@FXML
	private RadioButton rbPonovljena, rbUsmena, rbPismena;
	@FXML
	private ComboBox<PredmetNaSmjeru> predmetSmjerComboBox;
	@FXML
	private ComboBox<Integer> prostorijeComboBox;

	private ObservableList<PredmetNaSmjeru> predmetNaSmjeruList;
	private ObservableList<Integer> prostorijeList;
	@FXML
	private Button okButton;

	private List<Skola> skole;

	public ProvjeraDialogForm(Provjera provjera) {
		this.provjera = provjera;

		stage = new Stage();

		// Load the FXML file
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/ProvjeraDialog.fxml"));

			// Set this class as controller
			loader.setController(this);

			// Load the scene
			stage.setScene(new Scene(loader.load()));
			stage.setResizable(false);

			stage.setOnCloseRequest(e -> forcedExit = true);

			predmetNaSmjeruList = FXCollections.observableArrayList(
					DAOFactory.getFactory(DAOFactoryType.MySQL).getPredmetNaSmjeruDAO().predmetiNaSmjeru("*"));
			prostorijeList = FXCollections.observableArrayList(
					DAOFactory.getFactory(DAOFactoryType.MySQL).getProstorijaDAO().brojeviProstorija());

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		predmetSmjerComboBox.setItems(predmetNaSmjeruList);
		predmetSmjerComboBox.getSelectionModel().selectFirst();
		prostorijeComboBox.setItems(prostorijeList);
		prostorijeComboBox.getSelectionModel().selectFirst();
		predmetSmjerComboBox.setConverter(new StringConverter<PredmetNaSmjeru>() {
			@Override
			public String toString(PredmetNaSmjeru object) {
				return object.getPredmet().getNaziv() + " - " + object.getSmjer().getNaziv() + " - razred: " + object.getRazred();
			}

			@Override
			public PredmetNaSmjeru fromString(String string) {
				return predmetNaSmjeruList.stream()
						.filter(s -> s.getPredmet().getNaziv().equals(string.split("-")[0].trim())
								&& s.getSmjer().getNaziv().equals(string.split("-")[1].trim()))
						.findFirst().orElse(null);
			}
		});

		okButton.setOnAction(e -> {
			if (allFieldsValid()) {
				String tip = rbUsmena.isSelected() ? "u" : "p";
				Boolean ponovljena = tip == "u" ? null : rbPonovljena.isSelected();
				if (provjera != null) {
					provjera.setTip(tip);
					provjera.setPonovljena(ponovljena);
					provjera.setTrajanje(Integer.valueOf(trajanjeText.getText()));
					provjera.setProstorija(prostorijeComboBox.getSelectionModel().getSelectedItem());
				} else {
					provjera = new Provjera(java.sql.Date.valueOf(datum.getValue()),
							Integer.parseInt(odjeljenjeText.getText()),
							predmetSmjerComboBox.getSelectionModel().getSelectedItem(), tip,
							Integer.parseInt(trajanjeText.getText()), 0, 0, ponovljena,
							prostorijeComboBox.getSelectionModel().getSelectedItem());
				}
				Stage stage = (Stage) okButton.getScene().getWindow();

				stage.close();
			}
		});
	}

	public void showScene() {
		if (provjera != null) {
			datum.setVisible(false);
			predmetSmjerComboBox.setVisible(false);
			odjeljenjeText.setText(provjera.getOdjeljenje().toString());
			odjeljenjeText.setEditable(false);
		}
		initialize(null, null);
		stage.showAndWait();
	}

	private boolean allFieldsValid() {
		if (odjeljenjeText.getText() == "" || trajanjeText.getText() == "") {
			Utilities.showAlert(AlertType.ERROR, "ERROR", "Sva polja nisu validna ili nisu popunjena!", null);
			return false;
		}
		return true;
	}

	public Provjera getProvjera() {
		return provjera;
	}

	public boolean isForcedExit() {
		return forcedExit;
	}
}
