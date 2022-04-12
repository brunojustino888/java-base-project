package umc.passosBlueJ;

public class Puta {

	private int tamanhoSeio;
	private int idade;
	private String nome;
	public String apelido;
	
	public Puta(int t, int i ,String n){
		
		tamanhoSeio = t;
		idade = i;
		nome = n;
		
		
	}
	
	public void imprimir(String palavra){
		System.out.println(tamanhoSeio+idade+palavra );
		}
	
	public String GetNomePulta(){
	
		return nome;
	}
	
}
	