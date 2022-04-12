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

public class DividePorZero {

	
	private static Scanner s;

	public static void main(String[] args){
	
	 s = new Scanner(System.in);
	 boolean continua = true;
	 System.out.println(continua);
	 
	 do{
		 
		 try{		 
			 System.out.println("Numero: ");
			 int a = s.nextInt();
			 System.out.println("Divide por: ");
			 int b = s.nextInt();
			 
			 System.out.println("\nO resultado � :" + a/b);
			 continua = false;
			 
		 } catch(InputMismatchException erro1){
			 System.out.println("Ocorreu  o erro de InputMismatchException no Java\nOs numero tem que ser inteiro");
			 s.nextLine(); //m�todo que "descarta" o valor que deu erro no objeto Scanner e libera novamente para o usu�rio.
		 } catch(ArithmeticException erro2){
			 System.out.println("Ocorreu o erro de ArithmeticException no Java\nN�mero de divisor incorreto, verifique se o numero � maior que 0");
			 s.nextLine();
		 } finally{
			 System.err.println("O finally ser� executado com erro ou sem erro na aplica��o!");
			 //ser� um erro...   
			 //o finally sempre "limpa" as vari�veis, por tanto, n�o sair� do Loop 
		 }
		 
	  }while(continua = true);

	 //Erros:
	 //java.lang.ArithmeticException = (se b = 0)
	 //java.util.InputMismatchException = (se b for = String)
	 
	}
	
	
	
}
