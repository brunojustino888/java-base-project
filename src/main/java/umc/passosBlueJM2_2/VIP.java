package umc.passosBlueJM2_2;

public class VIP extends Ingresso{

	private double valorAdicional;
	
	//M�todo sobrescrito
	public void imprimirValor(){
		System.out.println("O valor do ingresso VIP � "+(valorAdicional+this.getValor())+" reais.");
	}
	
	
	
}
