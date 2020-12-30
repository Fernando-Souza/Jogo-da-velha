package model.entities;

public class Jogador {

	private String nome;
	private String sbl;
	private int simbol;

	public Jogador(String nome, String sbl) {

		this.nome = nome;
		this.sbl = sbl;
		
		if (sbl.equals("O")) {
			this.simbol = 1;
		} else if (sbl.equals("X")) {

			this.simbol = -1;
		}

	}

	public String getNome() {
		return nome;
	}

	public int getSimbol() {
		return simbol;
	}
	
	public String getSbl() {
		return sbl;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSimbol(int simbol) {
		this.simbol = simbol;
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", sbl=" + sbl + "]";
	}

	
	
	
	
	

}
