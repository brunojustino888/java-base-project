package umc.primeirosemestre;
import java.util.Scanner;

public class Entrada {

 private static Scanner s;

public static void main (String[] args) {

  s = new Scanner(System.in);
  System.out.println("Digite o seu nome");
  String nome = s.nextLine();
  System.out.println("Bem-Vindo " + nome + " !");
  
 

}

}