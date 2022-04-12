package umc.sString;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Numero {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
		double saldo = 123_456_789_99.00;
		NumberFormat f = NumberFormat.getInstance();
		System.out.println(f.format(saldo)); //gen�ricos
		System.out.println(saldo); 
	
		f = NumberFormat.getIntegerInstance(); //inteiros
		System.out.println(f.format(saldo));
		
		f = NumberFormat.getPercentInstance(); //percentual
		System.out.println(f.format(saldo));
		
		f = NumberFormat.getCurrencyInstance(); //moeda
		f.setMaximumFractionDigits(2);
		System.out.println(f.format(saldo));
		
		/*Internacionalizac�o*/
		f = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(f.format(saldo));
		f = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		System.out.println(f.format(saldo));
		f = NumberFormat.getCurrencyInstance();
		System.out.println(f.format(saldo));
		System.out.println(f.parse("R$ 1.888,12")); //converte string em double
		
		
		/*Classe MATH*/
	/*	Math.E; //dieuler
		Math.PI //numero pi
		Math.sin(10); // seno de 10
		Math.cos(8); // cosceno de 8
		Math.tan(9); //tangente
		Math.pow(4, 4); //potencia��o
		Math.sqrt(16); //raiz quadrada
		Math.cdrt(16); //raiz c�bica
		Math.hypot(12, 45); //hyotenusa 
	
	*/
	
	}

}
