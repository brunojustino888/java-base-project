package umc.passosBlueJ;

public class Aeroporto {

	
	Aviao avioes[] = new Aviao[19];
	boolean avioesnoPatio[];
	String nomeAeroporto;
	String codigoAeroporto;
	boolean internacional;
	Aeroporto voosIda[] = new Aeroporto[3];
	Aeroporto voosChegada[] = new Aeroporto[3];
	
	
	//Construtor que seta os valores do nome e c�digo do aeroporto.
	public Aeroporto(String nome, String codigo){
		this.nomeAeroporto = nome;
		this.codigoAeroporto = codigo;
	}
	
	//M�todo para verificar se o aeroporto � nacional.
	public boolean verificarInternacional(){
		return internacional;
	}
		
	//M�todo para alterar se um aeroporto � internacional.
	public void isInternacional(){  			
		if (internacional == true){
			internacional =false;
		}else{
			internacional =true;
		}
	}
	
	//m�todo get do c�digo
	public String getCod(){
		return codigoAeroporto;
	}
	
	//M�todo que recebe como par�metro um aeroporto e verifica se � igual a outro.
	public boolean equals(Aeroporto o){
			if(getCod()==o.getCod())
			return true;
		else 
			return false;
		}
	
	//M�todo que recebe como par�metro o prefixo de um avi�o e verifica se a aeronave est� pousada no aeroporto.
	public boolean isPousado(String prefixo) {
		boolean o = false;
		for (int i=0;i<19;i++){
				if(avioes[i].getPrefixo() == prefixo) {
					o= true;
				}else{
					o= false;
				}
	}
		return o;
	}
	
	//M�todo que verifica se existe rota de destino para o aeroporto que foi informado como par�metro, sen�o, verificar se existe voos que est�o chegando nele que vieram do aeroporto desejado.
	public boolean possuiRota(Aeroporto informado){
		boolean a = false;
		for (int i=0;i<19;i++){
				
			if((informado.codigoAeroporto == voosIda[i].codigoAeroporto)||(informado.codigoAeroporto == voosChegada[i].codigoAeroporto))
					a=true;
				else
					a=false;
				}
		
		return a;
	}
	
	//M�todo criado na sala.
	public boolean possuiRotaPassos(Aeroporto informado){
		boolean a = false;
		for (int i=0;i<19;i++){
				
			if(informado.getCod() == voosIda[i].codigoAeroporto)
					a=true;
				else
					a=false;
		}
		
		return a;
	}
	
}
