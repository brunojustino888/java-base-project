/*
 * Programa que usa as classes; Carro,Motor,CarroTest
 */
package umc.primeirosemestre;
/**
 * @author Bruno Alves Justino
 * Date: 28/10/2012
 */
public class Motor {
    
    private String sTipo = "V12";
    private int iPotencia = 600;
    
    public Motor(){    
    }
    
    public int GetPotencia(){
        return iPotencia;
    }

    public String GetTipo(){
        return sTipo;
    }
}
