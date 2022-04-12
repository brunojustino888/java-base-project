package umc.sCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Colecao {

	public static void main(String[] args) {

		//Collection n�o pode ser instanciada, mais pode usar a classe ArraList como uma interface para ser instanciada. 
		Collection<String> c = new ArrayList<>(); 				//ArrayList � uma classe que implementa os m�todos da interface List, que por sua vez, herda da classe Collection. 
		c.add("Elemento 1");									//M�todo para adicionar objetos ao ArrayList.
		c.add("Elemento 2");									//M�todo para adicionar objetos ao ArrayList.
		c.add("Elemento 3");									//M�todo para adicionar objetos ao ArrayList.
		
		System.out.println(c.toString());						//Mostra o retorno do m�todo em string do conte�do do ArrayList.
		System.out.println(c.isEmpty());						//Mostra o retorno de um valor true or false para representar se o ArrayList est� preenchido ou n�o.
		System.out.println(c.contains("Elemento 1")); 			//Pesquisa a ocorr�ncia de um objetono ArrayList retornando uma valor true ou false. Esse valor � mostrado na tela.
		c.remove("Elemento 1");									//Remove um determinado elemento do ArrayList.
		
		Collection<String> c2 = Arrays.asList("Elemento 4", "Elemento 5");	//Arrays � uma classe para manipula��o de Arrays. O m�todo asList() retorna um ArrayList com os valores passados como par�metros. 
		c.addAll(c2); 											//Incluindo a segunda cole��o dentro da primeira.
		System.out.println(c.toString());						//Mostra o retorno do m�todo em string do conte�do do ArrayList.
		System.out.println(c.containsAll(c2));	 				//Verifica se a primeira cole��o cont�m todos os elementos da segunda cole��o.
		c.removeAll(c2);										//Remove da primeira cole��o todos os elementos da segunda. 
		
		/*Percorrendo os elementos da cole��o...*/
		for(String valor : c){
			System.out.println(valor);							//Mostrando o elemento atual da cole��o.
		}
		
		Object[] arrayDeObjeto  = c.toArray(); 		 			//O m�todo toArray sem par�metro retorna um array de objetos.
		System.out.println(arrayDeObjeto.length);				//Mostra na tela a quantidade de Objetos recebidos pelo m�todo toArray().
		String[] array2 = c.toArray(new String[c.size()]);   	//O m�todo toArray recebe como par�meto o tipo do array que voc� deseja o retorno.
		System.out.println(Arrays.toString(array2));			//Atrav�s da Classe Arrays (que manipula arrays) podemos mostrar em String o conte�do do array.
		
	}

}
