package umc.rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LojaRemota extends Remote {

	public String inserirProduto(String nome, int preco) throws RemoteException; 
	
	public String removerProduto(String nome) throws RemoteException, Excecao;
	
	public String procurarProduto (String nome) throws RemoteException, Excecao;
	
	public String alterarPreco (String nome, int valor) throws RemoteException, Excecao;
}
