package interfaceXmlEnergiza;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

 /*	
 * Essa classe ser� chamada para apagar e alterar um determinado usu�rio do arquivo NotDelete do txt
 * Para fazer essa tarefa: essa classe primeiro copia todos os usu�rios do txt para dentro de um arrayList.
 * Depois retira desse arraylist o usu�rio que ser� apagado ou alterado.
 * Posteriormente, ela sobrescreve o arquivo NotDelete com um arquivo txt em branco para inserir o arrayList de usu�rios.  
 */

public class UserDelete {

	//Atributos da classe
	private String privilegio;
	private ArrayList<String> usuarios;
	private int index=0;
	
	
	//O contrutor recebe como par�metro o hashcode do usu�rio � ser manipulado e o privil�gio de acesso do usu�rio logado
	public UserDelete(String hc , String p){
		privilegio = p;
		usuarioExiste(hc);
	}
	
		
	//Esse m�todo � respons�vel por ler o txt de usu�rios, verificar se o usu�rio existe
	//e preencher o array de usu�rios que ser� incluso no m�todo EscreveUsu�rios()
	public boolean usuarioExiste(String hc){
    	boolean existe = false;
    	String linha = "";
    	String arrayDoUsuario[] = new String[2];
    	int iQuantidadeLinhasTxt = 0;
    	FileReader frLeitor;
    	BufferedReader bfLeitor;
    	try {
				frLeitor = new FileReader("X:\\NotDelete.txt");
				bfLeitor = new BufferedReader(frLeitor);
				usuarios = new ArrayList<String>();
					
				while((linha = bfLeitor.readLine()) != null) {
					usuarios.add(linha);
					arrayDoUsuario = linha.split("J");
					iQuantidadeLinhasTxt++;
					if(arrayDoUsuario[0].toString().equals(hc)){
						index = iQuantidadeLinhasTxt;
					}
						
				}

				bfLeitor.close();
				frLeitor.close();
				
				if(usuarios.size()>0){
					usuarios.remove(index-1);
					escreveUsuarios();
				}
				
				JOptionPane.showMessageDialog(null,"Usu�rio Apagado com Sucesso!","Opera��o Completa.",1);
				
    	}catch(IOException | ArrayIndexOutOfBoundsException eef){
    			JOptionPane.showMessageDialog(null,"Esse usu�rio n�o est� cadastrado.\nPortanto � imposs�vel apag�-lo.","Opera��o Inv�lida!",0);
    			new InterfaceWittel2(privilegio);
    			return false;
    		}
    	return existe;
    }
	
	
	//Esse m�todo escreve um arraylist de usu�rios no txt em branco.
	public void escreveUsuarios(){
		
		try {
			FileWriter fw = new FileWriter("X:\\NotDelete.txt",false);
			BufferedWriter bw = new BufferedWriter(fw);  
			PrintWriter pw = new PrintWriter(bw); 

			for(int i=0;i<usuarios.size();i++){
				pw.println(usuarios.get(i));
			}
			
			fw.flush();
			bw.flush();
			pw.flush();
			pw.close(); 
			fw.close(); 
			bw.close();
			System.gc();
			new InterfaceWittel2(privilegio);
			
		   } catch (IOException ex) {System.out.println("escreveusuarios()");} 
    }


}
