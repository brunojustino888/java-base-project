/*
 * Exemplo de Heran�a: ultiliza as classes gato,galinha, animal e animal teste
 */
package umc.sClasses.Abstratas;

/**
 * @author Bruno Alves Justino
 * Data: 29/10/2012
 */
public abstract class Animal{
    
	//a classe abstrata n�o pode ser instanciada
	
    public void metodo(){    }
 
    //m�todo � ser implementado....ele precisa ser implementado nas outras classes que extend essa
    public abstract void Barulho();
    
  
    
}
