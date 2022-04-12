package umc.passosBlueJ;

public class Pais {

	private String sNome;
	private String sCapital;
	private double dDimensao;
	
	public Pais(String nome, String capital, double dimensao){
		sCapital = capital;
		dDimensao = dimensao;
		sNome = nome;
	}

	public Pais(){

	}
	
	public double getDimensao(){
		return dDimensao;
	}
	
	public void setDimensao(double dimensao){
		dDimensao = dimensao;
	}
	
	public String getNome(){
		return sNome;
	}
	
	public void setNome(String nome){
		sNome = nome;
	}
	
	
	public String getCapital(){
		return sCapital;
	}
	
	public void setCapital(String capital){
		sCapital = capital;
	}
	
	
}
