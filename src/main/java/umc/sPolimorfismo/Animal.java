/*
 * Exemplo de Heran�a: ultiliza as classes gato,galinha, animal e animal teste
 */
package umc.sPolimorfismo;

/**
 * @author Bruno Alves Justino
 * Data: 29/10/2012
 */
public class Animal{
    
    double dMassa;
    String sComida;
    
    public Animal(double p, String c){
    	dMassa = p;
    	sComida = c;
    }
    
    public void Dormir(){
        System.out.println("ZZZZzzzzZZzzzZZZZzzzZZzz...");
    }
    
    public void Barulho(){
     System.out.println("Fazendo Barulho...");   
    }
    
    public void Mostrar(){
    	System.out.println("Comida = "+sComida+"\nPeso = "+dMassa);
    }
    
    
}
