package application.forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import dao.DAOFactory;
import dao.DAOFactoryType;
import dto.PredmetNaSmjeru;
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
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PredmetNaSmjeruForm implements Initializable {

	private Stage stage;
	private static String TITLE = "Predmeti na smjeru";

	@FXML
	private Button dodajButton;

	@FXML
	private Button ukloniButton;

	@FXML
	private Button izmjeniButton;

	@FXML
	private TableView<PredmetNaSmjeru> pnsTable;
	@FXML
	private TableColumn<PredmetNaSmjeru, String> nazivPredmeta;
	@FXML
	private TableColumn<PredmetNaSmjeru, String> nazivSmjera;
	@FXML
	private TableColumn<PredmetNaSmjeru, String> tip;
	@FXML
	private TableColumn<PredmetNaSmjeru, Integer> razred;
	@FXML
	private TableColumn<PredmetNaSmjeru, Integer> minUsmenih;
	@FXML
	private TableColumn<PredmetNaSmjeru, Integer> minPismenih;

	public ObservableList<PredmetNaSmjeru> pnsList;

	public PredmetNaSmjeruForm() {
		stage = new Stage();

		// Load the FXML file
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/PredmetNaSmjeru.fxml"));

			// Set this class as controller
			loader.setController(this);

			// Load the scene
			stage.setScene(new Scene(loader.load()));
			stage.setResizable(true);

			// Setup the window/stage
			stage.setTitle(TITLE);

			initialize(null, null);
			pnsList = FXCollections.observableArrayList(
					DAOFactory.getFactory(DAOFactoryType.MySQL).getPredmetNaSmjeruDAO().predmetiNaSmjeru("*"));
			// refresh();
			pnsList.forEach(e -> System.out.println(e.getPredmet().getNaziv()));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nazivPredmeta.setCellValueFactory(
				new Callback<CellDataFeatures<PredmetNaSmjeru, String>, ObservableValue<String>>() {
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public ObservableValue<String> call(CellDataFeatures<PredmetNaSmjeru, String> p) {
						return new ReadOnlyObjectWrapper(p.getValue().getPredmet().getNaziv());
					}
				});

		nazivSmjera.setCellValueFactory(
				new Callback<CellDataFeatures<PredmetNaSmjeru, String>, ObservableValue<String>>() {
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public ObservableValue<String> call(CellDataFeatures<PredmetNaSmjeru, String> p) {
						return new ReadOnlyObjectWrapper(p.getValue().getSmjer().getNaziv());
					}
				});
		tip.setCellValueFactory(new Callback<CellDataFeatures<PredmetNaSmjeru, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<PredmetNaSmjeru, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getTip());
			}
		});

		razred.setCellValueFactory(
				new Callback<CellDataFeatures<PredmetNaSmjeru, Integer>, ObservableValue<Integer>>() {
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public ObservableValue<Integer> call(CellDataFeatures<PredmetNaSmjeru, Integer> p) {
						return new ReadOnlyObjectWrapper(p.getValue().getRazred());
					}
				});
		minUsmenih.setCellValueFactory(
				new Callback<CellDataFeatures<PredmetNaSmjeru, Integer>, ObservableValue<Integer>>() {
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public ObservableValue<Integer> call(CellDataFeatures<PredmetNaSmjeru, Integer> p) {
						return new ReadOnlyObjectWrapper(p.getValue().getMinimalniBrojUsmenihProvjera());
					}
				});
		minPismenih.setCellValueFactory(
				new Callback<CellDataFeatures<PredmetNaSmjeru, Integer>, ObservableValue<Integer>>() {
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public ObservableValue<Integer> call(CellDataFeatures<PredmetNaSmjeru, Integer> p) {
						return new ReadOnlyObjectWrapper(p.getValue().getMinimalniBrojPismenihProvjera());
					}
				});

		dodajButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				PredmetNaSmjeruDialogForm skd = new PredmetNaSmjeruDialogForm(null);
				skd.showScene();

				if (!skd.isForcedExit() && DAOFactory.getFactory(DAOFactoryType.MySQL).getPredmetNaSmjeruDAO()
						.dodajPredmetNaSmjeru(skd.getPredmetNaSmjeru())) {
					Utilities.showAlert(AlertType.INFORMATION, "Dodavanje uspjesno", "PredmetNaSmjeru uspjesno dodat!",
							null);
					// skoleList.add(skd.getPredmetNaSmjeru());
					refresh();
				}
			}
		});

		ukloniButton.setOnAction(e -> {
			PredmetNaSmjeru pns = pnsTable.getSelectionModel().getSelectedItem();
			if (pns != null) {
				if (DAOFactory.getFactory(DAOFactoryType.MySQL).getPredmetNaSmjeruDAO()
						.obrisiPredmetNaSmjeru(pns.getPredmet().getIdPredmeta(), pns.getSmjer().getIdSmjera())) {
					Utilities.showAlert(AlertType.INFORMATION, "Brisanje uspjesno", "PredmetNaSmjeru uspjesno obrisan!",
							null);
					refresh();
				}
			}
		});

		izmjeniButton.setOnAction(e -> {
			PredmetNaSmjeruDialogForm skd = new PredmetNaSmjeruDialogForm(
					pnsTable.getSelectionModel().getSelectedItem());
			skd.showScene();
			if (!skd.isForcedExit() && DAOFactory.getFactory(DAOFactoryType.MySQL).getPredmetNaSmjeruDAO()
					.azurirajPredmetNaSmjeru(skd.getPredmetNaSmjeru())) {
				Utilities.showAlert(AlertType.INFORMATION, "Dodavanje uspjesno", "Smjer uspjesno dodata", null);
				// skoleList.add(skd.getSmjer());
				refresh();
			}

		});

//		jib.setCellValueFactory(new PropertyValueFactory<Smjer,String>("jib"));
//		naziv.setCellValueFactory(new PropertyValueFactory<Smjer,String>("naziv"));
//		adresa.setCellValueFactory(new PropertyValueFactory<Smjer, Adresa>("adresa"));
//		vrsta.setCellValueFactory(new PropertyValueFactory<Smjer,String>("vrsta"));
//		email.setCellValueFactory(new PropertyValueFactory<Smjer,String>("email"));
//		telefon.setCellValueFactory(new PropertyValueFactory<Smjer, List<Telefon>>("brojeviTelefona"));
//		osnivac.setCellValueFactory(new PropertyValueFactory<Smjer,String>("osnivac"));

		pnsTable.setItems(pnsList);
	}

	private void refresh() {
		pnsList.clear();
		pnsList.addAll(FXCollections.observableArrayList(
				DAOFactory.getFactory(DAOFactoryType.MySQL).getPredmetNaSmjeruDAO().predmetiNaSmjeru("*")));
	}

	public void showScene() {

		initialize(null, null);
		stage.showAndWait();
	}
}
