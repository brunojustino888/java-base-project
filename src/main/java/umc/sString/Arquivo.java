package umc.sString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Leitura e escrita de Arquivos
public class Arquivo {
 
	public static void main(String[] args) throws IOException {
		 
		/*M�todos das Classes Path e Paths */
		Path caminho = Paths.get("C:\\Exemplo\\john.txt"); //Path � uma classe dispon�vel apartir do java 7 e caminho � uma vari�vel desse tipo - paths.get() serve para "pegar" a url digiada
		System.out.println(caminho.toAbsolutePath());  //m�todo que vai retornar o valor absoluto do caminho
		System.out.println(caminho.getParent());  //m�todo que vai retornar o diret�rio
		System.out.println(caminho.getRoot());  //m�todo que vai retornar a raiz do arquivo
		System.out.println(caminho.getFileName());  //m�todo que vai retornar o nome do arquivo 
		
		/*Cria��o de diret�rios*/
		Files.createDirectories(caminho.getParent()); //vai criar a pasta Exemplo no C:
		
		/*Escrever e Ler Arquivos com a Classe Files*/
		byte conjuntoBytes[] = "Java 62.".getBytes(); //array de bytes para guardar o retorno do m�todo getBytes com o conjunto de bytes que existe na palavra escrita
		Files.write(caminho, conjuntoBytes); //m�todo que vai "escrever" no caminho o conjunto de bytes -  esse m�todo cria,limpa e escreve
		byte bytesLidos[] = Files.readAllBytes(caminho); //vai receber um aaray de bytes do arquivo que est� no caminho
		System.out.println(new String(bytesLidos));//Vai converter o array de bytes para uma String e mostrar na tela
		
	}

}
