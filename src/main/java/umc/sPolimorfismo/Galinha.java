/*
 * Exemplo de Heran�a: ultiliza as classes gato,galinha, animal e animal teste
 */
package umc.sPolimorfismo;

/**
 * @author Bruno Alves Justino
 * Data: 29/10/2012
 */
public class Galinha extends Animal{
    
    public Galinha(){
    	super(30,"milhozinhoum");
    }
    
    
    public void Barulho(){
		System.out.println("COCOCOCOCOCOCO");  
	}
    
}
