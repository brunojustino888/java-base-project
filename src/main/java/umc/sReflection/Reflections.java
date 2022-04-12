package umc.sReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class Reflections {

	public static void main (String[] args) throws Exception{
		
		String nome = "PassosBlueJ.Puta";
		@SuppressWarnings("rawtypes")
		Class classe = Class.forName(nome);
		System.out.println(classe.getSimpleName());	
		
		java.lang.reflect.Field[] campos = classe.getFields();
		for (@SuppressWarnings("unused") java.lang.reflect.Field f: campos){
			System.err.println(campos);
		}
		
		Method[] m = classe.getDeclaredMethods();
		for(Method d : m){
			System.out.println(d.getName());
		}
		
		@SuppressWarnings("rawtypes")
		Constructor[] c = classe.getConstructors();
		for(@SuppressWarnings("rawtypes") Constructor s : c){
			System.err.println(s);
		}
		
		Object o = classe.newInstance();
		@SuppressWarnings("unchecked")
		Method md = classe.getMethod("imprimir", String.class);
		md.invoke(o, "args");
	}
	
}
