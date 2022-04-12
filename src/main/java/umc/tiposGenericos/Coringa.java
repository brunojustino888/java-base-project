package umc.tiposGenericos;

import java.util.ArrayList;


/*Essa classe possui ao lado do seu nome a reprenta��o de que ela � uma classe do tipo generica. 
O "<E>" � uma abrevia��o de element. Dessa forma, quando houver a necessidade de instanciar essa classe, � precido declarar o seu elemento. 
Por exemplo:  ClasseGenerica<String> gc = new ClasseGenerica<>()
 */


public class Coringa <E>{
	
	//O tipo "E" ser� definido pela JVM em tempo de excecu��o
	E elemento;
	
	public void setElemento(E elemento){
		this.elemento = elemento;
	}
	
	public E getElemento(){
		return this.elemento;
	}
	
	
	/*
	 * O "coringa" permite especificar par�metros que atuam como um supertipos ou subtipos par�metrizados. Ele � representado com "?"
	 * No m�todo abaixo, poderiamos precisar fazer uma soma de elementos de dentro de um ArrayList. Temos a possibilidade do array ser inteiro, float ou double...
	 * Para somar isso precisamos ent�o do "?"
	 * Os par�metros s�o subtipos da classe Number no m�todo abaixo, ou seja, float, int ,etc.
	 * A linha abaixo � um PAR�METRO LISTA QUE PODE SER QUALQUER TIPO QUE EXTENDA A CLASSE NUMBER ou ela mesma.   
	*/
	public double soma(ArrayList<? extends Number> lista){  //Podemos agora receber um arraylist de number, float, int, double ou qualquer outro arraylist de um tipo que extenda a classe Number.
		
		double total = 0;
		
		for(Number index : lista){
			total += index.doubleValue();	
		}
		
		return total;
	}
	
	/*
	 * O "coringa" permite especificar par�metros que atuam como um supertipos ou subtipos par�metrizados. Ele � representado com "?"
	 * No m�todo abaixo, poderiamos precisar fazer uma soma de elementos de dentro de um ArrayList. Poder�amos querer aceitar somente as superclasses, ou os "pais" das classes...
	 * Para somar isso precisamos ent�o do "?"
	 * Os par�metros s�o as superclasses da classe String no m�todo abaixo, ou seja, "pais" dessa classe.
	 * A linha abaixo � um PAR�METRO LISTA QUE PODE SER QUALQUER TIPO QUE SEJA SUPERCLASSE DA CLASSE STRING.   
	*/
	public double soma2(ArrayList<? super String> lista){  //Podemos agora receber um arraylist de number, float, int, double ou qualquer outro arraylist de um tipo que extenda a classe Number.		
		return 0;
	}
	
	public static void main(String args[]){
		
		Coringa<String> gc = new Coringa<>();
		gc.setElemento("Lago Parano�");
		/*g.setElemento(123);    // O m�todo ao lado ficar� restrito no caso de receber um inteiro. Foi declarado acima que o tipo gen�rico da classe � String      */
		System.out.println(gc.getElemento().toUpperCase());  //J� � poss�vel acessar os m�tos da classe String.
		
	}
}
