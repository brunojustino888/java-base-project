package umc.sSocket;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConsellho {

	public static void main(String[] args) {
		    System.out.println("Server em Execu��o...");
			ServerSocket ss;
			try {
					ss = new ServerSocket(7088);
					while(true){
					Socket s = ss.accept();
					OutputStream o = s.getOutputStream();
					byte[] line = new byte[100];
					line = "Mensagem Encaminhada � aplica��o Client".getBytes();
					o.write(line);
					s.close();
					}
			} catch (IOException e1) {e1.printStackTrace();}
	}
}