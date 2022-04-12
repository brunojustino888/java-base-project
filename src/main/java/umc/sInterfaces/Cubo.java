package umc.sInterfaces;

public class Cubo implements CalculaArea,CalculaVolume {


	double lado;
	
	
	public Cubo(double d){
		this.lado = d;
	}
	
	
	
	
	@Override
	public double calcularArea() {
		return lado*lado*lado;
	}


	@Override
	public double calcularVolume() {
		return 6*lado*lado;
	}


	
	
	
}
