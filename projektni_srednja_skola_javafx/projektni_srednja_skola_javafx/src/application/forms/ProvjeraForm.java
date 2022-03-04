package application.forms;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;

import dao.DAOFactory;
import dao.DAOFactoryType;
import dto.PredmetNaSmjeru;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class ProvjeraForm implements Initializable {

	private Stage stage;
	private static String TITLE = "Provjere";

	@FXML
	private Button dodajButton;

	@FXML
	private Button ukloniButton;

	@FXML
	private Button ocijeniButton;

	@FXML
	private Button izmjeniButton;

	@FXML
	private Button pretraziButton;
	@FXML
	private Button opozoviButton;

	@FXML
	private TableView<Provjera> provjereTable;
	@FXML
	private TableColumn<Provjera, Date> datum;
	@FXML
	private TableColumn<Provjera, Integer> odjeljenje;
	@FXML
	private TableColumn<Provjera, Integer> razred;
	@FXML
	private TableColumn<Provjera, String> nazivPredmeta;
	@FXML
	private TableColumn<Provjera, String> nazivSmjera;
	@FXML
	private TableColumn<Provjera, String> tip;
	@FXML
	private TableColumn<Provjera, Time> trajanje;
	@FXML
	private TableColumn<Provjera, Integer> brNegativnih;
	@FXML
	private TableColumn<Provjera, Integer> brPrisutnih;
	@FXML
	private TableColumn<Provjera, Boolean> ponovljena;
	@FXML
	private TableColumn<Provjera, Integer> brProstorije;

	@FXML
	private DatePicker datumPicker;
	@FXML
	private TextField odjeljenjeText;
	@FXML
	private ComboBox<PredmetNaSmjeru> predmetSmjerComboBox;

	private ObservableList<PredmetNaSmjeru> predmetNaSmjeruList;
	private ObservableList<Provjera> provjereList;
	private boolean zakazivanje;

	public ProvjeraForm(boolean zakazivanje) {
		stage = new Stage();
		this.zakazivanje = zakazivanje;
		// Load the FXML file
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Provjera.fxml"));

			// Set this class as controller
			loader.setController(this);

			// Load the scene
			stage.setScene(new Scene(loader.load()));
			stage.setResizable(true);

			// Setup the window/stage
			stage.setTitle(TITLE);

			predmetNaSmjeruList = FXCollections.observableArrayList(
					DAOFactory.getFactory(DAOFactoryType.MySQL).getPredmetNaSmjeruDAO().predmetiNaSmjeru("*"));
			provjereList = FXCollections.observableArrayList(
					DAOFactory.getFactory(DAOFactoryType.MySQL).getProvjeraDAO().provjere(null, null, "*", "*"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		datum.setCellValueFactory(new Callback<CellDataFeatures<Provjera, Date>, ObservableValue<Date>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Date> call(CellDataFeatures<Provjera, Date> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getDatum());
			}
		});

		odjeljenje.setCellValueFactory(new Callback<CellDataFeatures<Provjera, Integer>, ObservableValue<Integer>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Integer> call(CellDataFeatures<Provjera, Integer> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getOdjeljenje());
			}
		});
		razred.setCellValueFactory(new Callback<CellDataFeatures<Provjera, Integer>, ObservableValue<Integer>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Integer> call(CellDataFeatures<Provjera, Integer> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getPredmetNaSmjeru().getRazred());
			}
		});
		nazivPredmeta.setCellValueFactory(new Callback<CellDataFeatures<Provjera, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Provjera, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getPredmetNaSmjeru().getPredmet().getNaziv());
			}
		});
		nazivSmjera.setCellValueFactory(new Callback<CellDataFeatures<Provjera, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Provjera, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getPredmetNaSmjeru().getSmjer().getNaziv());
			}
		});
		tip.setCellValueFactory(new Callback<CellDataFeatures<Provjera, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Provjera, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getTip());
			}
		});
		trajanje.setCellValueFactory(new Callback<CellDataFeatures<Provjera, Time>, ObservableValue<Time>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Time> call(CellDataFeatures<Provjera, Time> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getTrajanje());
			}
		});
		brNegativnih.setCellValueFactory(new Callback<CellDataFeatures<Provjera, Integer>, ObservableValue<Integer>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Integer> call(CellDataFeatures<Provjera, Integer> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getBrojNegativnihOcjena());
			}
		});
		brPrisutnih.setCellValueFactory(new Callback<CellDataFeatures<Provjera, Integer>, ObservableValue<Integer>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Integer> call(CellDataFeatures<Provjera, Integer> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getBrojPrisutnihUcenika());
			}
		});
		ponovljena.setCellValueFactory(new Callback<CellDataFeatures<Provjera, Boolean>, ObservableValue<Boolean>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Boolean> call(CellDataFeatures<Provjera, Boolean> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getPonovljena());
			}
		});
		brProstorije.setCellValueFactory(new Callback<CellDataFeatures<Provjera, Integer>, ObservableValue<Integer>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Integer> call(CellDataFeatures<Provjera, Integer> p) {
				return new ReadOnlyObjectWrapper(p.getValue().getProstorija());
			}
		});

		predmetSmjerComboBox.setItems(predmetNaSmjeruList);
		predmetSmjerComboBox.setConverter(new StringConverter<PredmetNaSmjeru>() {
			@Override
			public String toString(PredmetNaSmjeru object) {
				return object.getPredmet().getNaziv() + " - " + object.getSmjer().getNaziv();
			}

			@Override
			public PredmetNaSmjeru fromString(String string) {
				return predmetNaSmjeruList.stream()
						.filter(s -> s.getPredmet().getNaziv().equals(string.split("-")[0].trim())
								&& s.getSmjer().getNaziv().equals(string.split("-")[1].trim()))
						.findFirst().orElse(null);
			}
		});

		pretraziButton.setOnAction(e -> {
			Date datum = datumPicker.getValue() == null ? null
					: new Date(Date.valueOf(datumPicker.getValue()).getTime() + 24 * 60 * 60 * 1000);
			System.out.println(datum);
			System.out.println(Date.valueOf("2019-3-1"));
			System.out.println(Date.valueOf("2019-3-1").equals(datum));
			Integer odjeljenje = odjeljenjeText.getText().isEmpty() ? null : Integer.parseInt(odjeljenjeText.getText());
			PredmetNaSmjeru pns = predmetSmjerComboBox.getSelectionModel().getSelectedItem();
			String nazivPredmeta = pns == null ? "*" : pns.getPredmet().getNaziv();
			String nazivSmjera = pns == null ? "*" : pns.getSmjer().getNaziv();
			refresh(datum, odjeljenje, nazivPredmeta, nazivSmjera);
		});

		opozoviButton.setOnAction(e -> {
			datumPicker.setValue(null);
			odjeljenjeText.setText("");
			predmetSmjerComboBox.getSelectionModel().clearSelection();
			refresh(null, null, "*", "*");
		});

		dodajButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				ProvjeraDialogForm skd = new ProvjeraDialogForm(null);
				skd.showScene();

				if (!skd.isForcedExit() && DAOFactory.getFactory(DAOFactoryType.MySQL).getProvjeraDAO()
						.dodajProvjeru(skd.getProvjera())) {
					Utilities.showAlert(AlertType.INFORMATION, "Dodavanje uspjesno", "Provjera uspjesno dodat!", null);
					// skoleList.add(skd.getProvjera());
					refresh(null, null, "*", "*");
				}
			}
		});

		ukloniButton.setOnAction(e -> {
			Provjera pns = provjereTable.getSelectionModel().getSelectedItem();
			if (pns != null) {
				if (DAOFactory.getFactory(DAOFactoryType.MySQL).getProvjeraDAO().obirisProvjeru(pns.getDatum(),
						pns.getOdjeljenje(), pns.getPredmetNaSmjeru().getPredmet().getIdPredmeta(),
						pns.getPredmetNaSmjeru().getSmjer().getIdSmjera())) {
					Utilities.showAlert(AlertType.INFORMATION, "Brisanje uspjesno", "Provjera uspjesno obrisan!", null);
					refresh(null, null, "*", "*");
				}
			}
		});

		izmjeniButton.setOnAction(e -> {
			ProvjeraDialogForm skd = new ProvjeraDialogForm(provjereTable.getSelectionModel().getSelectedItem());
			skd.showScene();
			if (!skd.isForcedExit() && DAOFactory.getFactory(DAOFactoryType.MySQL).getProvjeraDAO()
					.azurirajProvjeru(skd.getProvjera())) {
				Utilities.showAlert(AlertType.INFORMATION, "Dodavanje uspjesno", "Smjer uspjesno dodata", null);
				// skoleList.add(skd.getSmjer());
				refresh(null, null, "*", "*");
			}

		});

		ocijeniButton.setOnAction(e -> {
			if (provjereTable.getSelectionModel().getSelectedItem() != null) {
				UcenikDetaljnoForm udf = new UcenikDetaljnoForm(provjereTable.getSelectionModel().getSelectedItem());
				udf.showScene();
			}
		});

		provjereTable.setItems(provjereList);
		if (zakazivanje) {
			ocijeniButton.setVisible(false);
		} else {
			dodajButton.setVisible(false);
			ukloniButton.setVisible(false);
			izmjeniButton.setVisible(false);
		}
	}

	private void refresh(Date datum, Integer odjeljenje, String nazivPredmeta, String nazivSmjera) {
		provjereList.clear();
		provjereList.addAll(FXCollections.observableArrayList(DAOFactory.getFactory(DAOFactoryType.MySQL)
				.getProvjeraDAO().provjere(datum, odjeljenje, nazivPredmeta, nazivSmjera)));
	}

	public void showScene() {

		initialize(null, null);
		stage.showAndWait();
	}
}
