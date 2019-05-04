package application.controller;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.Main;
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

public class ResultsController implements Initializable, EventHandler<ActionEvent> {
	
	@FXML
	private ListView<String> results;
	
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
	 * Handles when the goback button is pushed. This either takes them to the Pick screen
	 * if the user has signed in (signin flag is set) or it takes them to the login screen
	 * if they have not signed in yet
	 * @param event
	 */
	public void goBack(ActionEvent event) {
		try {
			Parent root;
			if(LoginController.enteredUser.isSignInFlag()) {
				root = FXMLLoader.load(getClass().getResource("../view/Pick.fxml"));
			}
			else {
				root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			}
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
		
	/**
	 * load matches on ListView
	 * @throws IOException
	 */
	public void loadResults() throws IOException{
			
		}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	class ListViewHandler implements EventHandler<MouseEvent> {
	    @Override
	    public void handle(MouseEvent event) {
	        //this method will be overrided in next step
	    }
	 }
	
	
    public void handleClick(javafx.scene.input.MouseEvent event) {
    	
    }
	
	public void getUser(String name){
		
		return; 
	}

}
