package umc.strategy;


public class ConcreteStrategyRGM implements DocumentoStrategy{

	@Override
	public boolean validarDocumento(String doc) {
		// Algoritmo de Valida��o de RGM
		
		if(doc.equals("RGM V�lido")){
			return true;
		}else{
			return false;
		}
		
	}
}