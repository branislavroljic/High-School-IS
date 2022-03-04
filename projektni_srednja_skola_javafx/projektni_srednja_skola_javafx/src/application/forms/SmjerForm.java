package application.forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import dao.DAOFactory;
import dao.DAOFactoryType;
import dto.Smjer;
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

public class SmjerForm implements Initializable{

	
	private Stage stage;
	private static String TITLE = "SMJEROVI";
	
	@FXML
	private Button dodajButton;
	
	@FXML
	private Button ukloniButton;
	
	@FXML
	private Button izmjeniButton;
	
	@FXML
	private TableView<Smjer> smjeroviTable;
	@FXML private TableColumn<Smjer, Integer> idSmjera;
	@FXML private TableColumn<Smjer, Integer> trajanje;
	@FXML private TableColumn<Smjer, String> nazivSmjera;
	@FXML private TableColumn<Smjer, String> nazivSkole;
	@FXML private TableColumn<Smjer, String> zvanje;
	
	public ObservableList<Smjer> smjeroviList;
	
	public SmjerForm() {
			stage = new Stage();
		
		//Load the FXML file
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Smjer.fxml"));
			
			//Set this class as controller
			loader.setController(this);
			
			//Load the scene
			stage.setScene(new Scene(loader.load()));
			stage.setResizable(true);
			
			//Setup the window/stage
			stage.setTitle(TITLE);

			initialize(null, null);
			smjeroviList = FXCollections.observableArrayList(DAOFactory.getFactory(DAOFactoryType.MySQL).getSmjerDAO().smjerovi("*"));
			//refresh();
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idSmjera.setCellValueFactory(new Callback<CellDataFeatures<Smjer, Integer>, ObservableValue<Integer>>() {
		     @SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Integer> call(CellDataFeatures<Smjer, Integer >p) {
		         return new ReadOnlyObjectWrapper(p.getValue().getIdSmjera());
		     }
		  });
		
		trajanje.setCellValueFactory(new Callback<CellDataFeatures<Smjer, Integer>, ObservableValue<Integer>>() {
		     @SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Integer> call(CellDataFeatures<Smjer, Integer >p) {
		         return new ReadOnlyObjectWrapper(p.getValue().getTrajanjeGodina());
		     }
		  });
		nazivSmjera.setCellValueFactory(new Callback<CellDataFeatures<Smjer, String>, ObservableValue<String>>() {
		     @SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Smjer, String >p) {
		         return new ReadOnlyObjectWrapper(p.getValue().getNaziv());
		     }
		  });
		
		nazivSkole.setCellValueFactory(new Callback<CellDataFeatures<Smjer, String>, ObservableValue<String>>() {
		     @SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Smjer, String >p) {
		         return new ReadOnlyObjectWrapper(p.getValue().getSkola().getNaziv());
		     }
		  }); 
		zvanje.setCellValueFactory(new Callback<CellDataFeatures<Smjer, String>, ObservableValue<String>>() {
		     @SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<Smjer, String >p) {
		         return new ReadOnlyObjectWrapper(p.getValue().getZvanje());
		     }
		  });

		dodajButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		       
		    	SmjerInputDialogForm skd = new SmjerInputDialogForm(null);
		    	skd.showScene();
		    	
			    	if (!skd.isForcedExit() && DAOFactory.getFactory(DAOFactoryType.MySQL).getSmjerDAO().dodajSmjer(skd.getSmjer())) {
			    		Utilities.showAlert(AlertType.INFORMATION, "Dodavanje uspjesno", "Smjer uspjesno dodat!", null);
			    		//skoleList.add(skd.getSmjer());
			    		refresh();
			    	}
		    	}	
		});
		
		ukloniButton.setOnAction(e -> {
			Smjer Smjer = smjeroviTable.getSelectionModel().getSelectedItem();
			if(Smjer != null) {
				if (DAOFactory.getFactory(DAOFactoryType.MySQL).getSmjerDAO().obirisiSmjer(Smjer.getIdSmjera())) {
					Utilities.showAlert(AlertType.INFORMATION, "Brisanje uspjesno", "Smjer uspjesno obrisan!", null);
					refresh();
				}
			}
		});
		
		izmjeniButton.setOnAction(e -> {
			SmjerInputDialogForm skd = new SmjerInputDialogForm(smjeroviTable.getSelectionModel().getSelectedItem());
	    	skd.showScene();
		    	if (!skd.isForcedExit() && DAOFactory.getFactory(DAOFactoryType.MySQL).getSmjerDAO().azurirajSmjer(skd.getSmjer())) {
		    		Utilities.showAlert(AlertType.INFORMATION, "Dodavanje uspjesno", "Smjer uspjesno dodata", null);
		    		//skoleList.add(skd.getSmjer());
		    		refresh();
		    	}
	    	
		});
		
		smjeroviTable.setItems(smjeroviList);
	}
	
	private void refresh() {
		smjeroviList.clear();
		smjeroviList.addAll(FXCollections.observableArrayList(DAOFactory.getFactory(DAOFactoryType.MySQL).getSmjerDAO().smjerovi("*")));
	}
	
	public void showScene() {

		initialize(null, null);
		stage.showAndWait();
	}
}
