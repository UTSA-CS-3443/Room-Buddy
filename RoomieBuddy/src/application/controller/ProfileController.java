package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ProfileController implements Initializable, EventHandler<ActionEvent> {
	
    @FXML
    private RadioButton gaming;

    @FXML
    private RadioButton sports;

    @FXML
    private TextField university;

    @FXML
    private RadioButton yesParty;

    @FXML
    private RadioButton noParty;

    @FXML
    private RadioButton hiking;

    @FXML
    private RadioButton reading;

    @FXML
    private TextField bio;

    @FXML
    private RadioButton film;

    @FXML
    private TextField classification;

    @FXML
    private RadioButton music;

    @FXML
    private TextField major;

    @FXML
    private RadioButton veryClean;

    @FXML
    private RadioButton modClean;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton male;

    @FXML
    private TextField apartment;

    @FXML
    private RadioButton notClean;

    String data[] = new String[14];
	@Override
	public void handle(ActionEvent event) {
		try {		
			Parent root;
			root = FXMLLoader.load(getClass().getResource("../view/pick.fxml"));
			data[0] = classification.getText();
			data[1] = major.getText();
			data[4] = "false";
			data[5] = "false";
			data[6] = "false";
			data[7] = "false";
			data[8] = "false";
			data[9] = "false";
			if(veryClean.isSelected()) {
				data[2] = "veryClean";
			}
			else if(modClean.isSelected()) {
				data[2] = "modClean";
			}
			else if(notClean.isSelected()) {
				data[2] = "notClean";
			}
			else if(yesParty.isSelected())
				data[3] = "yesParty";
			else if(noParty.isSelected())
				data[3] = "noParty";
			//hobbies
			if(music.isSelected())
				data[4] = "true";
			if(film.isSelected())
				data[5] = "true";
			if(gaming.isSelected())
				data[6] = "true";
			if(sports.isSelected())
				data[7] = "true";
			if(hiking.isSelected())
				data[8] = "true";
			if(reading.isSelected())
				data[9] = "true";
			if(male.isSelected())
				data[10] = "male";
			else if(female.isSelected())
				data[10] = "female";
			data[11] = university.getText();
			data[12] = apartment.getText();
			data[13] = bio.getText();
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();	
				
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	 
	public void logout(ActionEvent event) {
		try {
			 
			Parent root;
			root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
