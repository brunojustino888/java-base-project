package umc.systemRuntime;


import java.io.IOException;
import java.util.Properties;
import java.util.Set;



public class SistemaOPeracional {

	public static void main(String[] args) {
		Properties p = System.getProperties();
		System.out.println(p.getProperty("java.version"));
		
		//Mostra chave e valor das propriedades coletadas
		Set<Object> pk = p.keySet();
		for(Object fk:pk){
			System.out.println(fk +" = "+p.get(fk));
		}
		
		
		try {
			Runtime.getRuntime().exec("notepad");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
