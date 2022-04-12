package umc.passosBlueJM2_2;

public class Ingresso {

	private double valorEmReais;
	
	//M�todo para imprimir o valor do ingresso.
	public void imprimeValor(){
		System.out.println("O valor do ingresso �: "+valorEmReais);
	}
	
	//M�todo para recuperar o valor do ingresso (Encapsulamento)
	public double getValor(){
		return valorEmReais;
	}
	
	
	
}
