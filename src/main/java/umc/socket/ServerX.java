package umc.socket;

import java.io.*;
import java.net.*;


public class ServerX {


	
	private static ServerSocket s;

	public static void main(String[] args) 	{
		try {
			s = new ServerSocket(9999);
			String str;
			System.out.println("Server em execu��o...");
			while (true) {
				Socket c = s.accept();
				InputStream i = c.getInputStream();
				OutputStream o = c.getOutputStream();

				do {
					byte[] line = new byte[100];
					i.read(line);		
					str = new String(line);
					str = str.trim();
					boolean escreve = false;
					
					if(str.contains("@")){
						escreve = true;
						System.out.println("String montada = "+str);
						RealizaContaX um = new RealizaContaX();
						str = um.retornaResposta(str);
						System.out.println(str);
					}
					
					
					if(escreve){
					str = str.toUpperCase();
					line = str.getBytes();

					o.write(line);
					}
					
					
				} while ( !str.trim().equals("bye") );
				c.close();
			}
		}
		catch (Exception err){
		   System.err.println(err);
		}
	}

}
