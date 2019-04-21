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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

public class SearchController implements Initializable, EventHandler<ActionEvent> {

	public static String selectedUni = null;
	public static String selectedApt = null;
	@FXML ImageView background;
	@FXML MenuButton uniSelect;
	@FXML MenuItem utsa;
	@FXML MenuButton aptSelect;
	@FXML MenuItem luxx;
	/**
	 * Handles when "Edit Profile" button is pushed. Sends user to profile page
	 * Broken rn? Dont know why? This is how i always have switched views
	 */
	public void handle(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation((getClass().getResource("../view/Profile.fxml")));
			Parent profileParent = loader.load();
			Scene profileScene = new Scene(profileParent);		
			Main.stage.setScene(profileScene);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Handles when UTSA is selected from dropdown menu. Set the text menu to show the selection, update the selected uni string to perform logic on.
	 * This is hardcoded af. Definitely will be changed later to read from csv and hopefully create a dynamic dropdown menu
	 * For the sake of the demo tho...
	 * @param event ActionEvent
	 */
	public void handleUTSA(ActionEvent event) {
		uniSelect.setText(utsa.getText());
		selectedUni = "UTSA";
	}
	
	/**
	 * Handles when Luxx is selected. Make sure on demo to use only UTSA and Luxx cuz these are going to be the only ones hardcoded to work for now.
	 * @param event Actionevent
	 */
	public void handleLuxx(ActionEvent event) {
		aptSelect.setText(luxx.getText());
		selectedApt = "The Luxx";
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		try {
			uniSelect.setText("Select a University");
			aptSelect.setText("Select an Apartment");
			
		}
		catch(Exception e) {
			System.out.println("Could not initialize properly");
		}
	}
}
