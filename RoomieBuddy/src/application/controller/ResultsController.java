package application.controller;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ResultsController implements Initializable, EventHandler<ActionEvent> {
	private ListView<String> results;
	
	public void start(Stage primaryStage) {
		try {
			
			loadResults("results.csv"); 
						

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		
		// TODO Auto-generated method stub
		
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
	public void loadResults(String results) throws IOException{
		
		File file = new File(results); 
		Scanner scan = new Scanner(file); 
		String input; 
		int count; 
		scan.useDelimiter("\n"); 
		while(scan.hasNext()){
			input = scan.next(); 
			String[] aa; 
			aa = input.split(","); 
			
			
			
		}
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(LoginController.enteredUser.getName().equals("anna")) {
			ObservableList<String> items = FXCollections.observableArrayList( "Tiffany Tabourne", " " );
			results.setItems( items );
			
		}
		
	}
	
	
	
	

}
