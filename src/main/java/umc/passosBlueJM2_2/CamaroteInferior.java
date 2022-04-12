package umc.passosBlueJM2_2;

public class CamaroteInferior extends VIP{

	private String localizacao;
	
	//M�todo para imprimir a localiza��o.
	public void imprimriLocalizacao(){
		System.out.println("Localiza��o: "+localizacao);
	}
	
	//M�todo get para a localiza��o.
	public String getLocalizacao(){
		return localizacao;
	}
	
	//M�todo set para a localiza��o.
	public void setLocalizacao(String local){
		localizacao = local;
	}
	
	
	
	
}
