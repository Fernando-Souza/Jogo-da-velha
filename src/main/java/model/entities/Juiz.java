package model.entities;

public class Juiz {

	private Integer[][] tabuleiro = new Integer[3][3];

	public Juiz() {

		zeraTabuleiro();
	}

	public Integer[][] getTabuleiro() {

		return tabuleiro;
	}

	public void zeraTabuleiro() {

		for (int i = 0; i < tabuleiro.length; i++) {

			for (int j = 0; j < tabuleiro.length; j++) {

				tabuleiro[i][j] = 0;

			}

		}

	}

	public void setPosicao(int linha, int coluna, Jogador jogador) {

		tabuleiro[linha][coluna] = jogador.getSimbol();
		

	}

	private int checaLinha() {

		if (tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2] == 3) {
			return 1;
		}
		if (tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2] == -3) {
			return -1;
		}
		if (tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2] == 3) {
			return 1;
		}
		if (tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2] == -3) {
			return -1;
		}
		if (tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2] == 3) {
			return 1;
		}
		if (tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2] == -3) {
			return -1;
		} else {
			return 0;
		}

	}

	private int checaColuna() {

		if (tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0] == 3) {
			return 1;
		}
		if (tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1] == 3) {
			return -1;
		}
		if (tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2] == 3) {
			return 1;
		}
		if (tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0] == -3) {
			return -1;
		}
		if (tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1] == -3) {
			return 1;
		}
		if (tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2] == -3) {
			return -1;
		} else {
			return 0;
		}

	}

	private int checaDiagonal() {

		if (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2] == 3) {
			return 1;
		}
		if (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2] == -3) {
			return -1;
		}
		if (tabuleiro[2][0] + tabuleiro[1][1] + tabuleiro[0][2] == 3) {
			
			return 1;
		}
		if (tabuleiro[2][0] + tabuleiro[1][1] + tabuleiro[0][2] == -3) {
			
			return -1;
			
		} else {
			return 0;
		}

	}

	public int resultado() {

		if (checaLinha() == 1 || checaColuna() == 1 || checaDiagonal() == 1) {

			return 1;

		}

		if (checaLinha() == -1 || checaColuna() == -1 || checaDiagonal() == -1) {

			return -1;
			
		} else {

			return 0;
			
		}

	}

}
