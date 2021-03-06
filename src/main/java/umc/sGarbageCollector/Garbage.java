package umc.sGarbageCollector;

import java.util.ArrayList;
import java.util.List;

public class Garbage {

	
	public static long carregarMemoria(){
		List<Integer> lista = new ArrayList<>();
		for(int i = 0 ; i< 100_000; i++){
			lista.add(i);
		}
		return Runtime.getRuntime().freeMemory();
	}
	
	
	public static void main(String[] args) {

		Runtime rt = Runtime.getRuntime();
		int MB = 1_1048_576;
		double total = rt.maxMemory()/MB;
		double inicio = total - (carregarMemoria()/MB);
		
		rt.runFinalization();
		rt.gc();
		
		double fim = total - (rt.freeMemory()/MB);
		System.out.println("Inicio: "+inicio + " Fim: "+fim);

	}

}
