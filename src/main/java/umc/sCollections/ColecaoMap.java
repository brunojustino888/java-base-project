package umc.sCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ColecaoMap {

	public static void main(String[] args) {
		
		//Map � uma classe com chave e valor. Abaixo temos que definir um tipo para a chave e outro para o valor.
		Map<String,String> pais = new HashMap<>();
		pais.put("BR", "Brasil"); //Incluindo chave-valor...
		pais.put("RU", "Russia"); //Incluindo chave-valor...
		System.out.println(pais);
		pais.containsKey("BR");	      //Verifica a ocorr�ncia de uma determinada chave no mapa.
		pais.containsValue("Russia"); //Veririca a ocorr�ncia de um determindado valor e retorna true ou false.
		pais.get("RU");				  //Retorna o conteudo de uma determinada chave.
		pais.remove("RU");			  //Remove uma determinada chave-valor do mapa.
		
		Set<String> chaves = pais.keySet();	//Adiciona os valores em uma determinada lista(SET) 
		System.out.println(chaves);
	}

}
