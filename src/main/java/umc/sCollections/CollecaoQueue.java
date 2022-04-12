package umc.sCollections;

import java.util.LinkedList;
import java.util.Queue;

public class CollecaoQueue {

	//A interface Queue extende de Collections e representam filas de espera.
	//Existe duas outras classes que implementam a Interface Queue; "PriorityQueue" e "LinkedList".
	
	public static void main(String[] args) {

		//O m�todo add da classe Queue adiciona os elementos no final da fila, ou seja, na �ltima posi��o (FIFO).
		//O m�todo de remover offer remove o primeriro
		Queue<String> queue = new LinkedList<String>();
		queue.add("John");
		queue.add("Daniela");
		queue.add("Vinicius");
		queue.add("Miguel");
		queue.peek(); //Retorna o primeiro da fila.
		queue.poll(); //Remove o primeiro elemento da fila.
		LinkedList<String> fila= (LinkedList<String>)queue;//Cast para trnasformara a queue em LinkedList.
		fila.addFirst("Adiciona no final da Fila.");
		fila.addLast("Adiciona no final da Fila");
		fila.peekFirst();//Retorna o primeiro da LIsta.
		fila.peekLast();//Retona o �ltimo da fila.
		fila.pollLast();//Apaga o �ltimo da fila.
		
	}

}
