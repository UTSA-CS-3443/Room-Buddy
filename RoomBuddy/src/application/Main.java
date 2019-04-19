package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 * @author Luis Valdes and Anna Arroyo (qbw322)
 * UTSA CS 3443 - Lab 5
 * Spring 2019
 * the Main class loads the stage and sets it to 800x800 resolution, it then runs through MainController
 */
public class Main extends Application {
	public static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
			primaryStage.setScene(new Scene(root, 800, 800));
			primaryStage.show();
			
			stage = primaryStage;

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
		
}