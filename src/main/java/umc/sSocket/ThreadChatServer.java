package umc.sSocket;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadChatServer {

	List<PrintWriter> escritores = new ArrayList<>();
	Scanner sc;
	
	@SuppressWarnings("resource")
	public ThreadChatServer(){
		try{ServerSocket ss = new ServerSocket(7056);
			while(true){
				Socket s = ss.accept();
				
				new Thread (new EscutaCliente(s)).start();
				
				PrintWriter p = new PrintWriter(s.getOutputStream());
				escritores.add(p);
			}
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public static void main(String[] args) {
		new ThreadChatServer();
	}

	private void encaminhaMSG(String mensagemParaEncaminhar){
		for(PrintWriter s: escritores){
			s.println(mensagemParaEncaminhar);
			s.flush();
		}
	}
	
	private class EscutaCliente implements Runnable{

		public EscutaCliente(Socket sss){
			try {
				sc = new Scanner(sss.getInputStream());
			} catch (Exception e) {e.printStackTrace();}
		}
		
		@Override
		public void run() {
			String texto;
			while((texto = sc.nextLine())!=null){
				System.out.println("Recebeu: "+texto);
				encaminhaMSG(texto);
			}
		}
	}
}
