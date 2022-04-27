package de.thluebeck.schulung.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import de.thluebeck.schulung.model.Seminar;

public class SeminarEditDialogController {

    @FXML
    private TextField nummerField;
    @FXML
    private TextField themaField;
    @FXML
    private TextField ortField;
    @FXML
    private TextField anzahlTageField;

    private Stage dialogStage;
    private Seminar seminar;
    private boolean saveClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;

        nummerField.setText(Integer.toString(seminar.getNummer()));
        themaField.setText(seminar.getThema());
        ortField.setText(seminar.getOrt());
        anzahlTageField.setText(Integer.toString(seminar.getAnzahlTage()));
    }

    /**
     * Returns true if the user clicked Speichern, false otherwise.
     * 
     * @return
     */
    public boolean isSaveClicked() {
        return saveClicked;
    }

    /**
     * Called when the user clicks Speichern.
     */
    @FXML
    private void handleSave() {
        if (isInputValid()) {
        	seminar.setNummer(Integer.parseInt(nummerField.getText()));
        	seminar.setThema(themaField.getText());
        	seminar.setOrt(ortField.getText());
        	seminar.setAnzahlTage(Integer.parseInt(anzahlTageField.getText()));

            saveClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (themaField.getText() == null || themaField.getText().length() == 0) {
            errorMessage += "Thema fehlt!\n"; 
        }
        if (ortField.getText() == null || ortField.getText().length() == 0) {
            errorMessage += "Ort fehlt!\n"; 
        }

        if (nummerField.getText() == null || nummerField.getText().length() == 0) {
            errorMessage += "Nummer fehlt!\n"; 
        } else {
            try {
                Integer.parseInt(nummerField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Keine gültige Nummer (muss ganzzahlig sein)!\n"; 
            }
        }

        if (anzahlTageField.getText() == null || anzahlTageField.getText().length() == 0) {
            errorMessage += "Anzahl Tage fehlt!\n"; 
        } else {
            try {
                Integer.parseInt(anzahlTageField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Keine gültige Anzahl Tage (muss ganzzahlig sein)!\n"; 
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Ungültige Einträge");
            alert.setHeaderText("Bitte korrigieren Sie die ungültigen Einträge!");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }

}
