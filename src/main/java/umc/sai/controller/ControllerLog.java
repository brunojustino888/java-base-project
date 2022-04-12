package umc.sai.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ControllerLog {

	private String arquivoDeLog = "C:\\SAI\\Log.txt";
	
	
    //M�todo respons�vel por logar a altera��o realizada.
    public void criarArquivoDeLog(String txt){
		try {
			FileWriter fw = new FileWriter(arquivoDeLog,true);
			BufferedWriter bw = new BufferedWriter(fw);  
			PrintWriter pw = new PrintWriter(bw); 
			pw.println("*-* "+txt+"*-*");
			fw.flush();
			bw.flush();
			pw.flush();
			pw.close(); 
			fw.close(); 
			bw.close();
		}catch(IOException e){JOptionPane.showMessageDialog(null, "Problemas ao criar o arquivo de log da aplica��o! (M�todo criarArquivoDeLog())","ERRO!",0);}    	
    }
    
	
}
