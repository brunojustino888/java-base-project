package umc.rmi;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteLoja {

	public static void main (String args[]) {
		
		try {
			LojaRemota loja = (LojaRemota)Naming.lookup("rmi://G3C25:2126/lojinha");
			System.out.println(loja.inserirProduto("chocolate",5) );
			System.out.println(loja.inserirProduto("banana",3) );
			System.out.println(loja.inserirProduto("bala",1) );
			
			try {
				System.out.println(loja.removerProduto("chiclete"));
			} catch (Excecao e2) {
				// TODO Auto-generated catch block
				System.out.println(e2.getMessage());
			}
			try {
				System.out.println(loja.procurarProduto("bala"));
			} catch (Excecao e3) {
				// TODO Auto-generated catch block
				System.out.println(e3.getMessage());
			}
			try {
				System.out.println(loja.removerProduto("bala"));
			} catch (Excecao e3) {
				// TODO Auto-generated catch block
				System.out.println(e3.getMessage());
			}
			try {
				System.out.println(loja.procurarProduto("bala"));
			} catch (Excecao e3) {
				// TODO Auto-generated catch block
				System.out.println(e3.getMessage());
			}
			try {
				System.out.println(loja.alterarPreco("banana", 10));
			} catch (Excecao e2) {
				// TODO Auto-generated catch block
				System.out.println(e2.getMessage());
			}
			try {
				System.out.println(loja.removerProduto("roupa"));
				
			} catch (Excecao e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
			try {
				System.out.println(loja.removerProduto("bala"));
			} catch (Excecao e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
			
			try {
				System.out.println(loja.procurarProduto("banana"));
				System.out.println(loja.procurarProduto("bala"));
			} catch (Excecao e) {
				System.out.println(e.getMessage());
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
		
	}
	
}
