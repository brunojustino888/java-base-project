package umc.quartoSemestre;

public class Empregado {

	private String sNome;
	private String sSobrenome;
	private double dSalario;
	
	public Empregado(String nome,String sobrenome,double salario){
		sNome = "Carl�o";  
		sSobrenome = "sobrenome do Carl�o";  
		dSalario = 2525.55;  
	}
	
	public void setName(String nome,String sobrenome,double dSalario){
		sNome = nome;  
		sSobrenome = sobrenome;  
		this.dSalario = dSalario;  
	}
	
	public String getName(){
		return sNome;		  
	}
	
	public String getsobreName(){
		return sSobrenome;
	}
	
	public double gets(){
		return dSalario;		  
	}
	
	
}
