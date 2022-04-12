package umc.sString;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Arrays;

public class Serializa {


	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String[] palavras = {"Iron Maiden", "Judas Priest", "Rhapsody", "Megadeth"};
		
		//Escrita de Objetos
		FileOutputStream fos = new FileOutputStream ("C:\\Exemplo\\bandas.ser"); //vai armazenar o caminho da sa�da do arquivo em bytecode
		ObjectOutputStream oos = new ObjectOutputStream(fos); //recebe como parametro um obejto do tipo FileOutpuStream
		oos.writeObject(palavras); //m�todo que escreve um objeto em bytecode no caminho especificado
		oos.close();//m�todo para fechar o arquivo
		
		//Leitura de Objetos
		FileInputStream fis = new FileInputStream("C:\\Exemplo\\bandas.ser"); //local onde est� o arquivo .ser
		ObjectInputStream ois = new ObjectInputStream(fis); //classe que vai carregar o objeto na mem�ria
		String[] casts = (String[]) ois.readObject(); //m�todo para ler o objeto....essem�todo retorna um objeto (e um objeto � um array de strings) por isso podemos fazer um cast...atribuindo o retorno do m�todo em um novo array
		ois.close();
		System.out.println(Arrays.toString(casts));
		
	}

}
