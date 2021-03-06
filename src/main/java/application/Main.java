package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
			
		@Override
		public void start(Stage stage) {
			try {
				Parent parent = FXMLLoader.load(getClass().getResource("/gui/MainView.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.setTitle("Jogo da Velha");
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
			Application.launch(args);
		}		
		
}
