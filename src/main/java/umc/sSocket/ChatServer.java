package umc.sSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

	Scanner sc;
	
	@SuppressWarnings("resource")
	public ChatServer(){
		try{ServerSocket ss = new ServerSocket(7056);
		while(true){
			Socket s = ss.accept();
			sc = new Scanner(s.getInputStream());
			System.out.println(sc.nextLine());
		}
		}catch(Exception e) {e.printStackTrace();}
	}
	
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
