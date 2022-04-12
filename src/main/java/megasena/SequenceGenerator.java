package megasena;

import java.util.Random;

public class SequenceGenerator {

	public static void main(String[] args) {

		Random random = new Random();
		String sequencia = new String();
		String numeroNovo = Integer.toString(random.nextInt(61));
		
		
		for(int i =0; i<6;i++){
				numeroNovo = Integer.toString(random.nextInt(61));
			while(numeroNovo.equals("0")){
				numeroNovo = Integer.toString(random.nextInt(61));
			}
			
			if(i==random.nextInt(7)){
				numeroNovo = Integer.toString(random.nextInt(61));
				while(numeroNovo.equals("0")){
					numeroNovo = Integer.toString(random.nextInt(61));
				}
			}
			
			sequencia += numeroNovo+"-";
			
		}

		sequencia = sequencia.substring(0,sequencia.length()-1);
		System.out.println(sequencia);
		
		ReaderTXT leitor = new ReaderTXT();
		boolean isSaiu = leitor.isResultadoJaSaiu(sequencia);
		System.out.println(isSaiu);
		
		
	}


}
