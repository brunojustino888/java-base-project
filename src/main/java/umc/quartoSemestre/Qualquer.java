package umc.quartoSemestre;

/* O polimorfismo permite que refer�ncias de tipos de classes abstratas 
 * representem o comportamento das classes concretas que referenciam, ou seja, todos os m�todos
 * das classes abstratas precisam ser implementados e "sobrescritos" na classe em quest�o.
 */

public class Qualquer {

	public static void main(String[] args) {
		
		CartaoWeb conjunto[] = new CartaoWeb[3];
		conjunto[1] = new Natal("Joao");
		conjunto[2] = new Aniversario("Maria");
		conjunto[3] = new DiaDosNamorados("Daniela");
		
		for(int i =0;i<conjunto.length;i++){
			conjunto[i].showMessage();
		}
		

	}

}
