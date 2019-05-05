package application.controller;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.Main;
import application.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * This class handles the Results.fxml   
 * @author Tiffany Tabourne, Anna Arroyo
 *
 */
public class ResultsController implements EventHandler<ActionEvent> {
	
	@FXML ListView<User> userList = new ListView<User>();
	@FXML ObservableList<User> userObsList;
	
	@FXML 
	private TextArea roommateInfo;
	
	@FXML 
	private Button logout; 
	
	/*
	
	public void start(Stage primaryStage) {
		try {
			
			loadResults("results.csv"); 
						

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
*/	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

		
	}

	/**
	 * Handles when go back button is pushed. Sends user to the pickView
	 * @param event
	 */
	public void goBack(ActionEvent event) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("../view/Pick.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Handles when the logout button is pushed
	 * @param event
	 */
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
		
	/**
	 * load matches on ListView
	 * @throws IOException
	 */
	public void loadResults() throws IOException{
		userObsList = FXCollections.observableArrayList();
	}
	
	/**
	 * Handles when the names are clicked
	 * @param event
	 */
    public void handleClick(javafx.scene.input.MouseEvent event) {
    	
    }
	

}
