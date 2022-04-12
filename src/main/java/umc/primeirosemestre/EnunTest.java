/*
 * Exemplo de enum
 * utiliza a enum Pe�asXadrez e a enum medida
 */
package umc.primeirosemestre;

/**
 * @author Bruno Alves Justino
 * Data: 29/10/2012
 */
public class EnunTest {
    
    public static final double PI = 3.14;
    
    public static void andar(Medida s, int total){
    	if ( s == Medida.M){
    		System.out.println(s);
    	}
    }
    
    
    
    public static void main (String[] args) {
        System.out.println(PI);
        System.out.println(PecasXadrez.BISPO);
        System.out.println(Medida.CM);
        System.out.println(Medida.CM.sNome);
       
        for (Medida i: Medida.values()){
        	System.out.println(i+" : "+i.sNome);
        }
     
        	
        	andar(Medida.M,100);
        
    } 
}
