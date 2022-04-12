package umc.passosBlueJ;


//segue ai uma classe matematica feita e mais comentada possivel ..


public class JMatematica {

	public int resultado; //esse � atributo da classe
	
	public void mostrarSoma(int inicio,int fim) { //o metodo nao retorna nada , traz a soma dos intervalos e recebe como parametro dois inteiros(2,6)   
	resultado = 0; // como s� existe um resultado na classe, � necess�rio "zerar-lo" sempre que esse m�todo for chamado...
			
		
		
	for(int i = inicio;i<fim;i++) { // o 1 la�o = ao primeiro n�mero;at� que o la�o chegue ao ultimo numero;la�o+1
				
	if((i==inicio)||(i==fim)){ // se o la�o for igual ao primeiro ou ultimo numero
		//ele nao passa no la�o...pula
	} else { // sen�o o resultado � um acumulador+o numero do la�o....
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
