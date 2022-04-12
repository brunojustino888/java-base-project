package umc.sString;


import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArquivoIIIII {
 
 	
	public static void main(String[] args) throws IOException {
/* 
		ArrayList<Conta> contas = new ArrayList<>();
		contas.add(new Conta("Bruno",888.88));
		contas.add(new Conta("John",3333.33));
		contas.add(new Conta("Daniela", 999999999.12));
		contas.add(new Conta("Vinicius",99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.99));
		
		ArquivoIIIII iiop = new ArquivoIIIII();
		iiop.escrever(contas);
		//iiop.recuperar();
		
		*/
	}

	
	public static void escrever(ArrayList<Conta> tca) throws IOException{
		
		try(FileOutputStream fos = new FileOutputStream ("C:\\Exemplo\\nomesSerializados.ser")){//vai armazenar o caminho da sa�da do arquivo em bytecode
			try(ObjectOutputStream oos = new ObjectOutputStream(fos) /*recebe como parametro um obejto do tipo FileOutpuStream*/){
			
				ArrayList<Conta> contas = new ArrayList<>();
				contas.add(new Conta("Bruno",888.88));
				contas.add(new Conta("John",3333.33));
				contas.add(new Conta("Daniela", 999999999.12));
				contas.add(new Conta("Vinicius",99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.99));
				
				oos.writeObject(tca);
				oos.close();
			}
		}
	}
	

	

	/*
	 public ArrayList<Conta> recuperar() throws IOException, ClassNotFoundException{
	
		 	try(FileInputStream fis = new FileInputStream("C:\\Exemplo\\nomesSerializados.ser")){ //local onde est� o arquivo .ser
		 		try(ObjectInputStream ois = new ObjectInputStream(fis); {//classe que vai carregar o objeto na mem�ria
		 			return (ArrayList<Conta>) ois.readObject();
		 		}
		 	}
			
		 
	 }

*/
}