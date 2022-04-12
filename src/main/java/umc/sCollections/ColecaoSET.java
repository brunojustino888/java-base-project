package umc.sCollections;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ColecaoSET {

	public static void main(String[] args) {

		//Podemos incluir registros duplicados na Interface Arrays.
		String cores[]= {"Amarelo","Branco","Preto","Azul","Amarelo"};
		List<String> list = Arrays.asList(cores);
		
		//A interface Set extende a classe Collections e � uma lista que n�o permite objetos duplicados, apenas registros �nicos.
		Set<String> set = new HashSet<String>(list);  //A classe HashSet far� com que a lista tenha todos os registros, excluindo um dos registros dos registros duplicados.
		System.out.println(set);
	}

}
