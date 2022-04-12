package umc.sCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Essa Classe foi desenvolvida somente para exemplificar as Fun��es e M�todos da Classe Collections.
public class ColecaoUtilitarios {

	public static void main(String args[]){
		
		//A classe List pode ser "colocada" dentro de um ArrayList. 
		List<String> lista = new ArrayList<>(); 
		lista.add("Guarana");
		lista.add("Uva");
		lista.add("Manga");
		lista.add("Mel�o");
		System.out.println(lista);
		
		//Collections � uma classe utilizada para a manipula��o de Cole��es listas e Arrays do java.
		Collections.sort(lista); //Ordena em ordem Alfa�tica uma lista.
		Collections.reverse(lista); //Reverte a ordem da lista.
		Collections.shuffle(lista); //Embaralha o conteudo da lista.
		Collections.addAll(lista, "Outro Elemento","Laranja"); //Adiciona na lista existente os seguintes elementos..
		Collections.frequency(lista, "Laranja"); //procura na lista a ocorr�ncia de um determinado elemento. 
		Collections.disjoint(lista, lista);      //procura na lista a ocorr�ncia de v�rios elementos. 
		Collections.binarySearch(lista, "Guarana");  //Retorna a posi��o em inteiro da ocorr�ncia de um determinado elemento.
		Collections.fill(lista, "Lim�o"); //Coloca Lim�o em todas as posi��es da Lista.
		Collections.unmodifiableCollection(lista); //Transforma a Lista em uma cole��o 
	
	}
	
	
}
