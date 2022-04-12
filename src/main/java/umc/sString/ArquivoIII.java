package umc.sString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ArquivoIII {

	public static void main(String[] args) throws IOException {

		Path caminho = Paths.get("C:\\Exemplo\\john.txt");
		System.out.println(Files.exists(caminho)); //verifica se o caminho existe
		Files.isDirectory(caminho); //verifica se � um diret�rio
		Files.isRegularFile(caminho); // verifica se � um arquivo valido
		Files.isExecutable(caminho); //verifica se o arquivo � executavel
		Files.isReadable(caminho); //verifica se o arquivo pode ser lido
		Files.getLastModifiedTime(caminho); //retorna a data da ultima modificacao do arquivo
		Files.size(caminho); //verifica o tamanho do arquivo
		Files.getOwner(caminho); //traz o administrador do sistema
		Files.probeContentType(caminho); //retorna o tipo do arquivo
		
		/* Exclus�o */
		//Files.delete(caminho); // deleta o arquivo, se ele na�o existir ser� lancada uma excecao
		//Files.deleteIfExists(caminho); //deleta o arquivo se ele existir...sen�o n�o lanca nada
		
		/* Cria��o */
		Path caminho2 = Paths.get("C:\\Exemplo\\criado.txt");
		Files.createFile(caminho2);
		
		/* C�pia */
		Path destino = Paths.get("C:\\Exemplo\\john45454541.txt");
		Files.copy(caminho, destino, StandardCopyOption.REPLACE_EXISTING);
		
		/* Mover */
		Path destino1 = Paths.get("C:\\Exemplo\\outro\\john.txt");
		Files.createDirectories(destino1.getParent());
		Files.move(caminho, destino1, StandardCopyOption.REPLACE_EXISTING);
	}
	

}
