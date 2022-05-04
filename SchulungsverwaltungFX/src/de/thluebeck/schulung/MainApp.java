
package de.thluebeck.schulung;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import de.thluebeck.schulung.model.Seminar;
import de.thluebeck.schulung.view.SeminarEditDialogController;
import de.thluebeck.schulung.view.SeminarOverviewController;

public class MainApp extends Application {
// sasdads
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ObservableList<Seminar> seminarData = FXCollections.observableArrayList();
	
	public MainApp() {
		seminarData.add(new Seminar(123, "Luebeck", "Datenbanken", 3));
		seminarData.add(new Seminar(124, "Hamburg", "Projektmanagement", 2));
		seminarData.add(new Seminar(125, "Flensburg", "Betriebssysteme", 2));
		seminarData.add(new Seminar(126, "Hamburg", "Programmieren I", 3));
		seminarData.add(new Seminar(127, "Neumuenster", "Programmieren II", 3));
		seminarData.add(new Seminar(128, "Kiel", "Datenbanken", 2));
		seminarData.add(new Seminar(129, "Elmshorn", "Zeitmanagement", 1));
		seminarData.add(new Seminar(130, "Hannover", "Datenbanken", 2));
		seminarData.add(new Seminar(131, "Kiel", "Projektmanagement", 1));
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Schulungsverwaltung");
		
		initRootLayout();
		showSeminarOverview();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showSeminarOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/SeminarOverview.fxml"));
		
			AnchorPane seminarOverview = (AnchorPane) loader.load();
			
			rootLayout.setCenter(seminarOverview);
			
			SeminarOverviewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Opens a dialog to edit details for the specified seminar. If the user
	 * clicks Save, the changes are saved into the provided seminar object and true
	 * is returned.
	 * 
	 * @param seminar the seminar object to be edited
	 * @return true if the user clicked Save, false otherwise.
	 */
	public boolean showSeminarEditDialog(Seminar seminar) {
	    try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/SeminarEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Bearbeite Seminardaten");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the seminar into the controller.
	        SeminarEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setSeminar(seminar);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isSaveClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public ObservableList<Seminar> getSeminarData() {
		return seminarData;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}
}
