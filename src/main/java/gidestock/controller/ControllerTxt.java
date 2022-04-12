package gidestock.controller;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ControllerTxt {

	private ArrayList<String> linhas;
	
	public ArrayList<String> getLineTxt(){
    	String linha = "";
    	FileReader frLeitor;
    	BufferedReader bfLeitor;
    	try {
				frLeitor = new FileReader("C:\\sai\\Palavras.txt");
				bfLeitor = new BufferedReader(frLeitor);
				linhas = new ArrayList<String>();
					
				while((linha = bfLeitor.readLine()) != null) {
					linhas.add(linha);
				}

				bfLeitor.close();
				frLeitor.close();
				
    	}catch(Exception eef){
    			criarTxt();
    			getLineTxt();
    	}
    	
    	return linhas;
    }
	
	public int getQuantidadeLinhas(){
		int linhas = 0;
    	@SuppressWarnings("unused")
		String linha = "";
    	FileReader frLeitor;
    	BufferedReader bfLeitor;
    	try {
				frLeitor = new FileReader("C:\\sai\\Palavras.txt");
				bfLeitor = new BufferedReader(frLeitor);

				while((linha = bfLeitor.readLine()) != null) {
					linhas++;
				}

				bfLeitor.close();
				frLeitor.close();
				
    	}catch(Exception eef){
    			criarTxt();
    			getLineTxt();
    	}
    	
    	return linhas;
    }
	
	
	public void criarTxt(){
		try {
			FileWriter fw = new FileWriter("C:\\sai\\Palavras.txt",false);
			BufferedWriter bw = new BufferedWriter(fw);  
			PrintWriter pw = new PrintWriter(bw); 

			pw.println("UVA");
			pw.println("GATO");
			pw.println("MARIA");
			pw.println("SOL");
			pw.println("LUA");
			fw.flush();
			bw.flush();
			pw.flush();
			pw.close(); 
			fw.close(); 
			bw.close();
			System.gc();
			
		   } catch (IOException ex) {ex.printStackTrace();} 
    }
	
	
	
		public void escrevepalavra(String palavra){
			
			try {
				FileWriter fw = new FileWriter("C:\\sai\\Palavras.txt",true);
				BufferedWriter bw = new BufferedWriter(fw);  
				PrintWriter pw = new PrintWriter(bw); 

				pw.println(palavra);
				fw.flush();
				bw.flush();
				pw.flush();
				pw.close(); 
				fw.close(); 
				bw.close();
				System.gc();
 			
			   } catch (IOException ex) {ex.printStackTrace();} 
	    }
		
}