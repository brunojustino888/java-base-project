package umc.sSocket;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientConselho {

	private static Socket s;

	public static void main(String[] args) {
	
			try {
				s = new Socket("localhost",7088);
				
				byte[] line2 = new byte[100];	
				InputStream is = s.getInputStream();
				line2 = "Mensagem Encaminhada � aplica��o Client".getBytes();
				is.read(line2);
				String retorno = new String (line2);
				System.out.println("Mensagem Obtida pelo Servidor = "+retorno);
			} catch (UnknownHostException e){}catch(IOException e){e.printStackTrace();	}
			
	}

}