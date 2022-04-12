package umc.primeirosemestre;

public class RaizPell {

	int raiz(int numero){
		
		int impar = 1;
		int raiz = 0; 
		
		while(numero>=impar){
		numero = numero - impar;
		impar= impar+2;	
		++raiz;
		}
		
		return raiz;
		
		
	}
	
	
	
	
}
