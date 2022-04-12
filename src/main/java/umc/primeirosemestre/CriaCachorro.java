package umc.primeirosemestre;

public class CriaCachorro {

	public static void main(String[] args) {
		
		Cachorro cerberus = new Cachorro();
		cerberus.raca = "Cerberus";
		cerberus.tamanho = 800;
		cerberus.latir();
		
		Cachorro pastor = new Cachorro();
		pastor.tamanho = 100;
		pastor.raca = "Pastor Alem�o";
		pastor.latir();
		
		
	}
}
