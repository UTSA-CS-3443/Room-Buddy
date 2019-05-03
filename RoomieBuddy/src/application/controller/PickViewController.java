package application.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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

public class PickViewController implements EventHandler<ActionEvent>  {
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		int hi=0;
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Profile.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
	public void results(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		Parent root;
		root = FXMLLoader.load(getClass().getResource("../view/Results.fxml"));
		LoginController.userNetwork.getMatches(SignUpController.currUser);
		Main.stage.setScene(new Scene(root, 800, 800));
		Main.stage.show();	
		
	}
	public void logout(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		Parent root;
		root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
		Main.stage.setScene(new Scene(root, 800, 800));
		Main.stage.show();	
		
	}

}
