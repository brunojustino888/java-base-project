package umc.tiposGenericos;


/*Essa classe possui ao lado do seu nome a reprenta��o de que ela � uma classe do tipo generica. 
O "<E>" � uma abrevia��o de element. Dessa forma, quando houver a necessidade de instanciar essa classe, � precido declarar o seu elemento. 
Por exemplo:  ClasseGenerica<String> gc = new ClasseGenerica<>()
 */


public class ClasseGenerica <E>{
	
	//O tipo "E" ser� definido pela JVM em tempo de excecu��o
	E elemento;
	
	public void setElemento(E elemento){
		this.elemento = elemento;
	}
	
	public E getElemento(){
		return this.elemento;
	}
	
	public static void main(String args[]){
		
		ClasseGenerica<String> gc = new ClasseGenerica<>();
		gc.setElemento("Lago Parano�");
		/*g.setElemento(123);    // O m�todo ao lado ficar� restrito no caso de receber um inteiro. Foi declarado acima que o tipo gen�rico da classe � String      */
		System.out.println(gc.getElemento().toUpperCase());  //J� � poss�vel acessar os m�tos da classe String.
		
		
		
		
	}
}
