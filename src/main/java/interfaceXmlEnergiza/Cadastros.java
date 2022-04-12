package interfaceXmlEnergiza;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.JOptionPane;

/*	
* Essa classe � chamada quando o usu�rio logado clica no bot�o cadastros. 
* Ela vai receber como par�metro o privil�gio de acesso do usuario logado e disponibilizar as op��es de gerencimento dos 
* usu�rios da aplica��o.  (Privil�gio 0 = Usu�rio Comum - Privil�gio 1 = Usu�rio Administrador)
* O construtor dessa classe receber� como par�metro a opera��o que ser� realizada e o privil�gio do usu�rio logado.
*/
public class Cadastros {

	private String privilegio;

	//O construtor decidi qual m�todo que atende a opera��o desejada do usu�rio.
	public Cadastros(String operacao , String p){

		 int aux = Integer.parseInt(operacao);
		 privilegio = p;

		 switch(aux) {
		 case 1: cadastrarUser(); break;
		 case 2: apagarUser(); 	  break;
		 }
		
	}

	//M�todo que � chamado caso o usu�rio digite a op��o n�mero 1 (Cadastrar novo usu�rio).
	public void cadastrarUser(){
		String login ="";
		try{
			login = JOptionPane.showInputDialog(null,"Digite um Login para o novo usu�rio","Cadastrar Usu�rio",1);
			while(login.length()<=4||login.length()>=10){
				login = JOptionPane.showInputDialog(null,"Digite um Login que tenha:\n*No m�nimo 5 letras.\n*No m�ximo 10 letras.","Cadastrar Usu�rio",1);
			}
			  new CadastraSenha(String.valueOf(login.hashCode()), privilegio);
		}catch(NullPointerException e2){
			
				new InterfaceWittel2(privilegio);
			
			
		
		}
	}
	
	//M�todo que ser� chamado quando a opera��o do usu�rio for o n�mero 2 (Apagar Usu�rio).
	public void apagarUser(){
		try{
			String login = JOptionPane.showInputDialog(null,"Digite o login do usu�rio � ser apagado.","Apagar Usu�rio",1);
			while(login.length()<=4||login.length()>=10){
				login = JOptionPane.showInputDialog(null,"Digite um Login que tenha:\n*No m�nimo 5 letras.\n*No m�ximo 10 letras.","Apagar Usu�rio",1);
			}
			new UserDelete(String.valueOf(login.hashCode()), privilegio);
		}catch(NullPointerException e2){
			new InterfaceWittel2(privilegio);
		}
	}
	
	
		//Esse m�todo � respons�vel por ler o txt de usu�rios, verificar se o usu�rio existe
		//e preencher o array de usu�rios que ser� incluso no m�todo EscreveUsu�rios()
		public boolean usuarioExiste(String hc){
			
	    	boolean existe = false;
	    	String linha = "";
	    	String arrayDoUsuario[] = new String[2];
	    	FileReader frLeitor;
	    	BufferedReader bfLeitor;

	    	try {
					frLeitor = new FileReader("X:\\NotDelete.txt");
					bfLeitor = new BufferedReader(frLeitor);

					while((linha = bfLeitor.readLine()) != null) {
						arrayDoUsuario = linha.split("J");
						if(arrayDoUsuario[0].toString().equals(hc)){
							existe = true;
						}
					}

					bfLeitor.close();
					frLeitor.close();
					
	    	}catch(IOException | ArrayIndexOutOfBoundsException eef){
	    			JOptionPane.showMessageDialog(null,"Esse usu�rio n�o est� cadastrado.\nPortanto � imposs�vel apag�-lo.","Opera��o Inv�lida!",0);
	    			return false;
	    	}
	    	return existe;
	    }
	
	
	
	
}