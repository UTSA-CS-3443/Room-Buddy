package application.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.scene.control.Label;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import application.Main;
import application.model.User;
import application.model.UserNetwork;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class SignUpController implements Initializable, EventHandler<ActionEvent>{
	@FXML
    private TextField passField;
    @FXML
    private TextField userField;
    @FXML
    private TextField confirmPassField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private Label passNotMatch;
    @FXML 
    private Label emailInUse;
    @FXML 
    private Label userInUse;
    

    
    public static User currUser;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	@Override
	public void handle(ActionEvent arg0) {
		
		try {
			if(passField.getText().equals(confirmPassField.getText())) {
				passNotMatch.setText("");
				userInUse.setText("");
				emailInUse.setText("");
				// Make sure username or email are not in use already.
				// open the file for reading
				Scanner scan = new Scanner ( new File("data/loginUPDATED.csv") );
				int errors = 0;
				// read in, line by line, creating HashMap
				while( scan.hasNextLine() ) {
					String line = scan.nextLine();
					String[] tokens = line.split(",");
					if(tokens[1].equals(userField.getText())){
						userInUse.setText("Username taken.");
						errors++;
					}
					
					if(tokens[3].equals(emailField.getText())){
						emailInUse.setText("Email already in use.");
						errors++;
					}
				}
				
				// close the file!
				scan.close();
				System.out.println(errors);
				if(errors == 0) {
					//FileWriter writer = new FileWriter("data/loginUPDATED.csv",true);
					//String str = "\n" + nameField.getText() + "," + userField.getText() + "," + passField.getText() + "," + emailField.getText() + "," + phoneField.getText() ;
					
                     User s = new User( nameField.getText(),userField.getText(),passField.getText(), phoneField.getText(), emailField.getText());
				     LoginController.userNetwork.getUsers().add(s); 
				     LoginController.userNetwork.save();
				     
				    //writer.write(str);
				    //writer.close();
				    
				    // Return to Login page.
					Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
					Main.stage.setScene(new Scene(root, 800, 800));
					Main.stage.show();
				}
				
			} else {
				passNotMatch.setText("Passwords do not match. Please try again.");
			}
		} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void goBack(ActionEvent event){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
