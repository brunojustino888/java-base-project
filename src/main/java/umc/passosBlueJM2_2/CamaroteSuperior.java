package umc.passosBlueJM2_2;

public class CamaroteSuperior extends VIP{

	private String localizacao;
	private double adicionalCamarote;
	
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
	
	//M�todo para mostrar o valor do ingresso
	public void exibirValor(){
		System.out.println("O valor do ingresso (com adicional incluso) � de R$"+(this.getValor()+adicionalCamarote));
	}
	
	
}
