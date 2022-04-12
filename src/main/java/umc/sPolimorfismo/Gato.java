/*
 * Exemplo de Heran�a: ultiliza as classes gato,galinha, animal e animaltest
 */
package umc.sPolimorfismo;

/**
 * @author Bruno Alves Justino
 * Data: 29/10/2012
 */
public class Gato extends Animal{
    
	public Gato (){
		super(500,"Whiskas");
		}
	
	public void Barulho(){
		System.out.println("MINHAU!");  
	}
	
	
	
}
