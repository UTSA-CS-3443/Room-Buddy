package application.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

/**
 * Controller for the Pick.fxml view
 * @author Luis Valdes
 *
 */
public class PickViewController implements EventHandler<ActionEvent>  {
	@Override
	/**
	 * Handles when the edit profile button is clicked
	 */
	public void handle(ActionEvent event) {
		int hi=0;
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/Profile.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
	/**
	 * Handle when the results button is clicked
	 * @param event
	 * @throws IOException
	 */
	public void results(ActionEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/Results.fxml"));
		Parent root = (Parent) loader.load();
				
		ArrayList<User> list = LoginController.userNetwork.getMatches(LoginController.enteredUser);
		HashMap<String, String> matches= LoginController.userNetwork.getMapDifferences(LoginController.enteredUser, list);
		ResultsController resultsController = loader.getController();
		resultsController.loadResults(matches);

		Main.stage.setScene(new Scene(root, 800, 800));
		Main.stage.show();	
		
	}
	/**
	 * Handles when the logout button is clicked
	 * @param event
	 * @throws IOException
	 */
	public void logout(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		Parent root;
		root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
		Main.stage.setScene(new Scene(root, 800, 800));
		Main.stage.show();	
		
	}

}
