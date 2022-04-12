package umc.sInterfaces;

public class Quadrado implements CalculaArea{

	public int lado;
	
	
	
	//construtor para receber um n�mero inteiro como par�metro e atribuir no atributo lado
	public Quadrado(int la){
		this.lado = la;
	}




	@Override
	//m�todo implementado da interface CalculaArea que retorna a �rea do quadrado
	public double calcularArea() {
		return lado *lado;
	}
	
	
	
	
}
