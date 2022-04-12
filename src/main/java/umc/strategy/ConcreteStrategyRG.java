package umc.strategy;
public class ConcreteStrategyRG implements DocumentoStrategy{

	@Override
	public boolean validarDocumento(String doc) {
		// Algoritmo de Valida��o de RG
		
		if(doc.equals("RG V�lido")){
			return true;
		}else{
			return false;
		}
		
	}
}