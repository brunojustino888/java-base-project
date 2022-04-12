package umc.strategy;
public class Context {

	public static void main(String[] args) {
		
		String numerodocumento = "192.168.001-45";
		
		DocumentoStrategy doc = new ConcreteStrategyCPF();
		
		System.out.println(doc.validarDocumento(numerodocumento));
		
	}

}
