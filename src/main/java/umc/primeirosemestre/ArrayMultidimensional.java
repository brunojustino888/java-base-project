package umc.primeirosemestre;
import java.util.Random;
public class ArrayMultidimensional {

public static void main(String[] args){

String[] nomes = {"Sandra","Ana Claudia"};
System.out.println(nomes.length);

String[][] matriz = { {"Sandra","Alcoolatra"} , {"Ana Claudia","Louca"} };
System.out.println(matriz[1][1] + matriz[1][0]);
System.out.println(matriz[1][0] + matriz[0][1]);

String[] cartas = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
String[] nipes = {"Espadas","Copas","Paus","Ouros"};

Random ra = new Random();
ra.nextInt(10);

String carta = cartas[0] + "" + nipes[0]; 
System.out.println(carta);
 

}
}