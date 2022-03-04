package application.forms;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import dao.DAOFactory;
import dao.DAOFactoryType;
import dto.Provjera;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Callback;

public class UcenikDetaljnoForm implements Initializable {

	private Stage stage;
	private static String TITLE = "Ucenici";

	@FXML
	private Button ocijeniButton;
	@FXML
	private TextField ocjenaText;
	@FXML
	private TableView<List<Object>> uceniciTable;
	@FXML
	private TableColumn<Object, String> jmb;
	@FXML
	private TableColumn<Object, String> prezimeIme;
	@FXML
	private TableColumn<Object, String> skola;
	@FXML
	private TableColumn<Object, String> smjer;
	@FXML
	private TableColumn<Object, String> razredOdjeljenje;
	@FXML
	private TableColumn<Object, String> razrednik;
	@FXML
	private TableColumn<Object, Double> prosjek;

	public ObservableList<List<Object>> uceniciList;

	private Provjera provjera;

	public UcenikDetaljnoForm(Provjera provjera) {
		stage = new Stage();

		this.provjera = provjera;
		// Load the FXML file
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/UcenikDetaljno.fxml"));

			// Set this class as controller
			loader.setController(this);

			// Load the scene
			stage.setScene(new Scene(loader.load()));
			stage.setResizable(true);

			// Setup the window/stage
			stage.setTitle(TITLE);

			initialize(null, null);
			uceniciList = FXCollections.observableArrayList(
					DAOFactory.getFactory(DAOFactoryType.MySQL).getUcenikDetaljnoDAO().uceniciDetalji());
			// refresh();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("zvaoo");
		jmb.setCellValueFactory(new Callback<CellDataFeatures<Object, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Object, String> p) {
				return new ReadOnlyObjectWrapper(((List<Object>) p.getValue()).get(0).toString());
			}
		});
		prezimeIme.setCellValueFactory(new Callback<CellDataFeatures<Object, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Object, String> p) {
				return new ReadOnlyObjectWrapper(((List<Object>) p.getValue()).get(1).toString());
			}
		});
		skola.setCellValueFactory(new Callback<CellDataFeatures<Object, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Object, String> p) {
				return new ReadOnlyObjectWrapper(((List<Object>) p.getValue()).get(2).toString());
			}
		});
		smjer.setCellValueFactory(new Callback<CellDataFeatures<Object, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Object, String> p) {
				return new ReadOnlyObjectWrapper(((List<Object>) p.getValue()).get(3).toString());
			}
		});

		razredOdjeljenje.setCellValueFactory(new Callback<CellDataFeatures<Object, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Object, String> p) {
				return new ReadOnlyObjectWrapper(((List<Object>) p.getValue()).get(4).toString());
			}
		});
		razrednik.setCellValueFactory(new Callback<CellDataFeatures<Object, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Object, String> p) {
				return new ReadOnlyObjectWrapper(((List<Object>) p.getValue()).get(5).toString());
			}
		});

		prosjek.setCellValueFactory(new Callback<CellDataFeatures<Object, Double>, ObservableValue<Double>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Double> call(CellDataFeatures<Object, Double> p) {
				return new ReadOnlyObjectWrapper(Double.parseDouble(((List<Object>) p.getValue()).get(6).toString()));
			}
		});
		ocijeniButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				SkoleInputDialogForm skd = new SkoleInputDialogForm(null);
				skd.showScene();

				if (!skd.isForcedExit()
						&& DAOFactory.getFactory(DAOFactoryType.MySQL).getSkolaDAO().dodajSkolu(skd.getSkola())) {
					Utilities.showAlert(AlertType.INFORMATION, "Dodavanje uspjesno", "Skola uspjesno dodata", null);
					refresh();
				}
			}
		});
		ocijeniButton.setOnAction(e -> {
			if (ocjenaText.getText().isEmpty() || Integer.parseInt(ocjenaText.getText()) < 0
					|| Integer.parseInt(ocjenaText.getText()) > 5) {
				Utilities.showAlert(AlertType.ERROR, "Greska", "Neispravan unos", "");
				return;
			}
			if (uceniciTable.getSelectionModel().getSelectedItem() != null) {
				DAOFactory.getFactory(DAOFactoryType.MySQL).getProvjeraDAO().evidentirajOcjenuIzProvjere(provjera,
						(String) ((List<Object>) uceniciTable.getSelectionModel().getSelectedItem()).get(0),
						Integer.parseInt(ocjenaText.getText()));
				refresh();
			}
		});
		uceniciTable.setItems(uceniciList);
		if (provjera == null) {
			ocijeniButton.setVisible(false);
			ocjenaText.setVisible(false);
		}
	}

	private void refresh() {
		uceniciList.clear();
		uceniciList.addAll(FXCollections.observableArrayList(
				DAOFactory.getFactory(DAOFactoryType.MySQL).getUcenikDetaljnoDAO().uceniciDetalji()));
	}

	public void showScene() {

		initialize(null, null);
		stage.showAndWait();
	}

}
