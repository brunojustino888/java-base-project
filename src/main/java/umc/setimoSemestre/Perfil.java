package umc.setimoSemestre;

public class Perfil {
	
	private String nome;
	private static int id;
	
	public Perfil (){
		id++;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	
}