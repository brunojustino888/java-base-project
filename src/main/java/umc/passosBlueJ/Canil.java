package umc.passosBlueJ;

public class Canil {
	
	String nome;
	Cachorro matilha[];
	
	public Canil(int quantidade){
		
		nome = "Canil";
		matilha = new Cachorro[quantidade];
	}
	
	
	public void informacoes() {
		
		System.out.println("Esse � um "+nome);
		System.out.println("Aqui tem "+matilha.length+ " cahorros.");
		
		
	}
	
	
}
