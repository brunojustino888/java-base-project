package umc.strategy;


public class ConcreteStrategyCPF implements DocumentoStrategy{

	@Override
	public boolean validarDocumento(String doc) {
		// Algoritmo de Valida��o de CPF
		
		if(doc.equals("CPF Valido")){
			return true;
		}else{
			return false;
		}
		
	}
	
}
