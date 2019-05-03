package application.controller;


import java.util.ArrayList;

import application.Main;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author Luis Valdes (qbw322)
 * UTSA CS 3443 - Lab 5
 * Spring 2019
 * Login controller handles the login credentials
 */
public class LoginController implements EventHandler<ActionEvent> {
	public static final String foo = null;
	public static User enteredUser;
	@FXML
	private TextField userText;
	@FXML
	private TextField passText;  
	@FXML
	private Text errorMsg;
	@Override
	/**
	 * get the user's username and password, then pass that into the validate method inside User.java 
	 * and check if it exists. Next read in the crew members that belong to same ship register as the user
	 * and pass them in to the ship through the second controller's texts and then load the Personnel.fxml
	 */
	public void handle( ActionEvent event) {

		try {
			String username = userText.getText();
			String password = passText.getText();
			enteredUser = new User(username,password);
			
			//String welcomedUser = enteredUser.welcomeUser(username);
			
		
			
				String returnedUser = User.validate(username,password);
				if(returnedUser.equals("false")) {
					errorMsg.setText("Invalid username or password, please enter valid credentials");
				}
				
				if(returnedUser.equals("true")) {
					try {
						Parent root;
						root = FXMLLoader.load(getClass().getResource("../view/Search.fxml"));
						Main.stage.setScene(new Scene(root, 800, 800));
						Main.stage.show();	
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				
					    
			
		}catch(Exception e) {
			errorMsg.setText("Invalid user or password, please enter valid credentials");
		}		
	}
	public void signup(ActionEvent event){
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("../view/SignUp.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void clearText( ) {
		errorMsg.setText("");
	}

}
