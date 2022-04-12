package umc.primeirosemestre;
import java.util.ArrayList;
import java.util.Scanner;

public class EnquantoArray {

private static Scanner s;

public static void main (String[] args) {

ArrayList<String> produtos = new ArrayList<String>();
System.out.println("Digite uma lista de produtos e a palavra fim para sair.");
s = new Scanner(System.in);

String produto;
				//.equals = serve para comparar strings
				//s.nextline = chama o scanner na proxima linha
while(!"Fim".equals(produto= s.nextLine() )) {
produtos.add(produto);   //.add = adiciona no array o parametro digitado
}

System.out.println(produtos.toString()/* m�todo que descreve o conte�do do array */);

}

}