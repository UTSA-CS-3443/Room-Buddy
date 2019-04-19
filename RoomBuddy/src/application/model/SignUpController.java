package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController implements EventHandler<ActionEvent>, Initializable {

	@FXML TextField fullName;
	@FXML TextField userName;
	@FXML PasswordField passPhrase;
	@FXML PasswordField passPhraseConfirm;
	@FXML TextField phoneNum;
	@FXML TextField eMail;
	@FXML Label passNoMatch;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@Override
	public void handle(ActionEvent arg0) {
		if(!passPhrase.getText().equals(passPhraseConfirm.getText())) {
			passNoMatch.setText("Passwords do not match. Please try again.");
		} else {
			// TODO: write user info to csv.
		}
		
	}

}