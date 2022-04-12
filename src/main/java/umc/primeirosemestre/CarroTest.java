/*
 * Programa que usa as classes; Carro,Motor,CarroTest
 */
package umc.primeirosemestre;
/**
 * @author Bruno Alves Justino
 * Date: 28/10/2012
 */
public class CarroTest {
    
    public static void main(String[] args){
        
        Carro oFerrari = new Carro(); //criando um objeto do tipo carro chamado ferrari
        oFerrari.sModelo = "Ferrari Enzo";   
        oFerrari.iVelocidadeMaxima = 450;
        
        Motor oV12 = new Motor(); //aqui se cria um motor chamado oV12 que ser� atribuido abaixo no objeto oMotor do objeto ferrari 
        oFerrari.oMotor = oV12; //o objeto oMotor recebe o motor instanciado
        
        System.out.println("Carro: "+oFerrari.sModelo+".\nMotor: "+oFerrari.oMotor.GetTipo()+".\nVelocidade: "+oFerrari.iVelocidadeMaxima+"Km/h.");
    }
}
