package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entities.Jogador;
import model.entities.Juiz;

public class PlayerController implements Initializable {

	@FXML
	private TextField namePlayer1;
	@FXML
	private TextField namePlayer2;
	@FXML
	private Button bnIniciar;
	
	private MainController mainControler;
	
	private Jogador player1;
	private Jogador player2;
	
	private Juiz juiz;

	

	@FXML
	public void handlerStartPlayButton(ActionEvent event) {

		setPlayers();
		mainControler.setPlayers(player1, player2);
		mainControler.setVezPlayer();
		mainControler.initTabuleiro();
		closeView();

	}

	public void closeView() {

		Stage playerScene = (Stage) bnIniciar.getScene().getWindow();
		playerScene.close();
	}

	public TextField getNamePlayer1() {

		return namePlayer1;
	}

	public TextField getNamePlayer2() {
		return namePlayer2;
	}

	public Button getBnIniciar() {
		return bnIniciar;
	}

		
	public Jogador getPlayer1() {

		return player1; 
	}

	public Jogador getPlayer2() {

		return player2;
	}
	
	public void setPlayers() {
		
		player1 = new Jogador(namePlayer1.getText(),"X");
		player2 = new Jogador(namePlayer2.getText(),"O");
		
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		

	}

	public void init(MainController mainController) {

		this.mainControler = mainController;

	}
	
	
	

}
