package application.controller;


import java.util.ArrayList;

import application.Main;
import application.model.user;
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
	public static Object enteredUser;
	@FXML
	private TextField userText;
	@FXML
	private TextField passText;  
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
			user enteredUser = new user(username,password);
			
			//String welcomedUser = enteredUser.welcomeUser(username);
			
		
			
				String returnedUser = user.validate(username,password);
				if(returnedUser.equals("false")) {
				}
				
				if(returnedUser.equals("true")) {
					System.out.println("YUHH");
				}
					
			//	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Personnel.fxml"));
			//	Parent root = (Parent) loader.load();
				
			//	PersonnelController secController = loader.getController();
			//	secController.stringName(welcomedUser);
			//	secController.shipNregister(shipNreg);	
			//for(int i=0;i<=7;i++) {
					//if(nameSplit[i].toLowerCase().contains(username)) {
					//	str =nameSplit[i];
					//  index = i;
				//		secController.name1(nameSplit[index]);
					//}
				//}
				/*	if ( nameSplit[3].toLowerCase().indexOf(username.toLowerCase()) != -1 ) {
						secController.name3(nameSplit[0]);
					}
					if(!nameSplit[1].toLowerCase().contains(username)) {
						secController.name2(nameSplit[1]);
					}
					if(!nameSplit[2].toLowerCase().contains(username)) {
						secController.name3(nameSplit[2]);
					}
					if(!nameSplit[3].toLowerCase().contains(username)) {
						secController.name4(nameSplit[3]);
					}
					if(!nameSplit[4].toLowerCase().contains(username)) {
						secController.name5(nameSplit[4]);
					}
					if(!nameSplit[5].toLowerCase().contains(username)) {
						secController.name6(nameSplit[5]);
					}
					if(!nameSplit[6].toLowerCase().contains(username)) {
						secController.name7(nameSplit[6]);
					}
					if(!nameSplit[7].toLowerCase().contains(username)) {
						secController.name8(nameSplit[7]);
					}
					if(nameSplit[1].toLowerCase().contains(username)) {
						secController.name2(nameSplit[0]);
					}
					if(nameSplit[2].toLowerCase().contains(username)) {
						secController.name3(nameSplit[0]);
					}
					if(nameSplit[3].toLowerCase().contains(username)) {
						secController.name4(nameSplit[0]);
					}
					if(nameSplit[4].toLowerCase().contains(username)) {
						secController.name5(nameSplit[0]);
					}
					if(nameSplit[5].toLowerCase().contains(username)) {
						secController.name6(nameSplit[0]);
					}
					if(nameSplit[6].toLowerCase().contains(username)) {
						secController.name7(nameSplit[0]);
					}
					if(nameSplit[7].toLowerCase().contains(username)) {
						secController.name8(nameSplit[7]);
					}
				Main.stage.setScene(new Scene(root, 800, 800));
				Main.stage.show();
				}
				}
		*/}catch(Exception e) {
			//	e.printStackTrace();
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
}
