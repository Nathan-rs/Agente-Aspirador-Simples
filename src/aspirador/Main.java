package aspirador;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

public class Main {
	public static int lin = 0;
	public static int col = 0;
	public static String[][] comodos = null;
	public static Random aleatorio = new Random();
	public static Scanner input = new Scanner(System.in);
	public static Aspirador aspirador = new Aspirador();
	
	public static void menu() {
		int op = 0;
		
		do {
			
			System.out.println("\n|---------------------------------|");
			System.out.println("|1 - Informar os comodos da casa  |");
			System.out.println("|2 - Monitorar o aspirador        |");
			System.out.println("|3 - sair                         |");
			System.out.println("|---------------------------------|");
			System.out.print("> ");
			op = input.nextInt();
			
			
			switch(op) {
				case 1:
					System.out.print("> Informe a largura da casa: ");
					lin = input.nextInt();
					System.out.print("> Informe a altura da casa: ");
					col = input.nextInt();
					System.out.print("> Informe a porcentagem(%) de comodos sujos da casa: ");
					float por = input.nextFloat();
					
					comodos = new String[lin][col];
					
					aspirador.setRobo(">A<");
					aspirador.gerarComodos(comodos, lin, col, por);
					break;
					
				case 2:
					aspirador.monitoramento(comodos, lin, col);
					break;
					
				case 3:
					System.exit(0);
					break;
				
				default: System.out.println("Opção Invalida!");break;
			}
		}while(op != 3);
	}
	
	public static String[][] initAspirador() {
		
		System.out.println("> Informe as dimensoes de sua casa L x A: ");
		
		System.out.print("> Largura: ");
		lin = input.nextInt();
		System.out.print("\n> Altura: ");
		col = input.nextInt();
		
		System.out.print("\n> Informe a porcentagem (%) de comodos sujos: ");
		int por = input.nextInt();
		
		return new String[lin][col];
	}
	
	public static void main(String[] args) {
//		Casa casa = new Casa(4,4);
		
		menu();
		
	}
}
