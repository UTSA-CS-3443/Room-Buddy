package application.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import java.io.FileWriter;
import java.io.IOException;

import application.Main;
import application.controller.LoginController;

import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

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
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handle(ActionEvent arg0) {
		try {
//			System.out.println(passField.getText());
//			System.out.println(userField.getText());
//			System.out.println(confirmPassField.getText());
//			System.out.println(nameField.getText());
//			System.out.println(emailField.getText());
//			System.out.println(phoneField.getText());
			if(passField.getText().equals(confirmPassField.getText())) {
				FileWriter writer = new FileWriter("data/loginUpdated.csv",true);
				String str = "\n" + nameField.getText() + "," + userField.getText() + "," + passField.getText() + "," + emailField.getText() + "," + phoneField.getText() ; 
			      
			      writer.write(str);
			      writer.close();
				
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
