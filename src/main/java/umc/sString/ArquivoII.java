package umc.sString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArquivoII {
 
	
	static Path caminho = Paths.get("C:\\Exemplo\\john.txt");
	static Charset utf8 = StandardCharsets.UTF_8; //coloca na variavel utf8 o padr�o de escrita do texto
	
	
	public static void main(String[] args) throws IOException {
 
		
		ArrayList<Conta> contas = new ArrayList<>();
		contas.add(new Conta("Bruno",888.88));
		contas.add(new Conta("John",3333.33));
		contas.add(new Conta("Daniela", 999999999.12));
		contas.add(new Conta("Vinicius",99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.99));
		
		ArquivoII iop = new ArquivoII();
		//   iop.escrever(contas);
		iop.recuperar();
		
		
	}

	
	public static void escrever(ArrayList<Conta> tca) throws IOException{
		
		try(BufferedWriter w = Files.newBufferedWriter(caminho, utf8)){
		
			for(Conta ta: tca){
				w.write(ta.getCliente() +"-"+ta.getSaldo()+"\n\t");
			}
		}

	}

	
	 public ArrayList<Conta> recuperar() throws IOException{
	
		 ArrayList<Conta> contas = new ArrayList<Conta>();
		 try(BufferedReader r = Files.newBufferedReader(caminho, utf8)){
			 
			 String linha = null;
			 while( (linha = r.readLine() ) != null) {
				 
				 String[] t = linha.split(";"); 
				 Conta u = new Conta(t[0],Double.parseDouble(t[1]));
				 contas.add(u);
			 }
		 }
		return contas;
		 
	 }


}
