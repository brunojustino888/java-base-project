/*
 * Exemplo de Heran�a: ultiliza as classes gato,galinha, animal e animal teste
 */
package umc.sPolimorfismo;
/**
 * @author Bruno Alves Justino
 * Data: 29/10/2012
 */
public class AnimalTest {

	public static void barulhos(Animal o){   //m�todo para receber um tipo de animal e chamar o metodo barulho desse animal 
		o.Barulho();		
	}
	
    
    public static void main(String[] args) {
        
        Gato bichano = new Gato();
        bichano.Barulho();
        bichano.Dormir();
        bichano.Mostrar();
        
        Galinha carijo = new Galinha();
        carijo.Barulho();
        carijo.dMassa = 120.65;
        carijo.sComida = "Milho";
        carijo.Mostrar();
        
        
        Animal desconhecido = new Animal(0,null);
        desconhecido.Barulho();
        
        barulhos(carijo);
        barulhos(desconhecido);
        barulhos(bichano);
        
        
        
    }
    
    
}
