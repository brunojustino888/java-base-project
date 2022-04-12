package umc.ramdon;

import java.util.Random;

/**
 * 	Essa � uma classe utilizada para tomar decis�es. 
 *	Baseadas na resposta obtida da Classe Random, uma decis�o pode ser 0 ou 1.
 */
public class Randoms {
	
	public static void main(String[] args) {

			Random s = new Random();
			System.out.println(s.nextInt(2));
		
	}

}
