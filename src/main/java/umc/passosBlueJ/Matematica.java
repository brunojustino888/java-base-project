package umc.passosBlueJ;

//Faz parte dos Exercicios 4 e 3 ... o exerc�cio 3 foi separado propositalmente
//devido o enunciado da quest�o dizer que os m�todos
//mostrarSoma e mostrarSomaPares dessa classe matematica tem que imprimir na tela os resultados.


public class Matematica {
	
	public int resultado;
	
			
		public void mostrarSoma(int inicio,int fim) {
		resultado = 0; 
			for(int i = inicio;i<fim;i++) {
				
				if((i==inicio)||(i==fim)){
				continue;
				} else {
				resultado=resultado+i;
				}
			}
			System.out.println("A soma dos intervalos entre " + inicio + " e " + fim + " � = " + resultado);
		}
	
	
		public void mostrarSomaPares(int inicio,int fim) {
		resultado = 0;
			for(int i = inicio;i<fim;i++) {
			
				if(i%2==0) {
				resultado=resultado+i;
				}
			}
			System.out.println("A soma dos Valores pares � = " + resultado);
		}
	

}
