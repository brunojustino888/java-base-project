/*
 * Exemplo de enum.
 * Ultiliza a classe EnumTest, a enum Pe�asXadrez e a enun Medida
 */
package umc.primeirosemestre;

/**
 * @author Bruno Alves Justino
 * Data: 29/10/2012
 */

public enum Medida {

	MM("Mil�metro"),CM("Cent�metro"),M("Metro");

        public String sNome;
        
        Medida(String titulo){
            
            this.sNome = titulo;
            
        }
        
}
