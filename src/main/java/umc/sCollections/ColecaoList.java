package umc.sCollections;

import java.util.ArrayList;
import java.util.List;

public class ColecaoList {

	public static void main(String[] args) {
 
		List<String> lista = new ArrayList<>(); 						//A classeArrayList implementa os m�todos da interface List. Essa interface herda da classe Collection.
		lista.add("Futebol");											//Adicionando itens � lista...
		lista.add("Basquete");
		lista.add("T�nis");
		lista.add("Volei");
		lista.add("Nata��o");
		lista.add("Hockey");
		lista.add("Boxe");
		lista.add("Futebol");											//A classe List aceita elementos duplicados(A String "Futebol" est� tamb�m na primeira posi��o da lista.
		System.out.println(lista); 										//Mostra na tela o conte�do da lista.
		
		/*Colocando todos os elementos da lista em caixa alta...*/
		for(int i =0;i<lista.size();i++){								//Percorrendo a lista...
			String aux = lista.get(i);									//Usando uma vari�vel auxiliar para recuperar cada posi��o da lista.			
			lista.set(i, aux.toUpperCase());							//Passando para caixa alta todos os elementos da lista e adicionando-os novamente.											
		}
		
		
		System.out.println(lista);										//Mostra na tela o conte�do da lista.
		System.out.println(lista.indexOf("BOXE"));	 					//Retorna o valor em inteiro da posi��o onde est� uma determinada ocorr�ncia.
		System.out.println(lista.subList(2, 7));	 					//Mostra uma sublista criada da posi��o 2 at� a posi��o 6.
		lista.subList(2, 7).clear();						 			//Removendo a sublista...
		System.out.println(lista);										//Mostra na tela o conte�do da lista.
	}

}
