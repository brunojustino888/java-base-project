package umc.sString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArquivoI {
 
	public static void main(String[] args) {
 
		
		Path caminho = Paths.get("C:\\Exemplo\\john.txt");	//indica o caminho uri
		Charset utf8 = StandardCharsets.UTF_8; //coloca na variavel utf8 o padr�o de escrita do texto
		
		
		/* Esccrita */
		try(BufferedWriter w = Files.newBufferedWriter(caminho,utf8);){	 // o m�todo newbufferedwriter recebe como parametro o caminho do arquivo e o padrao da escrita. precisa de uma vari�vel para retorno do valor
		w.write(1);
		w.write("O padrao 1utf8"); 
		}catch(IOException s){
		s.printStackTrace();
		}
	
		
		/* Leitura */
		try (BufferedReader r = Files.newBufferedReader(caminho, utf8)){
			String linha =null;
			while((linha = r.readLine())!= null){
				System.out.println(linha); // vai imprimir tudo o que tem dentro do arquivo
			}
		}catch(IOException l){
			l.printStackTrace(); //imprimi a exce��o		}
	}

	}
}
