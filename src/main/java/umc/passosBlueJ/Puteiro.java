package umc.passosBlueJ;

public class Puteiro {

	private static Puta putas[];
	private static String nomeFantasia;
	

	public static void main(String[] args){
		
		nomeFantasia = "Club Master";
		
		putas = new Puta[5];
		putas[3]= new Puta(25,35,"Melissa");
		putas[3].imprimir("c");
		
		
		System.out.println(putas[3].GetNomePulta());
		System.out.println(nomeFantasia);
		
	}
	

}
