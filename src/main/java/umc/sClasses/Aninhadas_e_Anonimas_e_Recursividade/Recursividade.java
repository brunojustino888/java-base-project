package umc.sClasses.Aninhadas_e_Anonimas_e_Recursividade;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Recursividade {

	
	public static int soma(int x){
		if(x==0){
			return x;
		}else{
			//System.out.println(x);
			return x + soma(x-1);
		}
		
	}
	
	public static void listar(Path path){
		if(Files.isRegularFile(path)){
			System.err.println(path.toAbsolutePath());
		}else {
			System.out.println(path.toAbsolutePath());
			try {
				DirectoryStream<Path> ds = Files.newDirectoryStream(path);
				for (Path p : ds){
					listar(p);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static int potencia(int x, int y){
		if(y==1){
			return x;
		}else{
			return x * potencia(x, y-1);
		}
	}
	
	public static void main(String[] args) {
	
			System.out.println(soma(10));
			System.out.println(potencia(3,5));
			listar(Paths.get("D://Videos//Programa��o & Tecnologia//XTI"));
	}

}
