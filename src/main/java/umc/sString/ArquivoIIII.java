package umc.sString;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArquivoIIII {
 
	public static void main(String[] args) throws IOException {
 
		//listar diretorios
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path s : dirs){
			System.out.println(s);
		}
		
		//listar conte�do do diret�rio
		Path dir = Paths.get("C:\\");
		try( DirectoryStream<Path> st = Files.newDirectoryStream(dir) ) {
		
			for( Path ww: st){
				System.out.println(ww);
			}
			
			
		}catch (IOException | DirectoryIteratorException e){
			e.printStackTrace();
		}
		
		
		
		//listar parti��es
		FileSystem fs = FileSystems.getDefault();
		for (FileStore sss : fs.getFileStores() /*retorna um iterable de fileStores*/){
			System.out.println("Unidade: "+sss.toString());
			System.out.println("Espa�o Total: "+sss.getTotalSpace());
			System.out.println("Espa�o Usado: "+(sss.getTotalSpace()-sss.getUsableSpace()));
			System.out.println("Espa�o Disponivel: "+sss.getUsableSpace()+"\n");
		}
		
		
	}

	
}
