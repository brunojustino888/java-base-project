package umc.rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Loja extends UnicastRemoteObject implements LojaRemota {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Produto[] produtos;
	int proxima;
	
	public Loja(int tamanho) throws RemoteException {
		
		super();
		
		this.produtos = new Produto[tamanho];
		this.proxima = 0;
	}
	
	public synchronized String inserirProduto(String nome, int preco) throws RemoteException {
		
		if (this.proxima == this.produtos.length) {
			
			proxima = 0;	
		}
		
		produtos[proxima] = new Produto(nome,preco);
		String retorno = "Produto '" + nome + "' de custo R$ " + preco + ",00 inserido com sucesso.";
		System.out.println(retorno);
		proxima++;
		return retorno;
	}
	
	public synchronized int procurarPosicao (String nome) {
		
		int i = 0;
		
		while (i < this.produtos.length){
			
			if (this.produtos[i] != null && produtos[i].getNome().equalsIgnoreCase(nome)) {
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	public synchronized String removerProduto(String nome) throws RemoteException, Excecao {
		
		int i = this.procurarPosicao(nome);
		
		if (i != -1) {
			
			this.produtos[i] = this.produtos[proxima-1];
			this.produtos[proxima-1] = null;
			proxima = proxima -1;
			String retorno = "Produto '" + nome + "' removido com sucesso." ;
			System.out.println(retorno);
			return retorno;
		} else {
			
			throw new Excecao("Produto '" + nome + "' n�o encontrado");
			
		}
		
	}
	
	public synchronized String procurarProduto(String nome) throws RemoteException, Excecao {
		
		int i = this.procurarPosicao(nome);
		
		if (i != -1) {
			Produto produto = produtos[i];
			String retorno = "O produto '" + produto.getNome()+ "' custa R$ " + produto.getPreco() + ",00.";
			System.out.println(retorno);
			return retorno;
			
		} else throw new Excecao("Produto '" + nome + "' n�o encontrado");	
		
	}
	
	public synchronized String alterarPreco(String nome, int valor) throws RemoteException {
		
		int i = this.procurarPosicao(nome);
		Produto produto = this.produtos[i];
		produto.setPreco(valor);
		String retorno = "O produto '" + produto.getNome()+ "' teve seu custo atualizado para R$ " + produto.getPreco() + ",00.";
		System.out.println(retorno);
		return retorno;
	}
	
	public static void main (String args[]) {
		
		try {
			Loja loja = new Loja(10);
			@SuppressWarnings("unused")
			Registry r = LocateRegistry.createRegistry(2126);
			Naming.rebind("rmi://localhost:2126/lojinha", loja);
			System.out.println("Servidor no ar!");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		}
		
	}
	
}