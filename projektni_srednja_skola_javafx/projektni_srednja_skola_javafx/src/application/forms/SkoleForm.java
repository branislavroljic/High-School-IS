package application.forms;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import dao.DAOFactory;
import dao.DAOFactoryType;
import dto.Adresa;
import dto.Skola;
import dto.Telefon;
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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SkoleForm implements Initializable {

	private Stage stage;
	private static String TITLE = "SKOLE";

	@FXML
	private Button dodajButton;

	@FXML
	private Button ukloniButton;

	@FXML
	private Button izmjeniButton;

	@FXML
	private TableView<Skola> skoleTable;
	@FXML
	private TableColumn<Skola, String> jib;
	@FXML
	private TableColumn<Skola, String> naziv;
	@FXML
	private TableColumn<Skola, Adresa> adresa;
	@FXML
	private TableColumn<Skola, String> vrsta;
	@FXML
	private TableColumn<Skola, String> email;
	@FXML
	private TableColumn<Skola, List<Telefon>> telefon;
	@FXML
	private TableColumn<Skola, String> osnivac;

	public ObservableList<Skola> skoleList;

	public SkoleForm() {
		stage = new Stage();

		// Load the FXML file
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Skole.fxml"));

			// Set this class as controller
			loader.setController(this);

			// Load the scene
			stage.setScene(new Scene(loader.load()));
			stage.setResizable(true);

			// Setup the window/stage
			stage.setTitle(TITLE);

			initialize(null, null);
			skoleList = FXCollections
					.observableArrayList(DAOFactory.getFactory(DAOFactoryType.MySQL).getSkolaDAO().skole("*"));
			// refresh();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("zvaoo");
		jib.setCellValueFactory(new Callback<CellDataFeatures<Skola, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Skola, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getJIB());
			}
		});
		naziv.setCellValueFactory(new Callback<CellDataFeatures<Skola, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Skola, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getNaziv());
			}
		});

		adresa.setCellValueFactory(new Callback<CellDataFeatures<Skola, Adresa>, ObservableValue<Adresa>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Adresa> call(CellDataFeatures<Skola, Adresa> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getAdresa());
			}
		});
		vrsta.setCellValueFactory(new Callback<CellDataFeatures<Skola, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Skola, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getVrsta());
			}
		});
		email.setCellValueFactory(new Callback<CellDataFeatures<Skola, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Skola, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getEmail());
			}
		});
		telefon.setCellValueFactory(
				new Callback<CellDataFeatures<Skola, List<Telefon>>, ObservableValue<List<Telefon>>>() {
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public ObservableValue<List<Telefon>> call(CellDataFeatures<Skola, List<Telefon>> p) {
						return new ReadOnlyObjectWrapper(p.getValue().getBrojeviTelefona());
					}
				});
		osnivac.setCellValueFactory(new Callback<CellDataFeatures<Skola, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Skola, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getOsnivac());
			}
		});

		dodajButton.setOnAction(new EventHandler<ActionEvent>() {
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

		ukloniButton.setOnAction(e -> {
			Skola skola = skoleTable.getSelectionModel().getSelectedItem();
			if (skola != null) {
				if (DAOFactory.getFactory(DAOFactoryType.MySQL).getSkolaDAO().obrisiSkolu(skola.getJIB())) {
					Utilities.showAlert(AlertType.INFORMATION, "Brisanje uspjesno", "Skola uspjesno obrisana", null);
					refresh();
				}
			}
		});

		izmjeniButton.setOnAction(e -> {
			SkoleInputDialogForm skd = new SkoleInputDialogForm(skoleTable.getSelectionModel().getSelectedItem());
			skd.showScene();
			if (!skd.isForcedExit()
					&& DAOFactory.getFactory(DAOFactoryType.MySQL).getSkolaDAO().azurirajSkolu(skd.getSkola())) {
				Utilities.showAlert(AlertType.INFORMATION, "Dodavanje uspjesno", "Skola uspjesno dodata", null);
				refresh();
			}

		});
		skoleTable.setItems(skoleList);
	}

	private void refresh() {
		skoleList.clear();
		skoleList.addAll(FXCollections
				.observableArrayList(DAOFactory.getFactory(DAOFactoryType.MySQL).getSkolaDAO().skole("*")));
	}

	public void showScene() {

		initialize(null, null);
		stage.showAndWait();
	}

}
