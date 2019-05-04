package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.Main;
import application.model.User;
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
import javafx.scene.text.Text;

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


	@FXML
	private Text error;

	User entUser; 

	String data[] = new String[14];
	@Override
	public void handle(ActionEvent event) {
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
		if(yesParty.isSelected())
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
			data[10] = "m";
		else if(female.isSelected())
			data[10] = "f";
		data[11] = university.getText();
		data[12] = apartment.getText();
		data[13] = bio.getText();


		if( classification.getText().equals("") || major.getText().equals("") ||
				(veryClean.isSelected()==false && modClean.isSelected()==false &&
				notClean.isSelected()==false ) || (music.isSelected()==false &&
				film.isSelected()==false && gaming.isSelected()==false &&
				sports.isSelected()==false && hiking.isSelected() == false &&
				sports.isSelected()==false && hiking.isSelected()==false &&
				reading.isSelected()==false) || (male.isSelected()==false &&
				female.isSelected()==false) || university.getText().equals("") ||
				apartment.getText().equals("") || bio.getText().equals("") ) 
		{
			error.setText("Please fill in all fields!"); 
		}
		else {


			//System.out.println("CHECK");


			if(LoginController.userNetwork.getExistingUser(LoginController.enteredUser.getUsername(), LoginController.enteredUser.getPassword()) == -1){						

				LoginController.userNetwork.getUsers().add(LoginController.enteredUser);
			}


			LoginController.userNetwork.updateExistingUser(LoginController.userNetwork.getExistingUser(LoginController.enteredUser.getUsername(), LoginController.enteredUser.getPassword()),data);



			try {

				LoginController.userNetwork.save();
				Parent root;
				if(LoginController.enteredUser.isSignInFlag())
					root = FXMLLoader.load(getClass().getResource("../view/pick.fxml"));
				else{
					root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
				}
				Main.stage.setScene(new Scene(root, 800, 800));
				Main.stage.show();	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
		try {
			autoPopulate();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void autoPopulate() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("data/userInfo.csv"));
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String tokens[] = line.split(",");
			if(tokens[0].equals(LoginController.enteredUser.getName())) {
				classification.setText(tokens[1]);
				major.setText(tokens[2]);
				if(tokens[3].equals("veryClean"))
					veryClean.setSelected(true);
				else if(tokens[3].equals("modClean"))
					modClean.setSelected(true);
				else if(tokens[3].equals("notClean"))
					notClean.setSelected(true);

				//default set to false by default
				noParty.setSelected(true);
				female.setSelected(true);
				if(tokens[4].equals("yesParty"))
					yesParty.setSelected(true);
				if(tokens[5].equals("true"))
					music.setSelected(true);
				if(tokens[6].equals("true"))
					film.setSelected(true);
				if(tokens[7].equals("true"))
					gaming.setSelected(true);
				if(tokens[8].equals("true"))
					sports.setSelected(true);
				if(tokens[9].equals("true"))
					hiking.setSelected(true);
				if(tokens[10].equals("true"))
					reading.setSelected(true);
				if(tokens[11].equals("m"))
					male.setSelected(true);
				university.setText(tokens[12]);
				apartment.setText(tokens[13]);
				bio.setText(tokens[14]);
				break;
			}
		}
	}

}
