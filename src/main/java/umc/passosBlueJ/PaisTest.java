package umc.passosBlueJ;

public class PaisTest {

	
	public static void main(String[] args) {
		
		Pais s = new Pais("Brasil", "Bras�lia", 2000.50);
		System.out.println("Pais: "+s.getNome());
		System.out.println("Dimens�o: "+s.getDimensao());
		System.out.println("Capital: "+s.getCapital());
		
		Continente oAmericaDoSul = new Continente();
		oAmericaDoSul.construirContinente();
		System.out.println(oAmericaDoSul.calcularArea());
		
	}

}
