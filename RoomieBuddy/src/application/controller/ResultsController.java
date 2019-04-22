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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ResultsController implements Initializable, EventHandler<ActionEvent> {
	
	@FXML
	private ListView<String> results;
	
	@FXML 
	private TextArea roommateInfo;
	
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
	
	class ListViewHandler implements EventHandler<MouseEvent> {
	    @Override
	    public void handle(MouseEvent event) {
	        //this method will be overrided in next step
	    }
	 }
	
    public void handleClick(javafx.scene.input.MouseEvent event) {
        //System.out.println(results.getSelectionModel().getSelectedIndex());
        //roommateInfo.textProperty().unbindBidirectional(results.selectionModelProperty());
        roommateInfo.setText("Tiffany Tabourne - Phone Number: 111-222-3333 - Email: tiffanytabour@gmail.com\n"
        		+ "Differences: \n" + "Hobbies: Sports, Gaming\n" + "Cleanliness: Moderately Clean");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(LoginController.enteredUser.getName().equals("anna")) {
			ArrayList<String> resultsArray = new ArrayList<String>();
			resultsArray.add("Tiffany Tabourne");
			ObservableList<String> items = FXCollections.observableArrayList(resultsArray);
			results.setItems( items );
	
			
		}
		
		if(LoginController.enteredUser.getName().equals("tiffany")) {
			ArrayList<String> resultsArray = new ArrayList<String>();
			resultsArray.add("Anna Arroyo");
			ObservableList<String> items = FXCollections.observableArrayList(resultsArray);
			results.setItems( items );
		}
		
	}

}
