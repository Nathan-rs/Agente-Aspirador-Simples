package aspirador;

import java.util.Random;

public class Casa {	
	private Aspirador aspirador;
	private int[][] comodos;
	private Random aleatorio;
	private int lin;
	private int col;
	
	
	
	public Casa(int lin, int col) {
		this.comodos = new int[this.lin][this.col];
		this.lin = lin;
		this.col = col;
		this.aleatorio = new Random();
	}
	
	
	
	
	public void comodos() {
		for(int i=0; i<getLin(); i++) {
			for(int j=0; j<getCol(); j++) {
				comodos[i][j] = 1;
			}
		}
	}
	
	public int getLin() {
		return lin;
	}
	
	public void setLin(int lin) {
		this.lin = lin;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	
	private void casas(int[][] c) {
		this.comodos = c;
	}
	
	public int[][] getComodos() {
		return comodos;
	}
	
	public void setComodos(int[][] comodos) {
		this.comodos = comodos;
	}
}
