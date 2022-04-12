package umc.sInterfaces;

public class InterfaceTest {

	
	public static void area(CalculaArea o){

		System.out.println(o.calcularArea());
		
	}
	
	public static void main(String[] args){
		
		Quadrado um = new Quadrado(8);
		System.out.println(um.calcularArea()+"\n");
		
		
		Cubo dois = new Cubo(8);
		System.out.println(dois.calcularArea());
		System.out.println(dois.calcularVolume()+"\n");
		
		
		//CalculaArea tres = um;  //aqui estou colacando o quadrado no tipo Calcula Area
		
		area(new Cubo(3));
		
		
		
	}
	
}
