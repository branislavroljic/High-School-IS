package application.forms;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Utilities {

	public static void showAlert(AlertType type, String title, String headerText, String contextText) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contextText);
		alert.showAndWait();
	}
}
