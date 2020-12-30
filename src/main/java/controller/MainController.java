package controller;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.entities.Jogador;
import model.entities.Juiz;

public class MainController {

	@FXML
	private Label playerName1;
	@FXML
	private Label playerName2;
	@FXML
	private Label symbolPlayer1;
	@FXML
	private Label symbolPlayer2;
	@FXML
	private Label jogadorVez;
	@FXML
	private Label vezLab;
	@FXML
	private GridPane tabuleiro;
	@FXML
	private Button newGame;
	@FXML
	private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	@FXML
	private Label vezPlayer;

	@FXML
	private PlayerController playerController;

	private Juiz juiz = new Juiz();

	@FXML
	private Jogador player1;
	@FXML
	private Jogador player2;

	private int vez = (int) Math.round(Math.random());
	private int resultado;

	public Label getPlayerName1() {

		return playerName1;
	}

	public void setPlayers(Jogador player1, Jogador player2) {

		this.player1 = player1;
		this.player2 = player2;
		this.symbolPlayer1.setText(player1.getSbl());
		this.symbolPlayer2.setText(player2.getSbl());
		this.playerName1.setText(player1.getNome());
		this.playerName2.setText(player2.getNome());

	}

	@FXML
	public void handlerButtonPartida(ActionEvent event) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/PlayersView.fxml"));
			AnchorPane root = loader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			playerController = loader.getController();
			playerController.init(this);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void handlerButtonTabuleiro(ActionEvent ac) {

		Button btn = (Button) ac.getSource();
		controlaVez();

		Integer linha = getRowIndex(tabuleiro, btn);
		Integer coluna = getColIndex(tabuleiro, btn);
		
				
		if (vez == 1) {

			btn.setText(player1.getSbl());
			juiz.setPosicao(linha, coluna, player1);
			resultado = juiz.resultado();
			btn.setDisable(true);;

		} else if (vez == 0) {

			btn.setText(player2.getSbl());
			juiz.setPosicao(linha, coluna, player2);
			resultado = juiz.resultado();
			btn.setDisable(true);;


		}

		if (resultado == -1) {

			vezLab.setText("Vencedor:");
			vezPlayer.setText(player1.getNome());
			inativaBtns(tabuleiro);

		}

		if (resultado == 1) {

			vezLab.setText("Vencedor:");
			vezPlayer.setText(player2.getNome());
			inativaBtns(tabuleiro);

		}

	}

	public void initTabuleiro() {

		juiz.zeraTabuleiro();
		zeraTabuleiro(tabuleiro);

	}

	public void setVezPlayer() {

		vez = ((int) (Math.random() * 2));
		controlaVez();
		System.out.println("vez" + vez);
	}

	private void controlaVez() {

		if (vez == 0) {

			vezPlayer.setText(player2.getNome());
			vez += 1;

		} else if (vez == 1) {

			vezPlayer.setText(player1.getNome());
			vez -= 1;

		}

	}

	private void zeraTabuleiro(GridPane tabuleiro) {

		ObservableList<Node> nodesList = tabuleiro.getChildren();

		for (Node bt : nodesList) {

			if (bt instanceof Button) {

				Button butn = (Button) bt;

				butn.setText("");
				butn.setDisable(false);

			}

		}

	}

	public Integer getRowIndex(GridPane gp, Node btn) {

		Integer linha = 0;

		ObservableList<Node> nodes = gp.getChildren();

		for (Node x : nodes) {

			if (x.getId().equals(btn.getId())) {

				linha = GridPane.getRowIndex(x);

			}

		}

		if (linha == null) {

			linha = 0;

		}

		return linha;
	}

	public Integer getColIndex(GridPane gp, Node btn) {

		Integer col = 0;

		ObservableList<Node> nodes = gp.getChildren();

		for (Node x : nodes) {

			if (x.getId().equals(btn.getId())) {

				col = GridPane.getColumnIndex(x);

			}

		}

		if (col == null) {

			col = 0;

		}

		return col;
	}
	
	private void inativaBtns(GridPane nd) {
		
		ObservableList<Node>buttons = nd.getChildren();
		
		for(Node btn:buttons) {
			
			if(!btn.isDisabled()) {
				
				btn.setDisable(true);
				
			}
			
		}
		
		
		
	}

	@FXML
	public void initialize() {

	}

}