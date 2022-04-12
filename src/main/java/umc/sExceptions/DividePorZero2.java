/*
 * Esse pacote foi constru�do com a inten��o de exmplificar o tratamento de excess�es em JAVA
 */
package umc.sExceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Bruno Alves Justino.
 * Date: 16/11/2012.
 */

public class DividePorZero2 {


	 public static void dividir(Scanner s) throws ArithmeticException , InputMismatchException {
		 System.out.println("Numero: ");
		 int a = s.nextInt();
		 System.out.println("Divide por: ");
		 int b = s.nextInt();
		 
		 System.out.println("\nO resultado � :" + a/b);
		
	 }
	
	public static void main(String[] args){
	
	 Scanner s = new Scanner(System.in);
	 boolean continua = true;
	 
	 
	 do{
		 
		 try{		 
			 dividir(s);
			 continua = false;
		
			 
		 } catch(InputMismatchException | ArithmeticException erro1){
			 erro1.getStackTrace(); //m�todo usado para capturar o erro para posteriormente tratar o erro em uma condi��o IF por exemplo
			 System.out.println("Ocorreu  o erro de InputMismatchException ou  o de ArithmeticException no Java\nOs numero tem que ser inteiro");
			 s.nextLine(); //m�todo que "descarta" o valor que deu erro no objeto Scanner e libera novamente para o usu�rio.
		
		 } finally{
			 System.err.println("O finally ser� executado com erro ou sem erro na aplica��o!");
			 //ser� um erro...   
		  }
		 
	  }while(continua == true);

	 //Erros:
	 //java.lang.ArithmeticException = (se b = 0)
	 //java.util.InputMismatchException = (se b for = String)
	 
	}
	
	
	
}