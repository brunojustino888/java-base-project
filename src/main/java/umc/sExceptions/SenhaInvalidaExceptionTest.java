package umc.sExceptions;

import javax.swing.JOptionPane;

public class SenhaInvalidaExceptionTest {
 
	
	public static void autenticar(String senha) throws SenhaInvalidaException{  //necess�rio declarar na assinatura do m�todo que ser� lan�ada (feita) uma excess�o
		
		if("888".equals(senha)){
			//autenticado
			JOptionPane.showMessageDialog(null,"Autenticado","Autentifica��o Realizada com Sucesso.",1);
		}else{
			//senha incorreta
			throw new SenhaInvalidaException("Senha Incorreta" +senha);
		}
		
	}
	
	
	
	public static void main(String[] args) {
 
		try{
			autenticar("8880");
		}catch(SenhaInvalidaException b){
			
			System.out.println(b.getMessage());
			b.printStackTrace();
			
		}
		
	}

}
