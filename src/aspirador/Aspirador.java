package aspirador;

import java.util.Random;

public class Aspirador {
	private int pos_x;
	private int pos_y;
	private String robo;
	private Random position;
	
	
	public Aspirador(String robo) {
		this.robo = robo;
		this.position = new Random();
	}
	
	public Aspirador(){
		this.position = new Random();
	}
	
	
	public void gerarComodos(String comodos[][], int lin, int col, float por) {
		
		//calculo para saber a qtd de comodos sujos devem estar na matriz
		int cs = (int) ((lin*col)*(por/100));
		int cont = 0;
		int l,c;
		
		
		for(int i=0; i<lin; i++) {
			for(int j=0; j<col; j++) {
				comodos[i][j] = "|L|";
			}
		}
		
		//preenche a matriz com comodos sujos
		while(cs > 0) {
			l= position.nextInt(lin);
			c= position.nextInt(col);
			
			if(comodos[l][c] == "|L|") {
				comodos[l][c] = "|S|";
				cs--;
			}
		}
		
		positionAspirador(lin, col);
		comodos[getPos_x()][getPos_y()] = this.robo;
	}
	
	public void aspirar(String[][] comodos, int lin, int col) {
		int esq=-1,dir=-1,cima=-1,baixo=-1;
		int aux;
		boolean movimento = true;
		while(movimento) {

	//		//verificar sujeira a esquerda
			if(this.pos_y != 0 && comodos[getPos_x()][getPos_y() -1] == "|S|") {
				comodos[getPos_x()][getPos_y()] = "|L|";
				setPos_y(getPos_y() - 1);
				comodos[getPos_x()][getPos_y()] = this.robo;
				monitoramento(comodos, lin, col);	
				}
				
			//movimento a direita
				if(this.pos_y != (col - 1)) {
					if((comodos[getPos_x()][getPos_y() + 1] == "|S|")) {
					comodos[getPos_x()][getPos_y()] = "|L|";
					setPos_y(getPos_y() + 1);
					comodos[getPos_x()][getPos_y()] = this.robo;
					monitoramento(comodos, lin, col);
					}
				}
				
				//movimento para cima
				if(this.pos_x != 0 && comodos[getPos_x() - 1][getPos_y()] == "|S|") {
				comodos[getPos_x()][getPos_y()] = "|L|";
				setPos_x(getPos_x() - 1);
				comodos[getPos_x()][getPos_y()] = this.robo;
				monitoramento(comodos, lin, col);
				}
				
				//movimento para baixo
				if(this.pos_x != (lin - 1)) {
					if(comodos[getPos_x() + 1][getPos_y()] == "|S|") {
						comodos[getPos_x()][getPos_y()] = "|L|";
						setPos_x(getPos_x() + 1);
						comodos[getPos_x()][getPos_y()] = this.robo;
						monitoramento(comodos, lin, col);
					}
				}
			movimento = verificaPosicao(comodos, lin, col);
		}
	}
	
	public boolean verificaPosicao(String[][] comodos, int lin, int col) {
		if(this.pos_x != 0 && comodos[getPos_x() - 1][getPos_y()] == "|S|" 
				|| this.pos_x != (lin-1) && comodos[getPos_x() + 1][getPos_y()] == "|S|" 
				|| this.pos_y != 0 && comodos[getPos_x()][getPos_y() - 1] == "|S|" 
				|| this.pos_y != (col-1) && comodos[getPos_x()][getPos_y() + 1] == "|S|") {
			return true;
		}
		return false;
	}
	
	public void monitoramento(String[][] comodos, int lin, int col) {
		System.out.println();
		
		if(lin == 0 && col == 0) {
			System.out.println("Sem comodos na casa!\n");
			return;
		}
		
		for(int i=0; i<lin; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(comodos[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void positionAspirador(int lin, int col) {
		setPos_x(this.position.nextInt(lin));
		setPos_y(this.position.nextInt(col));
	}
	
	
	public String getRobo() {
		return robo;
	}
	
	public void setRobo(String robo) {
		this.robo = robo;
	}
	
	public int getPos_x() {
		return pos_x;
	}
	
	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}
	
	public int getPos_y() {
		return pos_y;
	}
	
	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}
	
	public Random getPosition() {
		return position;
	}
	
	public void setPosition(Random position) {
		this.position = position;
	}
	
}
