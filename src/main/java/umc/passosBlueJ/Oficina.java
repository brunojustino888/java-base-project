package umc.passosBlueJ;


public class Oficina {
    public static void main(String args[])    {
    	
         Motor oMMM = new Motor(2500,150,4);
         Carro oCarroDebora = new Carro(2010,"CHEVROLET","ASTRA","DDD 1234",oMMM);
         oCarroDebora.imprimirCarro();
    
    }
    
}